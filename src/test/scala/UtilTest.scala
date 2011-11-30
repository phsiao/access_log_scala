package com.github.phsiao.access_log.Util.test

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import com.github.phsiao.access_log.Util

class UtilTest extends FunSuite with ShouldMatchers {

  test("clf_string") {
    val Util.clf_string(empty) = "-"
    empty should be ("")

    val Util.clf_string(nonempty) = "1234"
    nonempty should be ("1234")
  }

  test("format_b") {
    val Util.format_b(zero) = "-"
    zero should be (0)

    val Util.format_b(num) = "123"
    num should be (123)
  }

  test("format_s") {
    val Util.format_s(ok) = "200"
    ok should be (200)

    val Util.format_s(notfound) = "404"
    notfound should be (404)
  }

  test("format_t") {
    val Util.format_t(ts) = "28/Nov/2011:22:21:46 -0500"
    ts should be (1322536906)
  }
}
