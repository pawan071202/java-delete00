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
import org.tensorflow.types.TBool;
import org.tensorflow.types.family.TNumber;

/**
 * Returns the truth value of (x &gt; y) element-wise.
 * <em>NOTE</em>: {@code math.Greater} supports broadcasting. More about broadcasting
 *  <a href="http://docs.scipy.org/doc/numpy/user/basics.broadcasting.html">here</a> 
 * <p>Example:
 * <pre>
 * x = tf.constant([5, 4, 6])
 * y = tf.constant([5, 2, 5])
 * tf.math.greater(x, y) ==&gt; [False, True, True]
 *
 * x = tf.constant([5, 4, 6])
 * y = tf.constant([5])
 * tf.math.greater(x, y) ==&gt; [False, False, True]
 * </pre>
 */
@Operator(
    group = "math"
)
public final class Greater extends RawOp implements Operand<TBool> {
  /**
   * The name of this op, as known by TensorFlow core engine
   */
  public static final String OP_NAME = "Greater";

  private Output<TBool> z;

  private Greater(Operation operation) {
    super(operation);
    int outputIdx = 0;
    z = operation.output(outputIdx++);
  }

  /**
   * Factory method to create a class wrapping a new Greater operation.
   *
   * @param scope current scope
   * @param x the x value
   * @param y the y value
   * @param <T> data type for {@code Greater} output and operands
   * @return a new instance of Greater
   */
  @Endpoint(
      describeByClass = true
  )
  public static <T extends TNumber> Greater create(Scope scope, Operand<T> x, Operand<T> y) {
    OperationBuilder opBuilder = scope.env().opBuilder(OP_NAME, scope.makeOpName("Greater"));
    opBuilder.addInput(x.asOutput());
    opBuilder.addInput(y.asOutput());
    opBuilder = scope.apply(opBuilder);
    return new Greater(opBuilder.build());
  }

  /**
   * Gets z.
   *
   * @return z.
   */
  public Output<TBool> z() {
    return z;
  }

  @Override
  public Output<TBool> asOutput() {
    return z;
  }
}
