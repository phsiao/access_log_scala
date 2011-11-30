package com.github.phsiao.access_log.Format.test

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import com.github.phsiao.access_log.Format._

class FormatTest extends FunSuite with ShouldMatchers {

  test("common simple example") {
    val common(entry) =
      """127.0.0.1 - frank [10/Oct/2000:13:55:36 -0700] "GET /apache_pb.gif HTTP/1.0" 200 2326"""

    entry.remotehost should be ("127.0.0.1")
    entry.identity should be ("")
    entry.userid should be ("frank")
    entry.timestamp should be (971211336)
    entry.request should be ("GET /apache_pb.gif HTTP/1.0")
    entry.status should be (200)
    entry.size should be (2326)
  }

  test("common bad example 1") {
    val common(entry) =
      """127.0.0.1 - fr ank [10/Oct/2000:13:55:36 -0700] "GET /apa"che_pb.gif HTTP/1.0" 200 2326"""

    if (entry.identity == "") {
      entry.userid should be ("fr ank")
    } else {
      entry.userid should be ("ank")
    }

    entry.request should be ("GET /apa\"che_pb.gif HTTP/1.0")
  }

  test("combined simple example") {
    val combined(entry) =
      """127.0.0.1 - frank [10/Oct/2000:13:55:36 -0700] "GET /apache_pb.gif HTTP/1.0" 200 2326 "http://www.example.com/start.html" "Mozilla/4.08 [en] (Win98; I ;Nav)""""

    entry.remotehost should be ("127.0.0.1")
    entry.identity should be ("")
    entry.userid should be ("frank")
    entry.timestamp should be (971211336)
    entry.request should be ("GET /apache_pb.gif HTTP/1.0")
    entry.status should be (200)
    entry.size should be (2326)
    entry.referrer should be ("http://www.example.com/start.html")
    entry.useragent should be ("Mozilla/4.08 [en] (Win98; I ;Nav)")
  }

  test("combined bad example 1") {
    val combined(entry) =
      """127.0.0.1 - fr ank [10/Oct/2000:13:55:36 -0700] "GET /apa"che_pb.gif HTTP/1.0" 200 2326 "http://www.example.com/start.html" "Mozilla/4.08 [en] (Win98; I ;Nav)""""

    if (entry.identity == "") {
      entry.userid should be ("fr ank")
    } else {
      entry.userid should be ("ank")
    }

    entry.request should be ("GET /apa\"che_pb.gif HTTP/1.0")
  }
}
