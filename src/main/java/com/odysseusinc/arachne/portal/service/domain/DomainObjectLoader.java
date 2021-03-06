/*
 * Copyright 2018 Odysseus Data Services, inc.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Company: Odysseus Data Services, Inc.
 * Product Owner/Architecture: Gregory Klebanov
 * Authors: Pavel Grafkin
 * Created: October 12, 2017
 *
 */

package com.odysseusinc.arachne.portal.service.domain;

import java.io.Serializable;
import javax.persistence.EntityManagerFactory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.support.Repositories;

public abstract class DomainObjectLoader {

    protected Repositories repositories;
    protected EntityManagerFactory entityManagerFactory;

    protected Class domainClazz;
    protected Serializable targetId;

    public DomainObjectLoader(Class domainClazz) {

        this.domainClazz = domainClazz;
    }

    public DomainObjectLoader withServices(
            Repositories repositories,
            EntityManagerFactory entityManagerFactory
    ) {

        this.repositories = repositories;
        this.entityManagerFactory = entityManagerFactory;
        return this;
    }

    public DomainObjectLoader withTargetId(Serializable targetId) {

        this.targetId = targetId;
        return this;
    }

    public DomainObjectLoader withTargetId(Object domainObject) {

        this.targetId = getTargetId(domainObject);
        return this;
    }

    protected CrudRepository getRepository() {

        return (CrudRepository) repositories.getRepositoryFor(domainClazz);
    }

    protected Serializable getTargetId(Object domainObject) {

        return null;
    }

    public Object loadDomainObject() {

        return null;
    }
}
