package org.itrade.controller;

import org.itrade.beans.SimpleTextBean;
import org.itrade.beans.Status;
import org.itrade.stanford.SentimentAnalyzer;
import org.itrade.stanford.TextWithSentiment;
import org.itrade.stanford.beans.SentimentResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/stanford")
public class StanfordController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SentimentAnalyzer sentimentAnalyzer;

    @RequestMapping(value = "/sentiment", method = RequestMethod.POST)
    @ResponseBody
    public SentimentResult processForEntities(@Valid @RequestBody SimpleTextBean textBean) {
        TextWithSentiment sentiment = sentimentAnalyzer.findSentiment(textBean.getText());
        return new SentimentResult(Status.OK, sentiment.getLine(), sentiment.getSentiment());
    }

}
