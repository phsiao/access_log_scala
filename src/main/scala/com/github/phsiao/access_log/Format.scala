package com.github.phsiao.access_log.Format

import com.github.phsiao.access_log.Util._

/** Parse Apache common log format
  *
  * http://httpd.apache.org/docs/2.2/logs.html#common
  *
  * LogFormat "%h %l %u %t \"%r\" %>s %b " common
  */
object common {
  val le = """(.+) (.+) (.+) \[(.+)\] "(.*)" (\d+) ([-\d]+)""".r
  def unapply(line: String) = {
    val le(clf_string(hostname), clf_string(identity), clf_string(userid),
           directive_t(timestamp), request, directive_s(status), directive_b(size)) = line
    Some(hostname, identity, userid, timestamp, request, status, size)
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
    val le(clf_string(hostname), clf_string(identity), clf_string(userid),
           directive_t(timestamp), request, directive_s(status), directive_b(size),
           referrer, useragent) = line
    Some(hostname, identity, userid, timestamp, request, status, size, referrer, useragent)
  }
}
