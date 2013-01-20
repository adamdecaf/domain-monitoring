package org.decaf.domains

object Boot {

  def main(args: Array[String]) {

    println("Checking Domains")

    val domainStatuses = checkDomains()
    println(domainStatuses.mkString("\n"))

    println("Done checking")
    sys.exit(0)
  }

  private[this] lazy val whoisClient = new DomainMonitor()

  private[this] def checkDomains() = {
    val domains = scala.io.Source.fromFile("src/main/resources/domains.list").getLines.toIterable
    whoisClient.checkDomains(domains)
  }

}
