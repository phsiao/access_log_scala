package com.github.phsiao.access_log.Util

object directive_b {
  def unapply(s: String): Option[Int] = {
    if (s == "-") Some(0)
    else Some(s.toInt)
  }
}
