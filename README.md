LESS vs SASS Benchmark
======

In XWiki, we want to build [Bootstrap](http://getbootstrap.com/) with a CSS preprocessor during the runtime. The question is: what is the best preprocessor for us, runnable in a java environment?

LESS
------
I have found 2 versions to be used with java:

* [The official LESS Compiler for Java forked by Sandro Böhme](https://github.com/sandroboehme/lesscss-java). It uses [Rhino](https://developer.mozilla.org/en-US/docs/Mozilla/Projects/Rhino) and [EnvJs](http://www.envjs.com/) to runs the [LESS](http://lesscss.org/) compiler, which is written in Javascript.
* [LESS for Java, by Asual](http://www.asual.com/lesscss/), based on Rhino only, tu run the LESS compiler.

SASS
-----
I am using [JRuby](http://jruby.org/) to runs the [SASS](http://sass-lang.com/) compiler, which is written in Ruby. I use the [official SASS port of bootstrap](https://github.com/twbs/bootstrap-sass).

I am also testing with and without the "cache" option, that do not re-compile files imported via "@import" when they haven't changed. Since in XWiki, it may often compute new files. (it seems that LESS does not cache anything).

Protocol
-----
I have both the sources of [Bootstrap](http://getbootstrap.com/) 3.1.1 for Less and Sass. I build it 100 times with each preprocessor.

* Official LESS version: I manually set the LESS JS file to 1.7.0-rhino (latest)
* Asual LESS version: I manually set the LESS JS file to 1.7.0-rhino (latest)
* SASS version: [3.3.6](https://github.com/xwiki-contrib/sass-gems) (latest).

Results
-----
Using Java HotSpot(TM) 64-Bit Server VM 1.7 on Ubuntu 13.10, with intel core i7 2.40Ghz and 8 gb of RAM.

**For the whole**:

*   Official LESS: 142 seconds
*   Asual LESS: 433 seconds
*   SASS: 86 seconds
*   SASS without Cache: 161 seconds

**Mean**:

*   Official LESS: 1,425 seconds
*   Asual LESS: 4,337 seconds
*   SASS: 0,860 seconds
*   SASS without Cache: 1,617 seconds

**Median**:

*   Official LESS: 1,372 seconds
*   Asual LESS: 4,283 seconds
*   SASS: 0,732 seconds
*   SASS without Cache: 1,4345 seconds

**Standard Deviation**:

*   Official LESS: 0,272 seconds
*   Asual LESS: 0,403 seconds
*   SASS: 0,667 seconds
*   SASS without Cache: 0,885 seconds

![Diagram](https://raw.githubusercontent.com/xwiki-contrib/less-vs-sass-benchmark/master/benchmark.png "Diagram")

Notes
-----
I am not a LESS nor SASS expert. So this benchmark may be improved by your suggestions.

Alternatives
-----
* There is a java version of SASS developed by Vaadin: [Vaadin](https://vaadin.com/blog/-/blogs/state-of-sass-support-in-vaadin-7-today). The last time I tried, it was not able to compile Bootstrap.
* Same for LESS, but old: [LessCss4J](https://github.com/localmatters/lesscss4j)

Thanks
