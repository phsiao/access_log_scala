package com.github.phsiao.access_log.Format.test

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import com.github.phsiao.access_log.Format._

class FormatTest extends FunSuite with ShouldMatchers {

  test("common simple example") {
    val common(hostname, identity, userid, timestamp, request, status, size) =
      """127.0.0.1 - frank [10/Oct/2000:13:55:36 -0700] "GET /apache_pb.gif HTTP/1.0" 200 2326"""

    hostname should be ("127.0.0.1")
    identity should be ("")
    userid should be ("frank")
    timestamp should be (971211336)
    request should be ("GET /apache_pb.gif HTTP/1.0")
    status should be (200)
    size should be (2326)
  }

  test("combined simple example") {
    val combined(hostname, identity, userid, timestamp, request, status, size, referrer, useragent) =
      """127.0.0.1 - frank [10/Oct/2000:13:55:36 -0700] "GET /apache_pb.gif HTTP/1.0" 200 2326 "http://www.example.com/start.html" "Mozilla/4.08 [en] (Win98; I ;Nav)""""

    hostname should be ("127.0.0.1")
    identity should be ("")
    userid should be ("frank")
    timestamp should be (971211336)
    request should be ("GET /apache_pb.gif HTTP/1.0")
    status should be (200)
    size should be (2326)
    referrer should be ("http://www.example.com/start.html")
    useragent should be ("Mozilla/4.08 [en] (Win98; I ;Nav)")
  }
}
