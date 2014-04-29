/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.contrib.lesssassbenchmark;

import java.io.File;

import com.asual.lesscss.LessEngine;
import com.asual.lesscss.LessOptions;

public class AsualLESSCompiler implements Compiler
{
    private LessEngine lessEngine;

    @Override
    public void init()
    {
        LessOptions lessOptions = new LessOptions();
        lessOptions.setLess(getClass().getResource("/less-rhino-1.7.0.js"));
        lessEngine = new LessEngine();
    }

    @Override
    public String compile(String filename) throws Exception
    {
        return lessEngine.compile(new File(filename));
    }
}
