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
 * Authors: Anton Gackovka
 * Created: December 13, 2017
 */

package com.odysseusinc.arachne.portal.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(AbstractUserStudyListItem.class)
public class AbstractUserStudyListItem_ {
    public static volatile SingularAttribute<AbstractUserStudyListItem, Long> id;
    public static volatile SingularAttribute<AbstractUserStudyListItem, Study> study;
    public static volatile SingularAttribute<AbstractUserStudyListItem, User> user;
    public static volatile SingularAttribute<AbstractUserStudyListItem, Boolean> favourite;
    public static volatile SingularAttribute<AbstractUserStudyListItem, String> role;
}
