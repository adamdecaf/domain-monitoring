package org.decaf.domains

import java.net.{InetAddress, UnknownHostException}

class DomainMonitor {

  def checkDomains(domains: Iterable[String]): Iterable[Pair[String, String]] = {
    domains.map(domain => (domain, domainExists(domain)))
  }

  def domainExists(domain: String): String = {
    try {
      InetAddress.getByName(domain)
      "Found"
    } catch {
      case _: UnknownHostException => "Not Registered"
    }
  }

}
