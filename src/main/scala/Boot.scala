package org.decaf.domains

import org.apache.commons.mail.SimpleEmail
import javax.mail.internet.InternetAddress
import scala.collection.JavaConversions.asJavaCollection

object Boot {

  def main(args: Array[String]) {

    println("Checking Domains")

    val domainStatuses = checkDomains()
    println(domainStatuses.mkString("\n"))
    sendEmail(domainStatuses)

    println("Done checking")
  }

  private[this] lazy val whoisClient = new DomainMonitor()

  private[this] def checkDomains() = {
    val domains = scala.io.Source.fromFile("src/main/resources/domains.list").getLines.toIterable
    whoisClient.checkDomains(domains)
  }

  private[this] def sendEmail(statuses: Iterable[Pair[String, String]]) = {
    val client = new SimpleEmail{}
    val toAddress = asJavaCollection(List(new InternetAddress("ashannon1000@gmail.com")))

    client.setHostName("ashannon.us")
    client.setTo(toAddress)
    client.setFrom("server@ashannon.us")
    client.setSubject("[Domains] Registration Status")
    client.setMsg(statuses.mkString("\n"))
    client.send()
  }
}
