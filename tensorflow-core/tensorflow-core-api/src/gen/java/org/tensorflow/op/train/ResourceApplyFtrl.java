/* Copyright 2018-2022 The TensorFlow Authors. All Rights Reserved.

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

package org.tensorflow.op.train;

import java.util.Arrays;
import org.tensorflow.GraphOperation;
import org.tensorflow.Operand;
import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.op.RawOp;
import org.tensorflow.op.RawOpInputs;
import org.tensorflow.op.Scope;
import org.tensorflow.op.annotation.Endpoint;
import org.tensorflow.op.annotation.OpInputsMetadata;
import org.tensorflow.op.annotation.OpMetadata;
import org.tensorflow.op.annotation.Operator;
import org.tensorflow.proto.framework.DataType;
import org.tensorflow.types.family.TType;

/**
 * Update '*var' according to the Ftrl-proximal scheme.
 * accum_new = accum + grad * grad
 * grad_with_shrinkage = grad + 2 * l2_shrinkage * var
 * linear += grad_with_shrinkage +
 * (accum_new^(-lr_power) - accum^(-lr_power)) / lr * var
 * quadratic = 1.0 / (accum_new^(lr_power) * lr) + 2 * l2
 * var = (sign(linear) * l1 - linear) / quadratic if |linear| &gt; l1 else 0.0
 * accum = accum_new
 */
@OpMetadata(
    opType = ResourceApplyFtrl.OP_NAME,
    inputsClass = ResourceApplyFtrl.Inputs.class
)
@Operator(
    group = "train"
)
public final class ResourceApplyFtrl extends RawOp {
  /**
   * The name of this op, as known by TensorFlow core engine
   */
  public static final String OP_NAME = "ResourceApplyFtrlV2";

  public ResourceApplyFtrl(Operation operation) {
    super(operation, OP_NAME);
  }

  /**
   * Factory method to create a class wrapping a new ResourceApplyFtrlV2 operation.
   *
   * @param scope current scope
   * @param var Should be from a Variable().
   * @param accum Should be from a Variable().
   * @param linear Should be from a Variable().
   * @param grad The gradient.
   * @param lr Scaling factor. Must be a scalar.
   * @param l1 L1 regularization. Must be a scalar.
   * @param l2 L2 shrinkage regularization. Must be a scalar.
   * @param l2Shrinkage The l2Shrinkage value
   * @param lrPower Scaling factor. Must be a scalar.
   * @param options carries optional attribute values
   * @param <T> data type for {@code ResourceApplyFtrlV2} output and operands
   * @return a new instance of ResourceApplyFtrl
   */
  @Endpoint(
      describeByClass = true
  )
  public static <T extends TType> ResourceApplyFtrl create(Scope scope,
      Operand<? extends TType> var, Operand<? extends TType> accum, Operand<? extends TType> linear,
      Operand<T> grad, Operand<T> lr, Operand<T> l1, Operand<T> l2, Operand<T> l2Shrinkage,
      Operand<T> lrPower, Options... options) {
    OperationBuilder opBuilder = scope.opBuilder(OP_NAME, "ResourceApplyFtrl");
    opBuilder.addInput(var.asOutput());
    opBuilder.addInput(accum.asOutput());
    opBuilder.addInput(linear.asOutput());
    opBuilder.addInput(grad.asOutput());
    opBuilder.addInput(lr.asOutput());
    opBuilder.addInput(l1.asOutput());
    opBuilder.addInput(l2.asOutput());
    opBuilder.addInput(l2Shrinkage.asOutput());
    opBuilder.addInput(lrPower.asOutput());
    if (options != null) {
      for (Options opts : options) {
        if (opts.useLocking != null) {
          opBuilder.setAttr("use_locking", opts.useLocking);
        }
        if (opts.multiplyLinearByLr != null) {
          opBuilder.setAttr("multiply_linear_by_lr", opts.multiplyLinearByLr);
        }
      }
    }
    return new ResourceApplyFtrl(opBuilder.build());
  }

  /**
   * Sets the useLocking option.
   *
   * @param useLocking If {@code True}, updating of the var and accum tensors will be protected
   * by a lock; otherwise the behavior is undefined, but may exhibit less
   * contention.
   * @return this Options instance.
   */
  public static Options useLocking(Boolean useLocking) {
    return new Options().useLocking(useLocking);
  }

  /**
   * Sets the multiplyLinearByLr option.
   *
   * @param multiplyLinearByLr the multiplyLinearByLr option
   * @return this Options instance.
   */
  public static Options multiplyLinearByLr(Boolean multiplyLinearByLr) {
    return new Options().multiplyLinearByLr(multiplyLinearByLr);
  }

  /**
   * Optional attributes for {@link org.tensorflow.op.train.ResourceApplyFtrl}
   */
  public static class Options {
    private Boolean useLocking;

    private Boolean multiplyLinearByLr;

    private Options() {
    }

    /**
     * Sets the useLocking option.
     *
     * @param useLocking If {@code True}, updating of the var and accum tensors will be protected
     * by a lock; otherwise the behavior is undefined, but may exhibit less
     * contention.
     * @return this Options instance.
     */
    public Options useLocking(Boolean useLocking) {
      this.useLocking = useLocking;
      return this;
    }

    /**
     * Sets the multiplyLinearByLr option.
     *
     * @param multiplyLinearByLr the multiplyLinearByLr option
     * @return this Options instance.
     */
    public Options multiplyLinearByLr(Boolean multiplyLinearByLr) {
      this.multiplyLinearByLr = multiplyLinearByLr;
      return this;
    }
  }

  @OpInputsMetadata(
      outputsClass = ResourceApplyFtrl.class
  )
  public static class Inputs<T extends TType> extends RawOpInputs<ResourceApplyFtrl> {
    /**
     * Should be from a Variable().
     */
    public final Operand<? extends TType> var;

    /**
     * Should be from a Variable().
     */
    public final Operand<? extends TType> accum;

    /**
     * Should be from a Variable().
     */
    public final Operand<? extends TType> linear;

    /**
     * The gradient.
     */
    public final Operand<T> grad;

    /**
     * Scaling factor. Must be a scalar.
     */
    public final Operand<T> lr;

    /**
     * L1 regularization. Must be a scalar.
     */
    public final Operand<T> l1;

    /**
     * L2 shrinkage regularization. Must be a scalar.
     */
    public final Operand<T> l2;

    /**
     * The l2Shrinkage input
     */
    public final Operand<T> l2Shrinkage;

    /**
     * Scaling factor. Must be a scalar.
     */
    public final Operand<T> lrPower;

    /**
     * The T attribute
     */
    public final DataType T;

    /**
     * If `True`, updating of the var and accum tensors will be protected
     * by a lock; otherwise the behavior is undefined, but may exhibit less
     * contention.
     */
    public final boolean useLocking;

    /**
     * The multiplyLinearByLr attribute
     */
    public final boolean multiplyLinearByLr;

    public Inputs(GraphOperation op) {
      super(new ResourceApplyFtrl(op), op, Arrays.asList("T", "use_locking", "multiply_linear_by_lr"));
      int inputIndex = 0;
      var = (Operand<? extends TType>) op.input(inputIndex++);
      accum = (Operand<? extends TType>) op.input(inputIndex++);
      linear = (Operand<? extends TType>) op.input(inputIndex++);
      grad = (Operand<T>) op.input(inputIndex++);
      lr = (Operand<T>) op.input(inputIndex++);
      l1 = (Operand<T>) op.input(inputIndex++);
      l2 = (Operand<T>) op.input(inputIndex++);
      l2Shrinkage = (Operand<T>) op.input(inputIndex++);
      lrPower = (Operand<T>) op.input(inputIndex++);
      T = op.attributes().getAttrType("T");
      useLocking = op.attributes().getAttrBool("use_locking");
      multiplyLinearByLr = op.attributes().getAttrBool("multiply_linear_by_lr");
    }
  }
}
