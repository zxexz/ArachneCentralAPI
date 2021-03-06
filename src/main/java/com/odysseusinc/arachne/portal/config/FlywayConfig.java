/*
 *
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
 * Authors: Pavel Grafkin, Alexandr Ryabokon, Vitaly Koulakov, Anton Gackovka, Maria Pozhidaeva, Mikhail Mironov
 * Created: October 11, 2016
 *
 */

package com.odysseusinc.arachne.portal.config;

import com.odysseusinc.arachne.commons.config.flyway.ApplicationContextAwareSpringJdbcMigrationResolver;
import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;

@Configuration
@ComponentScan("org.springframework.boot.autoconfigure.flyway")
public class FlywayConfig {

    @Bean
    public FlywayMigrationInitializer flywayInitializer(ApplicationContext context, Flyway flyway) {

        ApplicationContextAwareSpringJdbcMigrationResolver contextAwareResolver = new ApplicationContextAwareSpringJdbcMigrationResolver(context);
        flyway.setResolvers(contextAwareResolver);

        FlywayMigrationInitializer flywayMigrationInitializer = new FlywayMigrationInitializer(flyway, null);
        flywayMigrationInitializer.setOrder(Ordered.LOWEST_PRECEDENCE);
        return flywayMigrationInitializer;
    }
}
