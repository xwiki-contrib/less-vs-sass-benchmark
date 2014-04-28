LESS vs SASS Benchmark
======

In XWiki, we want to build [Bootstrap](http://getbootstrap.com/) with a CSS preprocessor during the runtime. The question is: what is the best preprocessor for us, runnable in a java environment?

LESS
------
I am using [lesscss-java forked by sandroboehme](https://github.com/sandroboehme/lesscss-java). It uses [Rhino](https://developer.mozilla.org/en-US/docs/Mozilla/Projects/Rhino) and [EnvJs](http://www.envjs.com/) to runs the [LESS](http://lesscss.org/) compiler, which is written in Javascript.

SASS
-----
I am using [JRuby](http://jruby.org/) to runs the [SASS](http://sass-lang.com/) compiler, which is written in Ruby. I use the [official SASS port of bootstrap](https://github.com/twbs/bootstrap-sass).

Protocol
-----
I have both the sources of [Bootstrap](http://getbootstrap.com/) 3.1.1 for Less and Sass. I build it 100 times with each preprocessor.

* LESS version: 1.6.1 (last version: 1.7).
* SASS version: 3.2.1 (the last gems available in maven, last version: 3.3.6).

Results
-----
Using Java HotSpot(TM) 64-Bit Server VM 1.7 on Ubuntu 13.10, with intel core i7 2.40Ghz and 8 gb of RAM.

**For the whole**:

*   LESS: 192 seconds
*   SASS: 79 seconds

**Mean**:

*   LESS: 2,00986 seconds
*   SASS: 8,2578 seconds

**Median**:

*   LESS: 1,966 seconds
*   SASS: 7,145 seconds

**Standard Deviation**:

*   LESS: 0,269 seconds
*   SASS: 5,806 seconds

![Diagram](https://raw.githubusercontent.com/xwiki-contrib/less-vs-sass-benchmark/master/benchmark.png "Diagram")

Notes
-----
I am not a LESS nor SASS expert. So this benchmark may be improved by your suggestions.

Alternatives
-----
* There is a java version of SASS developed by Vaadin: [Vaadin](https://vaadin.com/blog/-/blogs/state-of-sass-support-in-vaadin-7-today)
* Same for LESS, but old: [LessCss4J](https://github.com/localmatters/lesscss4j)

Thanks
