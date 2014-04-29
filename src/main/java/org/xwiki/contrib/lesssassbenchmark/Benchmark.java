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

public class Benchmark
{
    public static void main(String[] args)
    {
        Benchmark benchmark = new Benchmark();
        benchmark.run();
    }

    public void run()
    {
        try {
            System.out.println("LESS vs SASS in a java environment Benchmark");
            System.out.println("--------------------");

            // Official LESS
            System.out.println("Running Less... (100 iterations)");
            long lessTime = run(new OfficialLESSCompiler(), "/bootstrap-3.1.1/less/bootstrap.less");

            // SASS
            System.out.println("Running Sass... (100 iterations)");
            long sassTime = run(new SASSCompiler(), "/bootstrap-3.1.1/sass/bootstrap.scss");

            // Asual LESS
            System.out.println("Running Asual Less... (100 iterations)");
            long asualLessTime = run(new AsualLESSCompiler(), "/bootstrap-3.1.1/less/bootstrap.less");

            // RESULTS
            System.out.println("Results:");
            System.out.println("LESS: "+ lessTime + " seconds");
            System.out.println("SASS: "+ sassTime + " seconds");
            System.out.println("Asual LESS: "+ asualLessTime + " seconds");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private long run(Compiler compiler, String sourceName) throws Exception
    {
        compiler.init();
        String bootstrapSrc = getClass().getResource(sourceName).getFile();
        long before = System.currentTimeMillis();
        for (int i=100; i>0; --i) {
            long beforeOnce = System.currentTimeMillis();
            compiler.compile(bootstrapSrc);
            long afterOnce = System.currentTimeMillis();
            System.out.println(afterOnce-beforeOnce);
        }
        long after = System.currentTimeMillis();

        return (after-before)/1000;
    }
}
