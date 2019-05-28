package com.packs.FindWorksProject.controllers

import com.packs.FindWorksProject.services.DataProducer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RestController}

@RestController
@RequestMapping(Array("/findworks"))
class MainController {

  @Autowired
  var dataProducer: DataProducer = null

  @GetMapping(Array("/test"))
  def testApp(): String = {
    "This is Findworks"
  }

  @GetMapping(Array("/start"))
  def startProducer(): String = {
    dataProducer.startProducer()
    "started"
  }
}
