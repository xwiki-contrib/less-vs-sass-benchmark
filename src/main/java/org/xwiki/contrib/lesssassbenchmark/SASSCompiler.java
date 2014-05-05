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

import java.io.IOException;

import org.jruby.embed.ScriptingContainer;

public class SASSCompiler implements Compiler
{
    private boolean useCache;

    public SASSCompiler(boolean useCache)
    {
        this.useCache = useCache;
    }

    @Override
    public void init()
    {
        // When creating a ScriptingContainer for the first time, it loads JRuby
        new ScriptingContainer().runScriptlet("puts 'JRuby loaded'");
    }

    @Override
    public String compile(String filename) throws IOException
    {
        StringBuilder script = new StringBuilder();
        script.append("require 'sass'").append(System.lineSeparator());
        script.append(String.format("engine = Sass::Engine.for_file('%s', {cache: %b})", filename, useCache));
        script.append(System.lineSeparator());
        script.append("engine.render()");
        return new ScriptingContainer().runScriptlet(script.toString()).toString();
    }
}
