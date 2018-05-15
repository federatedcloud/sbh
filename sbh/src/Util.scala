package edu.cornell.cac.sbh

import java.io.BufferedReader
import java.io.InputStreamReader

object Util {


  private def readLine(format: Option[String], args: Any*): String = {
    if (System.console != null) {
      System.console.readLine(format.getOrElse(""), args)
    }
    else {
      println(fansi.Color.Red(
        "ALERT: no console found, password will be shown on console !!!!"
      ))
      print(String.format(format.getOrElse(""), args))
      val reader = new BufferedReader(new InputStreamReader(System.in))
      reader.readLine
    }
  }

  def readPassword(format: Option[String], args: Any*): Array[Char] = {
    if (System.console != null) {
      System.console.readPassword(format.getOrElse(""), args)
    }
    else readLine(format, args).toCharArray
  }
}
