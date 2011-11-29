package com.github.phsiao.access_log.Util

/** Some utilities for parsing directives.
  *
  * http://httpd.apache.org/docs/2.2/mod/mod_log_config.html#formats
  */

/** Parse directive %b as Integer
  */
object directive_b {
  def unapply(s: String): Option[Int] = {
    if (s == "-") Some(0)
    else Some(s.toInt)
  }
}
