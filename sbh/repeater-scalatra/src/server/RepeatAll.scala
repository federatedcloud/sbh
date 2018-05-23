package edu.cornell.cac.sbh.repeater.server

import org.scalatra._

class RepeatAll extends ScalatraServlet {
  get("/*") {
    <h1>Hello, {params("name")}</h1>
  }
}