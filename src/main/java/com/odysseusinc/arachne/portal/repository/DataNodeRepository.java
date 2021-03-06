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
 * Created: November 18, 2016
 *
 */

package com.odysseusinc.arachne.portal.repository;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.odysseusinc.arachne.portal.model.DataNode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DataNodeRepository<DN extends DataNode> extends EntityGraphJpaRepository<DN, Long> {
    DN findBySid(String sid);

    Optional<DN> findByToken(String token, EntityGraph entityGraph);

    List<DN> findAllByVirtualIsFalse();

    List<DN> findAllByVirtualIsFalseAndDataNodeUsersUserId(Long userId);

    DN findByNameAndVirtualIsFalse(String name);

}
