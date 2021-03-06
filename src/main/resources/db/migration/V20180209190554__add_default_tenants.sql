ALTER TABLE tenants ADD COLUMN IF NOT EXISTS is_default BOOLEAN NOT NULL DEFAULT FALSE;

UPDATE tenants SET is_default = TRUE WHERE name = 'Everyone';

CREATE OR REPLACE FUNCTION updatable_tenant_users_view_dml()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $function$
   BEGIN
      IF TG_OP = 'INSERT' THEN
        INSERT INTO tenants_users VALUES (NEW.tenant_id, NEW.user_id);
        RETURN NEW;
      ELSIF TG_OP = 'DELETE' THEN
       DELETE FROM tenants_users WHERE tenant_id = OLD.tenant_id AND user_id = OLD.user_id;
       RETURN NULL;
      END IF;
      RETURN NEW;
    END;
$function$;

CREATE TRIGGER tenant_dependant_users_view_dml_trg
INSTEAD OF INSERT OR DELETE ON tenant_dependent_users_view
FOR EACH ROW EXECUTE PROCEDURE updatable_tenant_users_view_dml();

-- Fix for prev migration. Removes issue with delete of studies via DB directly
CREATE OR REPLACE FUNCTION study_on_last_lead_cascade()
  RETURNS TRIGGER AS $study_on_last_lead_cascade$
DECLARE
  lead_cnt$ SMALLINT;
BEGIN
  SELECT COUNT(1)
  INTO lead_cnt$
  FROM studies_users
  WHERE study_id = OLD.study_id;

  IF (lead_cnt$ < 1)
  THEN
    DELETE FROM studies_data
    WHERE id = OLD.study_id;
  END IF;

  RETURN OLD;
END;
$study_on_last_lead_cascade$ LANGUAGE plpgsql;