package edu.cornell.cac.sbh

import edu.cornell.cac.sbh.core.openstack._

import utest._

//TODO: reproduce as much as possible from:
// https://developer.openstack.org/draft/firstapp-jclouds/getting_started.html

//TODO: make this into an integration test

object TestOpenStackConnection extends TestSuite {
  val tests = Tests {
    'listImages - {
      val openrc = OpenRC()
      val conn = OpenRC.connect(openrc)
      val region = conn.getConfiguredRegions.iterator.next
      println("Running in region: " + region)
      
    }
  }
}