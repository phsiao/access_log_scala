package com.github.phsiao.access_log.Parse

import java.io.FileInputStream
import java.util.zip.GZIPInputStream
import com.github.phsiao.access_log.Format

abstract class ParseBase[T] {
  def parseOne(line: String): T

  def parse(sources: Iterable[io.Source]) = {
    for (source <- sources; line <- source.getLines()) yield parseOne(line)
  }

  def openOne(file: String) = {
    if (file.endsWith(".gz")) {
      io.Source.fromInputStream(new GZIPInputStream(new FileInputStream(file)))
    }
    else {
      io.Source.fromFile(file)
    }
  }

  def open(files: Iterable[String]) = {
    files map openOne
  }
}

object ParseCommon extends ParseBase[Format.common]{
  def parseOne(line: String) = {
    val Format.common(entry) = line
    entry
  }

  def main(args: Array[String]) = {
    for (entry <- parse(open(args))) {
      println(entry)
    }
  }
}

object ParseCombined extends ParseBase[Format.combined]{
  def parseOne(line: String) = {
    val Format.combined(entry) = line
    entry
  }

  def main(args: Array[String]) = {
    for (entry <- parse(open(args))) {
      println(entry)
    }
  }
}
