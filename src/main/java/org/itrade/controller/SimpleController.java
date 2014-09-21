package org.itrade.controller;

import org.itrade.jms.JmsTemplateSender;
import org.itrade.jms.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.itrade.beans.ResultBean;
import org.itrade.beans.SimpleTextBean;
import org.itrade.beans.TestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class SimpleController {
    Logger logger = LoggerFactory.getLogger(getClass());

//    @Autowired
//    private MessageSender messageSender;

    @Autowired
    private JmsTemplateSender jmsTemplateSender;


    @RequestMapping("/simple")
    @ResponseBody
    public String simple() {
        return "Hello world!";
    }

    @RequestMapping(value = "/simple/json", method = RequestMethod.GET)
    @ResponseBody
    public TestVO simpleJson() {
        logger.info("SLF Logging ========= ");
        return new TestVO("Tom", 45);
    }

    @RequestMapping(value = "/simple/jms/text", method = RequestMethod.GET)
    @ResponseBody
    public String textJms() {
        logger.info("Text message sent ========= ");
        //messageSender.send("Hello HornetQ");
        jmsTemplateSender.sendMessage("Test");
        return "Message sent";
    }

    @RequestMapping(value = "/simple/jms/structured", method = RequestMethod.GET)
    @ResponseBody
    public String structuredJms() {
        logger.info("Structured message sent ========= ");
        jmsTemplateSender.sendMessageToInjection("Structured message", "RSS");
        return "Structured message sent";
    }

}
