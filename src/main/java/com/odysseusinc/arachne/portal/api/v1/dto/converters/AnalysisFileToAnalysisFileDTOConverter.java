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
 * Created: January 13, 2017
 *
 */

package com.odysseusinc.arachne.portal.api.v1.dto.converters;

import com.odysseusinc.arachne.portal.api.v1.dto.AnalysisFileDTO;
import com.odysseusinc.arachne.portal.api.v1.dto.PermissionsDTO;
import com.odysseusinc.arachne.portal.api.v1.dto.UserInfoDTO;
import com.odysseusinc.arachne.portal.model.AnalysisFile;
import org.springframework.stereotype.Component;

@Component
public class AnalysisFileToAnalysisFileDTOConverter extends BaseConversionServiceAwareConverter<AnalysisFile, AnalysisFileDTO> {

    @Override
    public AnalysisFileDTO convert(AnalysisFile source) {

        AnalysisFileDTO analysisFileDTO = new AnalysisFileDTO();
        analysisFileDTO.setImported(source.getDataReference() != null);
        analysisFileDTO.setUuid(source.getUuid());
        analysisFileDTO.setFileId(source.getId());
        analysisFileDTO.setName(source.getName());
        analysisFileDTO.setCreated(source.getCreated());
        analysisFileDTO.setUpdated(source.getUpdated());
        analysisFileDTO.setIsExecutable(source.getExecutable());
        analysisFileDTO.setLabel(source.getLabel());
        analysisFileDTO.setEntryPoint(source.getEntryPoint());
        analysisFileDTO.setAuthor(conversionService.convert(source.getAuthor(), UserInfoDTO.class));
        analysisFileDTO.setUpdatedBy(conversionService.convert(source.getUpdatedBy(), UserInfoDTO.class));
        analysisFileDTO.setAnalysisId(source.getAnalysis().getId());
        analysisFileDTO.setDocType(source.getContentType());
        analysisFileDTO.setVersion(source.getVersion());
        analysisFileDTO.setPermissions(conversionService.convert(source, PermissionsDTO.class));
        analysisFileDTO.setAntivirusStatus(source.getAntivirusStatus());
        analysisFileDTO.setAntivirusDescription(source.getAntivirusDescription());
        return analysisFileDTO;
    }
}
