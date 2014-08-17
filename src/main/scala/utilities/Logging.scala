package utilities

import org.slf4j.LoggerFactory

trait Logging {
  val logger = LoggerFactory.getLogger(getClass.getName)
}
