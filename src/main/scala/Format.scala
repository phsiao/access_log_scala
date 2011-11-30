package com.github.phsiao.access_log.Format

import com.github.phsiao.access_log.Util._

class common(val remotehost: String, val identity: String, val userid: String,
             val timestamp: Int, val request: String, val status: Int, val size: Int) {
  override def toString() = {
    val fmt = """common(remotehost="%s", identity="%s", userid="%s", timestamp=%d, """ +
              """request="%s", status=%d, size=%d)"""
    fmt.format(remotehost, identity, userid, timestamp, request, status, size)
  }
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
    Some(new common(remotehost, identity, userid, timestamp, request, status, size))
  }
}

class combined(val remotehost: String, val identity: String, val userid: String,
               val timestamp: Int, val request: String, val status: Int, val size: Int,
               val referrer: String, val useragent: String) {
  override def toString() = {
    val fmt = """combined(remotehost="%s", identity="%s", userid="%s", timestamp=%d, """ +
              """request="%s", status=%d, size=%d, referrer="%s" useragent="%s")"""
    fmt.format(remotehost, identity, userid, timestamp, request, status, size,
               referrer, useragent)
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
    Some(new combined(remotehost, identity, userid, timestamp, request, status, size, referrer, useragent))
  }
}

