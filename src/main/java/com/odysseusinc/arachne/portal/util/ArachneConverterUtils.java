/*
 *
 * Copyright 2018 Observational Health Data Sciences and Informatics
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
 * Created: May 29, 2017
 *
 */

package com.odysseusinc.arachne.portal.util;

import com.odysseusinc.arachne.commons.utils.ConverterUtils;
import com.odysseusinc.arachne.portal.exception.ConverterRuntimeException;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Component;

@Component
public class ArachneConverterUtils extends ConverterUtils {

    @Autowired
    public ArachneConverterUtils(GenericConversionService conversionService) {

        super(conversionService);
    }

    public void shallowCopy(Object to, Object from) {
        try {
            BeanUtils.copyProperties(to, from);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ConverterRuntimeException(e);
        }
    }
}
