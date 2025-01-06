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

/**
 * This is an abstraction over the user file system view.
 *
 * @author <a href="http://mina.apache.org">Apache MINA Project</a>
 */
public interface FileSystemView {
    /**
     * Get the user home directory.
     *
     * @return The {@link FtpFile} for the users home directory
     * @throws FtpException When the Home Directory can't be retrieved
     */
    FtpFile getHomeDirectory() throws FtpException;

    /**
     * Get user current directory.
     *
     * @return The {@link FtpFile} for the users current directory
     * @throws FtpException When the working Directory can't be retrieved
     */
    FtpFile getWorkingDirectory() throws FtpException;

    /**
     * Change directory.
     *
     * @param dir The path of the directory to set as the current directory for the user
     * @return <code>true</code> if successful
     * @throws FtpException When the change to Home Directory can't be done
     */
    boolean changeWorkingDirectory(String dir) throws FtpException;

    /**
     * Get file object.
     *
     * @param file The path to the file to get
     * @return The {@link FtpFile} for the provided path
     * @throws FtpException When the file can't be retrieved
     */
    FtpFile getFile(String file) throws FtpException;

    /**
     * Does the file system support random file access?
     *
     * @return <code>true</code> if the file supports random access
     * @throws FtpException When random file access isn't supported
     */
    boolean isRandomAccessible() throws FtpException;

    /**
     * Dispose file system view.
     */
    void dispose();
}
