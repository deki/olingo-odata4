/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.olingo.commons.core.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.olingo.commons.api.data.Annotatable;
import org.apache.olingo.commons.api.data.Annotation;
import org.apache.olingo.commons.api.data.ComplexValue;
import org.apache.olingo.commons.api.data.Valuable;
import org.apache.olingo.commons.api.data.ValueType;
import org.apache.olingo.commons.api.edm.geo.Geospatial;

public abstract class AbstractValuable implements Valuable, Annotatable {

  private ValueType valueType = null;
  private Object value = null;
  private final List<Annotation> annotations = new ArrayList<Annotation>();
  private String type;

  @Override
  public boolean isNull() {
    return value == null;
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public void setType(final String type) {
    this.type = type;
  }
  
  @Override
  public boolean isPrimitive() {
    if(isCollection()) {
      return valueType.getBaseType() == ValueType.PRIMITIVE;
    }
    return valueType == ValueType.PRIMITIVE;
  }

  @Override
  public boolean isGeospatial() {
    if(isCollection()) {
      return valueType.getBaseType() == ValueType.GEOSPATIAL;
    }
    return valueType == ValueType.GEOSPATIAL;
  }

  @Override
  public boolean isEnum() {
    if(isCollection()) {
      return valueType.getBaseType() == ValueType.ENUM;
    }
    return valueType == ValueType.ENUM;
  }

  @Override
  public boolean isComplex() {
    if(isCollection()) {
      return valueType.getBaseType() == ValueType.COMPLEX;
    }
    return valueType == ValueType.COMPLEX;
  }

  @Override
  public boolean isCollection() {
    return valueType != null && valueType != valueType.getBaseType();
  }

  @Override
  public Object asPrimitive() {
    if(isCollection()) {
      return null;
    }
    return isPrimitive() ? value : null;
  }

  @Override
  public Geospatial asGeospatial() {
    if(isCollection()) {
      return null;
    }
    return isGeospatial() ? (Geospatial) value : null;
  }

  @Override
  public Object asEnum() {
    if(isCollection()) {
      return null;
    }
    return isEnum() ? value : null;
  }

  @Override
  public ComplexValue asComplex() {
    if(isCollection()) {
      return null;
    }
    return isComplex() ? (ComplexValue) value : null;
  }

  @Override
  public List<?> asCollection() {
    return isCollection() ? (List<?>) value : null;
  }

  @Override
  public Object getValue() {
    return value;
  }

  @Override
  public void setValue(final ValueType valueType, final Object value) {
    this.valueType = valueType;
    this.value = value;
  }

  @Override
  public ValueType getValueType() {
    return valueType;
  }

  @Override
  public List<Annotation> getAnnotations() {
    return annotations;
  }

  @Override
  public boolean equals(final Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
}