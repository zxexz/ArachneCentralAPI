/*
 *
 * Copyright 2017 Observational Health Data Sciences and Informatics
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
 * Authors: Anastasiia Klochkova
 * Created: May 24, 2018
 *
 */

package com.odysseusinc.arachne.portal.api.v1.dto;

import java.util.LinkedList;
import java.util.List;

public class UploadFilesDTO {
    private List<UploadFileDTO> files = new LinkedList<>();
    private List<UploadFileDTO> links = new LinkedList<>();

    public List<UploadFileDTO> getFiles() {

        return files;
    }

    public void setFiles(LinkedList<UploadFileDTO> files) {

        this.files = files;
    }

    public List<UploadFileDTO> getLinks() {

        return links;
    }

    public void setLinks(List<UploadFileDTO> links) {

        this.links = links;
    }
}