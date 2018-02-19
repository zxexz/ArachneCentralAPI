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
 * Authors: Pavel Grafkin, Alexandr Ryabokon, Vitaly Koulakov, Anton Gackovka, Maria Pozhidaeva, Mikhail Mironov
 * Created: November 15, 2016
 *
 */

package com.odysseusinc.arachne.portal.service.impl;

import com.odysseusinc.arachne.portal.model.BaseDataSource;
import com.odysseusinc.arachne.portal.model.DataSource;
import com.odysseusinc.arachne.portal.model.RawDataSource;
import com.odysseusinc.arachne.portal.repository.BaseDataSourceRepository;
import com.odysseusinc.arachne.portal.repository.BaseRawDataSourceRepository;
import com.odysseusinc.arachne.portal.repository.DataSourceRepository;
import com.odysseusinc.arachne.portal.repository.RawDataSourceRepository;
import com.odysseusinc.arachne.portal.service.DataSourceService;
import com.odysseusinc.arachne.portal.service.SolrService;
import com.odysseusinc.arachne.portal.service.TenantService;
import com.odysseusinc.arachne.portal.service.impl.solr.SolrField;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@SuppressWarnings("unused")
@Transactional(rollbackFor = Exception.class)
public class DataSourceServiceImpl extends BaseDataSourceServiceImpl<BaseDataSource, RawDataSource, DataSource, SolrField> implements DataSourceService {

    public DataSourceServiceImpl(SolrService solrService, BaseDataSourceRepository dataSourceRepository, GenericConversionService conversionService, TenantService tenantService, BaseRawDataSourceRepository rawDataSourceRepository) {

        super(solrService, dataSourceRepository, conversionService, tenantService, rawDataSourceRepository);
    }

    @Override
    protected Class<?> getType() {

        return DataSource.class;
    }

    @Override
    public List<DataSource> getAllByUserId(Long userId) {

        return dataSourceRepository.getAllByUserId(userId);
    }
}
