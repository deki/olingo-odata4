/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.olingo.odata4.client.core.edm;

import org.apache.olingo.odata4.client.api.edm.xml.v4.ActionImport;
import org.apache.olingo.odata4.client.api.utils.EdmTypeInfo;
import org.apache.olingo.odata4.commons.api.edm.Edm;
import org.apache.olingo.odata4.commons.api.edm.EdmAction;
import org.apache.olingo.odata4.commons.api.edm.EdmActionImport;
import org.apache.olingo.odata4.commons.api.edm.EdmEntityContainer;

public class EdmActionImportImpl extends EdmOperationImportImpl implements EdmActionImport {

  private final ActionImport actionImport;

  public EdmActionImportImpl(final Edm edm, final EdmEntityContainer container, final String name,
          final ActionImport actionImport) {

    super(edm, container, name, actionImport);
    this.actionImport = actionImport;
  }

  @Override
  public EdmAction getAction() {
    return edm.getAction(
            new EdmTypeInfo(actionImport.getAction(), container.getNamespace()).getFullQualifiedName(), null, null);
  }

}
