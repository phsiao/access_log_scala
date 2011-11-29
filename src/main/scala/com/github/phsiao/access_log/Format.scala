package com.github.phsiao.access_log.Format

import com.github.phsiao.access_log.Util._
import scala.collection.immutable.ListMap

object field {
  val REMOTEHOST  = "REMOTEHOST"
  val IDENTITY    = "IDENTITY"
  val USERID      = "USERID"
  val TIMESTAMP   = "TIMESTAMP"
  val REQUEST     = "REQUEST"
  val STATUS      = "STATUS"
  val SIZE        = "SIZE"
  val REFERRER    = "REFERRER"
  val USERAGENT   = "USERAGENT"
}

/** Parse Apache common log format
  *
  * http://httpd.apache.org/docs/2.2/logs.html#common
  *
  * LogFormat "%h %l %u %t \"%r\" %>s %b " common
  */
object common {
  val le = """(.+) (.+) (.+) \[(.+)\] "(.*)" (\d+) ([-\d]+)""".r
  def unapply(line: String) = {
    val le(clf_string(remotehost), clf_string(identity), clf_string(userid),
           format_t(timestamp), request, format_s(status), format_b(size)) = line
    Some(remotehost, identity, userid, timestamp, request, status, size)
  }
}

object common_as_map {
  def unapply(line: String) = {
    val common(remotehost, identity, userid, timestamp, request, status, size) = line
    import field._
    Some(ListMap[String, Any](REMOTEHOST -> remotehost, IDENTITY -> identity, USERID -> userid,
                 TIMESTAMP -> timestamp, REQUEST -> request,
                 STATUS -> status, SIZE -> size))
  }
}

/** Parse Apache combined access log format
  *
  * http://httpd.apache.org/docs/2.2/logs.html#combined
  *
  * LogFormat "%h %l %u %t \"%r\" %>s %b \"%{Referer}i\" \"%{User-agent}i\"" combined
  */
object combined {
  val le = """(.+) (.+) (.+) \[(.+)\] "(.*)" (\d+) ([-\d]+) "(.*)" "(.*)"""".r
  def unapply(line: String) = {
    val le(clf_string(remotehost), clf_string(identity), clf_string(userid),
           format_t(timestamp), request, format_s(status), format_b(size),
           referrer, useragent) = line
    Some(remotehost, identity, userid, timestamp, request, status, size, referrer, useragent)
  }
}

object combined_as_map {
  def unapply(line: String) = {
    val combined(remotehost, identity, userid, timestamp, request,
                 status, size, referrer, useragent) = line
    import field._
    Some(ListMap[String, Any](REMOTEHOST -> remotehost, IDENTITY -> identity, USERID -> userid,
                 TIMESTAMP -> timestamp, REQUEST -> request,
                 STATUS -> status, SIZE -> size,
                 REFERRER -> referrer, USERAGENT -> useragent))
  }
}
