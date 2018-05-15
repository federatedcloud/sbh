package edu.cornell.cac.sbh.core.openstack

import java.util.Properties

import org.jclouds.ContextBuilder
import org.jclouds.openstack.keystone.config.KeystoneProperties
import org.jclouds.openstack.nova.v2_0._

//TODO: remove the hardcoding of these elelments and read from PureConfig
//TODO: https://github.com/pureconfig/pureconfig
case class OpenRC(
  OS_AUTH_URL: String = "https://tacc.jetstream-cloud.org:5000/v3",
  OS_PROJECT_NAME: String = "TG-CIE160046",
  OS_USER_DOMAIN_NAME: String = "tacc",
  OS_USERNAME: String = "bebarker",
  IDENTITY_API_VERSION: Int = 3,
){
    private lazy val OS_PASSWORD = {
        println(
          "Please enter your OpenStack Password " +
          s"for project $OS_PROJECT_NAME as user $OS_USERNAME: "
        )
        val standardIn = System.console()
        val pw = standardIn.readPassword()
        println("Finished reading password.")
        pw.toString
    }
}

object OpenRC{
    def connect(openrc: OpenRC): NovaApi = {
      val overrides = new Properties()
      overrides.put(KeystoneProperties.KEYSTONE_VERSION, s"${openrc.IDENTITY_API_VERSION}")
      overrides.put(KeystoneProperties.SCOPE, s"project:${openrc.OS_PROJECT_NAME}")

      ContextBuilder.newBuilder("openstack-nova")
        .endpoint(openrc.OS_AUTH_URL)
        .credentials(
          s"${openrc.OS_USER_DOMAIN_NAME}:${openrc.OS_USERNAME}", openrc.OS_PASSWORD
        )
        .overrides(overrides)
        .buildApi(classOf[NovaApi])

    }
}