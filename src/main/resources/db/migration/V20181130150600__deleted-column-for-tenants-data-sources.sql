ALTER TABLE tenants_data_sources ADD COLUMN IF NOT EXISTS deleted_at TIMESTAMP;