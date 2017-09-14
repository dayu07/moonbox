/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edp.elasticsearch;

import com.google.common.collect.ImmutableMap;
import edp.moonbox.calcite.linq4j.tree.Types;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Builtin methods in the Elasticsearch adapter.
 */
enum ElasticsearchMethod {
  ELASTICSEARCH_QUERYABLE_FIND(ElasticsearchTable.ElasticsearchQueryable.class, "find",
      List.class, List.class, Integer.class);

  public final Method method;

  public static final ImmutableMap<Method, ElasticsearchMethod> MAP;

  static {
    final ImmutableMap.Builder<Method, ElasticsearchMethod> builder = ImmutableMap.builder();
    for (ElasticsearchMethod value: ElasticsearchMethod.values()) {
      builder.put(value.method, value);
    }
    MAP = builder.build();
  }

  ElasticsearchMethod(Class clazz, String methodName, Class... argumentTypes) {
    this.method = Types.lookupMethod(clazz, methodName, argumentTypes);
  }
}

// End ElasticsearchMethod.java