/**
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
package org.apache.pinot.core.query.selection.iterator;

import java.io.Serializable;
import org.apache.pinot.core.common.Block;
import org.apache.pinot.core.common.BlockMultiValIterator;
import org.apache.pinot.core.segment.index.readers.Dictionary;

/**
 * Iterator on multi-value column selection query.
 *
 */
public abstract class SelectionMultiValueColumnIterator implements SelectionColumnIterator {
  protected BlockMultiValIterator bvIter;
  protected Dictionary dict;
  protected int[] dictIds;

  public SelectionMultiValueColumnIterator(Block block) {
    bvIter = (BlockMultiValIterator) block.getBlockValueSet().iterator();
    dict = block.getMetadata().getDictionary();
    dictIds = new int[block.getMetadata().getMaxNumberOfMultiValues()];
  }

  @Override
  public abstract Serializable getValue(int docId);
}
