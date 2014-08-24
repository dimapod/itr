package org.itrade.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.itrade.beans.ResultBean;
import org.itrade.beans.SimpleTextBean;
import org.itrade.beans.TestVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class SimpleController {
    Logger logger = LoggerFactory.getLogger(getClass());


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

}
