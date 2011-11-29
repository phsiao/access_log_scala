package com.github.phsiao.access_log.Util

import java.text.SimpleDateFormat

/** Some utilities for parsing directives.
  *
  * http://httpd.apache.org/docs/2.2/mod/mod_log_config.html#formats
  */

/** Parse String as CLF string, i.e., "-" indicates missing data
  */
object clf_string {
  def unapply(s: String): Option[String] = {
    if (s == "-") Some("")
    else Some(s)
  }
}

/** Parse directive %b as Integer
  */
object directive_b {
  def unapply(s: String): Option[Int] = {
    if (s == "-") Some(0)
    else Some(s.toInt)
  }
}

/** Parse directive %s as Integer
  */
object directive_s {
  def unapply(s: String): Option[Int] = {
    Some(s.toInt)
  }
}

/** Parse directive %t as Integer, seconds since Unix epoch
  */
object directive_t {
  val directive_t_format = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss z")

  def unapply(s: String): Option[Int] = {
    Some((directive_t_format.parse(s).getTime()/1000).toInt)
  }
}

