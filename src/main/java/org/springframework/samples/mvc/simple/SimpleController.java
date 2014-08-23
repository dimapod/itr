package org.springframework.samples.mvc.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.samples.mvc.simple.beans.TestVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {

    Logger logger = LoggerFactory.getLogger(SimpleController.class);


    @RequestMapping("/simple")
    public
    @ResponseBody
    String simple() {
        return "Hello world!";
    }

    @RequestMapping(value = "/simple/json", method = RequestMethod.GET)
    public
    @ResponseBody
    TestVO simpleJson() {

        logger.info("SLF Logging ========= ");

        TestVO testVO = new TestVO("Tom", 45);

        return testVO;
    }

}
