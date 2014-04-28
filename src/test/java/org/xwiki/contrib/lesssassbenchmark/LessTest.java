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

import java.io.FileInputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LessTest
{
    /**
     * LESSCompiler
     */
    private static LESSCompiler lessCompiler;

    @BeforeClass
    public static void init()
    {
        lessCompiler = new LESSCompiler();
        lessCompiler.init();
    }

    @Test
    public void test() throws Exception
    {
        String bootstrapSrc = getClass().getResource("/bootstrap-3.1.1/less/bootstrap.less").getFile();
        StringWriter expectedResult = new StringWriter();
        IOUtils.copy(new FileInputStream(getClass().getResource("/bootstrap.less.css").getFile()), expectedResult);
        String result = lessCompiler.compile(bootstrapSrc);
        assertEquals(expectedResult.toString(), result);
    }

    @Test
    public void compile100() throws Exception
    {
        String bootstrapSrc = getClass().getResource("/bootstrap-3.1.1/less/bootstrap.less").getFile();
        for (int i=100; i>0; --i) {
            lessCompiler.compile(bootstrapSrc);
        }
    }
}
