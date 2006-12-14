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
package org.apache.ftpserver.listing;

import java.util.Arrays;

import org.apache.ftpserver.ftplet.FileObject;
import org.apache.ftpserver.util.DateUtils;

/**
 * Formats files according to the LIST specification
 */
public class LISTFileFormater implements FileFormater {

    private final static char DELIM = ' ';
    private final static char[] NEWLINE  = {'\r', '\n'};
    
    /**
     * @see FileFormater#format(FileObject)
     */
    public String format(FileObject file) {
        StringBuffer sb = new StringBuffer();
        sb.append(getPermission(file));
        sb.append(DELIM);
        sb.append(DELIM);
        sb.append(DELIM);
        sb.append(String.valueOf(file.getLinkCount()));
        sb.append(DELIM);
        sb.append(file.getOwnerName());
        sb.append(DELIM);
        sb.append(file.getGroupName());
        sb.append(DELIM);
        sb.append(getLength(file));
        sb.append(DELIM);
        sb.append(getLastModified(file));
        sb.append(DELIM);
        sb.append(file.getShortName());
        sb.append(NEWLINE);

        return sb.toString();
    }
    
    /**
     * Get size
     */
    private String getLength(FileObject file) {
        String initStr = "            ";
        long sz = 0;
        if(file.isFile()) {
            sz = file.getSize();
        }
        String szStr = String.valueOf(sz);
        if(szStr.length() > initStr.length()) {
            return szStr;
        }
        return initStr.substring(0, initStr.length() - szStr.length()) + szStr;
    }
    
    /**
     * Get last modified date string.
     */
    private String getLastModified(FileObject file) {
        return DateUtils.getUnixDate( file.getLastModified() );
    }
    
    /**
     * Get permission string.
     */
    private char[] getPermission(FileObject file) {
        char permission[] = new char[10];
        Arrays.fill(permission, '-');
        
        permission[0] = file.isDirectory() ? 'd' : '-';
        permission[1] = file.hasReadPermission() ? 'r' : '-';
        permission[2] = file.hasWritePermission() ? 'w' : '-';
        return permission;
    }

    /*public String format(FileObject[] files) {
        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < files.length; i++) {
            sb.append(format(files[i]));
            sb.append(NEWLINE);
        }
        return sb.toString();
    }*/

}
