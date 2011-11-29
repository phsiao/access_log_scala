
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

scala> val common(hostname, identity, userid, timestamp, request, status, size) =
     |       """127.0.0.1 - frank [10/Oct/2000:13:55:36 -0700] "GET /apache_pb.gif HTTP/1.0" 200 2326"""
hostname: String = 127.0.0.1
identity: String = ""
userid: String = frank
timestamp: Int = 971211336
request: String = GET /apache_pb.gif HTTP/1.0
status: Int = 200
size: Int = 2326

scala> val common_as_map(entry) = """127.0.0.1 - frank [10/Oct/2000:13:55:36 -0700] "GET /apache_pb.gif HTTP/1.0" 200 2326"""
entry: scala.collection.immutable.ListMap[String,Any] = Map(REMOTEHOST -> 127.0.0.1, IDENTITY -> "", USERID -> frank, TIMESTAMP -> 971211336, REQUEST -> GET /apache_pb.gif HTTP/1.0, STATUS -> 200, SIZE -> 2326)

scala> 
```
