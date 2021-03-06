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
 * Created: September 08, 2017
 *
 */

package com.odysseusinc.arachne.portal.api.v1.dto.converters.study;

import com.odysseusinc.arachne.portal.api.v1.dto.StudyDTO;
import com.odysseusinc.arachne.portal.api.v1.dto.converters.BaseConversionServiceAwareConverter;
import com.odysseusinc.arachne.portal.model.Study;
import com.odysseusinc.arachne.portal.model.StudyStatus;
import com.odysseusinc.arachne.portal.model.StudyType;

public abstract class BaseStudyDTOToStudyConverter<DTO extends StudyDTO, S extends Study> extends BaseConversionServiceAwareConverter<DTO, S> {

    @Override
    public S convert(DTO source) {

        S study = createResultObject();
        study.setEndDate(source.getEndDate());
        study.setStartDate(source.getStartDate());
        study.setDescription(source.getDescription());
        study.setTitle(source.getTitle());
        study.setType(conversionService.convert(source.getType(), StudyType.class));
        study.setStatus(conversionService.convert(source.getStatus(), StudyStatus.class));
        study.setId(source.getId());
        study.setPrivacy(source.getPrivacy());

        proceedAdditionalFields(study, source);

        return study;
    }
}
