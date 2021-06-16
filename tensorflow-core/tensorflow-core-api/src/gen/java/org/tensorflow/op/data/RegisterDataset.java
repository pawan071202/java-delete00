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

package org.tensorflow.op.data;

import org.tensorflow.Operand;
import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.Output;
import org.tensorflow.op.RawOp;
import org.tensorflow.op.Scope;
import org.tensorflow.op.annotation.Endpoint;
import org.tensorflow.types.TInt64;
import org.tensorflow.types.TString;
import org.tensorflow.types.family.TType;

/**
 * Registers a dataset with the tf.data service.
 */
public final class RegisterDataset extends RawOp implements Operand<TInt64> {
  /**
   * The name of this op, as known by TensorFlow core engine
   */
  public static final String OP_NAME = "RegisterDataset";

  private Output<TInt64> datasetId;

  private RegisterDataset(Operation operation) {
    super(operation);
    int outputIdx = 0;
    datasetId = operation.output(outputIdx++);
  }

  /**
   * Factory method to create a class wrapping a new RegisterDataset operation.
   *
   * @param scope current scope
   * @param dataset the dataset value
   * @param address the address value
   * @param protocol the protocol value
   * @param externalStatePolicy the value of the externalStatePolicy property
   * @return a new instance of RegisterDataset
   */
  @Endpoint(
      describeByClass = true
  )
  public static RegisterDataset create(Scope scope, Operand<? extends TType> dataset,
      Operand<TString> address, Operand<TString> protocol, Long externalStatePolicy) {
    OperationBuilder opBuilder = scope.env().opBuilder(OP_NAME, scope.makeOpName("RegisterDataset"));
    opBuilder.addInput(dataset.asOutput());
    opBuilder.addInput(address.asOutput());
    opBuilder.addInput(protocol.asOutput());
    opBuilder = scope.apply(opBuilder);
    opBuilder.setAttr("external_state_policy", externalStatePolicy);
    return new RegisterDataset(opBuilder.build());
  }

  /**
   * Gets datasetId.
   *
   * @return datasetId.
   */
  public Output<TInt64> datasetId() {
    return datasetId;
  }

  @Override
  public Output<TInt64> asOutput() {
    return datasetId;
  }
}
