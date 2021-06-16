/* Copyright 2018 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
=======================================================================*/

// This class has been generated, DO NOT EDIT!

package org.tensorflow.op.math;

import org.tensorflow.Operand;
import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.Output;
import org.tensorflow.op.RawOp;
import org.tensorflow.op.Scope;
import org.tensorflow.op.annotation.Endpoint;
import org.tensorflow.op.annotation.Operator;
import org.tensorflow.types.family.TNumber;
import org.tensorflow.types.family.TType;

/**
 * Computes the product along segments of a tensor.
 * Read
 *  <a href="https://tensorflow.org/api_docs/python/tf/math#Segmentation">the section on segmentation</a> 
 * for an explanation of segments.
 * <p>This operator is similar to the unsorted segment sum operator found
 *  <a href="../../../api_docs/python/math_ops.md#UnsortedSegmentSum">(here)</a> .
 * Instead of computing the sum over segments, it computes the product of all
 * entries belonging to a segment such that:
 * <p>\(output_i = \prod_{j...} data[j...]\) where the product is over tuples
 * {@code j...} such that {@code segment_ids[j...] == i}.
 * <p>For example:
 * <pre>
 * c = tf.constant([[1,2,3,4], [5,6,7,8], [4,3,2,1]])
 * tf.unsorted_segment_prod(c, tf.constant([0, 1, 0]), num_segments=2)
 * # ==&gt; [[ 4,  6, 6, 4],
 * #       [5,  6, 7, 8]]
 * </pre>
 * <p>If there is no entry for a given segment ID {@code i}, it outputs 1.
 * <p>If the given segment ID {@code i} is negative, then the corresponding value is
 * dropped, and will not be included in the result.
 *
 * @param <T> data type for {@code output} output
 */
@Operator(
    group = "math"
)
public final class UnsortedSegmentProd<T extends TType> extends RawOp implements Operand<T> {
  /**
   * The name of this op, as known by TensorFlow core engine
   */
  public static final String OP_NAME = "UnsortedSegmentProd";

  private Output<T> output;

  private UnsortedSegmentProd(Operation operation) {
    super(operation);
    int outputIdx = 0;
    output = operation.output(outputIdx++);
  }

  /**
   * Factory method to create a class wrapping a new UnsortedSegmentProd operation.
   *
   * @param scope current scope
   * @param data the data value
   * @param segmentIds A tensor whose shape is a prefix of {@code data.shape}.
   * @param numSegments the numSegments value
   * @param <T> data type for {@code UnsortedSegmentProd} output and operands
   * @return a new instance of UnsortedSegmentProd
   */
  @Endpoint(
      describeByClass = true
  )
  public static <T extends TType> UnsortedSegmentProd<T> create(Scope scope, Operand<T> data,
      Operand<? extends TNumber> segmentIds, Operand<? extends TNumber> numSegments) {
    OperationBuilder opBuilder = scope.env().opBuilder(OP_NAME, scope.makeOpName("UnsortedSegmentProd"));
    opBuilder.addInput(data.asOutput());
    opBuilder.addInput(segmentIds.asOutput());
    opBuilder.addInput(numSegments.asOutput());
    opBuilder = scope.apply(opBuilder);
    return new UnsortedSegmentProd<>(opBuilder.build());
  }

  /**
   * Gets output.
   * Has same shape as data, except for the first {@code segment_ids.rank}
   * dimensions, which are replaced with a single dimension which has size
   * {@code num_segments}.
   * @return output.
   */
  public Output<T> output() {
    return output;
  }

  @Override
  public Output<T> asOutput() {
    return output;
  }
}
