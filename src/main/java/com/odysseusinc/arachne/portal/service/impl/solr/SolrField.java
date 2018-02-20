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
 * Created: February 09, 2017
 *
 */

package com.odysseusinc.arachne.portal.service.impl.solr;

import static com.odysseusinc.arachne.portal.service.impl.BaseSolrServiceImpl.MULTI_METADATA_PREFIX;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import org.apache.commons.lang3.StringUtils;

public class SolrField {

    public static final String META_PREFIX = "metadata_";
    private static final String TXT_POSTFIX = "_txt";
    private String name;
    private Class dataType;

    private Field field;
    private Function<Object, Object> fieldConverter = null;

    private Boolean isSearchable = Boolean.TRUE;
    private Boolean isFaceted = Boolean.FALSE;
    private Boolean isPostfixNeeded = Boolean.TRUE;

    public SolrField() {
        this.dataType = String.class;
    }

    public SolrField(final String name) {
        this();
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(final String name) {

        this.name = name;
    }

    public Class getDataType() {

        return dataType;
    }

    public void setDataType(final Class dataType) {

        this.dataType = dataType;
    }

    public Boolean getSearchable() {

        return isSearchable;
    }

    public void setSearchable(final Boolean searchable) {

        isSearchable = searchable;
    }

    public Boolean getFaceted() {

        return isFaceted;
    }

    public void setFaceted(final Boolean faceted) {

        isFaceted = faceted;
    }

    protected String getDynamicPostfix() {
        String postfix;
        // NOTE: sort on multiValued fields is not available
        if (dataType.equals(Integer.class)) {
            postfix = "_i";
        } else if (isMultiValuesType()) {
            postfix = "_ts";
        } else {
            postfix = TXT_POSTFIX;
        }
        return postfix;
    }

    public boolean isMultiValuesType(){

        return dataType.isAssignableFrom(List.class) || dataType.isAssignableFrom(Set.class);
    }

    public String getMultiValuesTypeFieldName () {

        return MULTI_METADATA_PREFIX + getName() + (this.isPostfixNeeded ? TXT_POSTFIX : StringUtils.EMPTY);
    }

    public String getSolrName() {
        return name + getDynamicPostfixIfNeeded();
    }

    protected String getDynamicPostfixIfNeeded() {

        return this.isPostfixNeeded ? getDynamicPostfix() : StringUtils.EMPTY;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SolrField solrField = (SolrField) o;
        return Objects.equals(name, solrField.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {

        return "SolrField{" +
                "name='" + name + '\'' +
                '}';
    }

    public Boolean getPostfixNeeded() {

        return isPostfixNeeded;
    }

    public void setPostfixNeeded(final Boolean postfixNeeded) {

        isPostfixNeeded = postfixNeeded;
    }

    public Field getField() {

        return field;
    }

    public void setField(final Field field) {

        this.field = field;
    }

    public Function<Object, Object> getFieldConverter() {

        return fieldConverter;
    }

    public void setFieldConverter(final Function<Object, Object> fieldConverter) {

        this.fieldConverter = fieldConverter;
    }
}
