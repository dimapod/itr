package org.itrade.controller;

import org.itrade.alchemy.AlchemyManager;
import org.itrade.beans.ResultBean;
import org.itrade.beans.SimpleTextBean;
import org.itrade.beans.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;

import javax.validation.Valid;

@Controller
@RequestMapping("/alchemy")
public class AlchemyController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AlchemyManager alchemyManager;

    @RequestMapping(value = "/entities", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean processForEntities(@Valid @RequestBody SimpleTextBean textBean) {
        String response = alchemyManager.getEntitiesFromText(textBean);

        return new ResultBean(Status.OK, response);
    }

}
