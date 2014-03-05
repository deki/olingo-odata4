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
package org.apache.olingo.odata4.commons.api.edm;

public class Target {

  private String targetName;

  private FullQualifiedName entityContainer;

  public static class Builder {

    private final Target instance;

    public Builder(final String target, final EdmEntityContainer defaultContainer) {
      final String[] bindingTargetParts = target.split("/");

      instance = new Target();
      if (bindingTargetParts.length == 1) {
        instance.
                setEntityContainer(new FullQualifiedName(defaultContainer.getNamespace(), defaultContainer.getName())).
                setTargetName(bindingTargetParts[0]);
      } else {
        final int idx = bindingTargetParts[0].lastIndexOf('.');
        instance.
                setEntityContainer(new FullQualifiedName(
                                bindingTargetParts[0].substring(0, idx), bindingTargetParts[0].substring(idx))).
                setTargetName(bindingTargetParts[1]);
      }
    }

    public Target build() {
      return instance;
    }
  }

  public String getTargetName() {
    return targetName;
  }

  public Target setTargetName(final String targetPathName) {
    targetName = targetPathName;
    return this;
  }

  public FullQualifiedName getEntityContainer() {
    return entityContainer;
  }

  public Target setEntityContainer(final FullQualifiedName entityContainer) {
    this.entityContainer = entityContainer;
    return this;
  }

}
