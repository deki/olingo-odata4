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
package org.apache.olingo.odata4.client.core.op.impl.v4;

import java.io.InputStream;
import org.apache.olingo.odata4.client.api.ODataClient;
import org.apache.olingo.odata4.client.core.op.impl.AbstractODataDeserializer;
import org.apache.olingo.odata4.client.core.edm.xml.v4.EdmxImpl;
import org.apache.olingo.odata4.client.core.edm.xml.v4.XMLMetadataImpl;

public class ODataDeserializerImpl extends AbstractODataDeserializer {

  private static final long serialVersionUID = 8593081342440470415L;

  public ODataDeserializerImpl(final ODataClient client) {
    super(client);
  }

  @Override
  public XMLMetadataImpl toMetadata(final InputStream input) {
    try {
      return new XMLMetadataImpl(getXmlMapper().readValue(input, EdmxImpl.class));
    } catch (Exception e) {
      throw new IllegalArgumentException("Could not parse as Edmx document", e);
    }
  }

//    @Override
//    public AbstractServiceDocument toServiceDocument(final InputStream input, final ODataFormat format) {
//        try {
//            return format == ODataFormat.XML
//                    ? getXmlMapper().readValue(input, XMLServiceDocument.class)
//                    : null;
////                    : getObjectMapper().readValue(input, JSONServiceDocument.class);
//        } catch (IOException e) {
//            throw new IllegalArgumentException("Could not parse Service Document", e);
//        }
//    }
//
//    @Override
//    protected JSONEntry toJSONEntry(final InputStream input) {
//        try {
//            return getObjectMapper().readValue(input, JSONEntry.class);
//        } catch (IOException e) {
//            throw new IllegalArgumentException("While deserializing JSON entry", e);
//        }
//    }
}
