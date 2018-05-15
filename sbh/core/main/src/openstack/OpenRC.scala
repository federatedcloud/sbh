package edu.cornell.cac.sbh.core.openstack

import org.jclouds.openstack.nova.v3_0._

//TODO: remove the hardcoding of these elelments and read from PureConfig
//TODO: https://github.com/pureconfig/pureconfig
case class OpenRC(
  OS_AUTH_URL="https://tacc.jetstream-cloud.org:5000/v3",
  OS_PROJECT_NAME="TG-CIE160046",
  OS_USER_DOMAIN_NAME="tacc",
  OS_USERNAME="bebarker",
  IDENTITY_API_VERSION=3,
){
    protected lazy val OS_PASSWORD = {
        println("")
        val standardIn = System.console()
        val pw = standardIn.readPassword()
        println("Finished reading password.")
        pw
    }
}

object OpenRC{
    def connect(openrc: OpenRC): 
}