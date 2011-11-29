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

  test("directive_b") {
    val Util.directive_b(zero) = "-"
    zero should be (0)

    val Util.directive_b(num) = "123"
    num should be (123)
  }

  test("directive_t") {
    val Util.directive_t(ts) = "28/Nov/2011:22:21:46 -0500"
    ts should be (1322536906)
  }
}
