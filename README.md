
An Apache access_log parser in Scala
====================================

Example
-------

```scala
$ sbt console
Welcome to Scala version 2.9.1.final (Java HotSpot(TM) 64-Bit Server VM, Java 1.6.0_29).
Type in expressions to have them evaluated.
Type :help for more information.

scala> import com.github.phsiao.access_log.Format._
import com.github.phsiao.access_log.Format._

scala> val common(entry) = """127.0.0.1 - frank [10/Oct/2000:13:55:36 -0700] "GET /apache_pb.gif HTTP/1.0" 200 2326"""
entry: com.github.phsiao.access_log.Format.common = common(remotehost="127.0.0.1", identity="", userid="frank", timestamp=971211336, request="GET /apache_pb.gif HTTP/1.0", status=200, size=2326)

scala> 
```
