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

package org.tensorflow.op.core;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.tensorflow.GraphOperation;
import org.tensorflow.Operand;
import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.Output;
import org.tensorflow.ndarray.Shape;
import org.tensorflow.op.Operands;
import org.tensorflow.op.RawOp;
import org.tensorflow.op.RawOpInputs;
import org.tensorflow.op.Scope;
import org.tensorflow.op.annotation.Endpoint;
import org.tensorflow.op.annotation.OpInputsMetadata;
import org.tensorflow.op.annotation.OpMetadata;
import org.tensorflow.proto.framework.DataType;
import org.tensorflow.types.TInt64;
import org.tensorflow.types.family.TType;

/**
 * Gets the element at the specified index in a dataset.
 */
@OpMetadata(
    opType = GetElementAtIndex.OP_NAME,
    inputsClass = GetElementAtIndex.Inputs.class
)
public final class GetElementAtIndex extends RawOp implements Iterable<Operand<TType>> {
  /**
   * The name of this op, as known by TensorFlow core engine
   */
  public static final String OP_NAME = "GetElementAtIndex";

  private List<Output<?>> components;

  @SuppressWarnings("unchecked")
  public GetElementAtIndex(Operation operation) {
    super(operation, OP_NAME);
    int outputIdx = 0;
    int componentsLength = operation.outputListLength("components");
    components = Arrays.asList(operation.outputList(outputIdx, componentsLength));
    outputIdx += componentsLength;
  }

  /**
   * Factory method to create a class wrapping a new GetElementAtIndex operation.
   *
   * @param scope current scope
   * @param dataset The dataset value
   * @param index The index value
   * @param outputTypes The value of the outputTypes attribute
   * @param outputShapes The value of the outputShapes attribute
   * @return a new instance of GetElementAtIndex
   */
  @Endpoint(
      describeByClass = true
  )
  public static GetElementAtIndex create(Scope scope, Operand<? extends TType> dataset,
      Operand<TInt64> index, List<Class<? extends TType>> outputTypes, List<Shape> outputShapes) {
    OperationBuilder opBuilder = scope.opBuilder(OP_NAME, "GetElementAtIndex");
    opBuilder.addInput(dataset.asOutput());
    opBuilder.addInput(index.asOutput());
    opBuilder.setAttr("output_types", Operands.toDataTypes(outputTypes));
    Shape[] outputShapesArray = new Shape[outputShapes.size()];
    for (int i = 0 ; i < outputShapesArray.length ; i++) {
      outputShapesArray[i] = outputShapes.get(i);
    }
    opBuilder.setAttr("output_shapes", outputShapesArray);
    return new GetElementAtIndex(opBuilder.build());
  }

  /**
   * Gets components.
   *
   * @return components.
   */
  public List<Output<?>> components() {
    return components;
  }

  @Override
  @SuppressWarnings({"rawtypes", "unchecked"})
  public Iterator<Operand<TType>> iterator() {
    return (Iterator) components.iterator();
  }

  @OpInputsMetadata(
      outputsClass = GetElementAtIndex.class
  )
  public static class Inputs extends RawOpInputs<GetElementAtIndex> {
    /**
     * The dataset input
     */
    public final Operand<? extends TType> dataset;

    /**
     * The index input
     */
    public final Operand<TInt64> index;

    /**
     * The outputTypes attribute
     */
    public final DataType[] outputTypes;

    /**
     * The outputShapes attribute
     */
    public final Shape[] outputShapes;

    public Inputs(GraphOperation op) {
      super(new GetElementAtIndex(op), op, Arrays.asList("output_types", "output_shapes"));
      int inputIndex = 0;
      dataset = (Operand<? extends TType>) op.input(inputIndex++);
      index = (Operand<TInt64>) op.input(inputIndex++);
      outputTypes = op.attributes().getAttrTypeList("output_types");
      outputShapes = op.attributes().getAttrShapeList("output_shapes");
    }
  }
}
