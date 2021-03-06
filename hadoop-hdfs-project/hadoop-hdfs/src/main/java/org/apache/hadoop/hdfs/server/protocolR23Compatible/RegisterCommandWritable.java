/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hdfs.server.protocolR23Compatible;

import java.io.DataInput;
import java.io.DataOutput;

import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.hadoop.classification.InterfaceStability;
import org.apache.hadoop.hdfs.server.protocol.DatanodeCommand;
import org.apache.hadoop.hdfs.server.protocol.RegisterCommand;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableFactories;
import org.apache.hadoop.io.WritableFactory;

/**
 * A RegisterCommand is an instruction to a datanode to register with the
 * namenode.
 */
@InterfaceAudience.Private
@InterfaceStability.Evolving
public class RegisterCommandWritable extends DatanodeCommandWritable {
  public static final RegisterCommandWritable REGISTER = 
      new RegisterCommandWritable();
  
  // /////////////////////////////////////////
  // Writable
  // /////////////////////////////////////////
  static { // register a ctor
    WritableFactories.setFactory(RegisterCommandWritable.class,
        new WritableFactory() {
          public Writable newInstance() {
            return new RegisterCommandWritable();
          }
        });
  }

  public RegisterCommandWritable() {
    super(DatanodeWireProtocol.DNA_REGISTER);
  }

  @Override
  public void readFields(DataInput in) { /* Nothing to read */
  }

  @Override
  public void write(DataOutput out) { /* Nothing to write */
  }

  @Override
  public DatanodeCommand convert() {
    return RegisterCommand.REGISTER;
  }
}