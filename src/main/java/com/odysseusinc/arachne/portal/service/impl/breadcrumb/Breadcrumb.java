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
 * Created: June 13, 2017
 *
 */

package com.odysseusinc.arachne.portal.service.impl.breadcrumb;

import com.odysseusinc.arachne.portal.model.Identifiable;

public interface Breadcrumb extends Identifiable {

    EntityType getCrumbType();

    default Long getCrumbId() {

        return this.getId();
    }

    default String getCrumbTitle() {

        return null;
    }

    Breadcrumb getCrumbParent();
}
