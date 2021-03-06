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
 * Authors: Pavel Grafkin, Alexandr Ryabokon, Vitaly Koulakov, Anton Gackovka, Maria Pozhidaeva, Konstantin Yaroshovets
 * Created: January 22, 2017
 *
 */

package com.odysseusinc.arachne.portal.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "antivirus")
@Validated
public class AntivirusProperties {
    private DefaultExecutorConfigValues executor = new DefaultExecutorConfigValues();
    private RetryConfig retry = new RetryConfig();

    public DefaultExecutorConfigValues getExecutor() {
        return executor;
    }

    public void setExecutor(DefaultExecutorConfigValues executor) {
        this.executor = executor;
    }

    public RetryConfig getRetry() {

        return retry;
    }


    public static class RetryConfig {
        private int maxAttempts = 5;
        private BackOffPolicyConfig backoff = new BackOffPolicyConfig();

        public int getMaxAttempts() {

            return maxAttempts;
        }

        public void setMaxAttempts(int maxAttempts) {

            this.maxAttempts = maxAttempts;
        }

        public BackOffPolicyConfig getBackoff() {

            return backoff;
        }
    }

    public static class BackOffPolicyConfig {
        private long initialInterval = 1000L;
        private long maxInterval = 30000L;
        private double multiplier = 2.0D;

        public long getInitialInterval() {

            return initialInterval;
        }

        public void setInitialInterval(long initialInterval) {

            this.initialInterval = initialInterval;
        }

        public long getMaxInterval() {

            return maxInterval;
        }

        public void setMaxInterval(long maxInterval) {

            this.maxInterval = maxInterval;
        }

        public double getMultiplier() {

            return multiplier;
        }

        public void setMultiplier(double multiplier) {

            this.multiplier = multiplier;
        }
    }

}
