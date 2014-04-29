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

import de.sandroboehme.lesscss.LessCompiler;

public class OfficialLESSCompiler implements Compiler
{
    private LessCompiler lessCompiler;

    @Override
    public void init()
    {
        // Instantiate the LESS compiler
        lessCompiler = new LessCompiler();
        lessCompiler.setLessJs(getClass().getResource("/less-rhino-1.7.0.js"));
        lessCompiler.setLesscJs(getClass().getResource("/lessc-rhino-1.7.0.js"));
        lessCompiler.init();
    }

    @Override
    public String compile(String filename) throws Exception
    {
        return lessCompiler.compile(new File(filename));
    }
}
