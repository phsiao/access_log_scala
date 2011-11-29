package com.github.phsiao.access_log.Util.test

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import com.github.phsiao.access_log.Util

class UtilTest extends FunSuite with ShouldMatchers {

  test("directive_b") {
    val Util.directive_b(zero) = "-"
    zero should be (0)

    val Util.directive_b(num) = "123"
    num should be (123)
  }
}
