LESS vs SASS Benchmark
======

In XWiki, we want to build [Bootstrap](http://getbootstrap.com/) with a CSS preprocessor during the runtime. The question is: what is the best preprocessor for us, runnable in a java environment?

LESS
------
I have found 2 versions to be used with java:

* [The official LESS Compiler for Java forked by Sandro Böhme](https://github.com/sandroboehme/lesscss-java). It uses [Rhino](https://developer.mozilla.org/en-US/docs/Mozilla/Projects/Rhino) and [EnvJs](http://www.envjs.com/) to runs the [LESS](http://lesscss.org/) compiler, which is written in Javascript.
* [LESS for Java, by Asual](http://www.asual.com/lesscss/), based on Rhino too.

SASS
-----
I am using [JRuby](http://jruby.org/) to runs the [SASS](http://sass-lang.com/) compiler, which is written in Ruby. I use the [official SASS port of bootstrap](https://github.com/twbs/bootstrap-sass).

Protocol
-----
I have both the sources of [Bootstrap](http://getbootstrap.com/) 3.1.1 for Less and Sass. I build it 100 times with each preprocessor.

* Official LESS version: 1.7.0 (latest)
* Asual LESS version: 1.7.0 (latest)
* SASS version: 3.2.1 wich is the last gems available in maven (last version: 3.3.6).

Results
-----
Using Java HotSpot(TM) 64-Bit Server VM 1.7 on Ubuntu 13.10, with intel core i7 2.40Ghz and 8 gb of RAM.

**For the whole**:

*   Official LESS: 139 seconds
*   Asual LESS: 427 seconds
*   SASS: 77 seconds

**Mean**:

*   Official LESS: 1,39101 seconds
*   Asual LESS: 4,27867 seconds
*   SASS: 0,77975 seconds

**Median**:

*   Official LESS: 1,34 seconds
*   Asual LESS: 4,236 seconds
*   SASS: 0,663 seconds

**Standard Deviation**:

*   Official LESS: 0,271 seconds
*   Asual LESS: 0,296 seconds
*   SASS: 0,548 seconds

![Diagram](https://raw.githubusercontent.com/xwiki-contrib/less-vs-sass-benchmark/master/benchmark.png "Diagram")

Notes
-----
I am not a LESS nor SASS expert. So this benchmark may be improved by your suggestions.

Alternatives
-----
* There is a java version of SASS developed by Vaadin: [Vaadin](https://vaadin.com/blog/-/blogs/state-of-sass-support-in-vaadin-7-today). The last time I tried, it was not able to compile Bootstrap.
* Same for LESS, but old: [LessCss4J](https://github.com/localmatters/lesscss4j)

Thanks
