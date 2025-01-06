/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.ftpserver.ftplet;

import junit.framework.TestCase;

/**
 * A Data type based test
 *
 * @author <a href="http://mina.apache.org">Apache MINA Project</a>
 */
public class DataTypeTest extends TestCase {
    /**
     * Default constructor
     */
    public DataTypeTest() {
    }

    /**
     * Test Ascii
     */
    public void testParseA() {
        assertSame(DataType.ASCII, DataType.parseArgument('A'));
        assertSame(DataType.ASCII, DataType.parseArgument('a'));
    }

    /**
     * Tst Binary
     */
    public void testParseI() {
        assertSame(DataType.BINARY, DataType.parseArgument('I'));
        assertSame(DataType.BINARY, DataType.parseArgument('i'));
    }

    /**
     * test unknown type
     */
    public void testParseUnknown() {
        try {
            DataType.parseArgument('x');
            fail("Exception must be thrown");
        } catch (IllegalArgumentException e) {
            // ignore
        }
    }
}
