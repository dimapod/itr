package org.itrade.jms;

import org.itrade.commons.jms.ITradeJmsMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericListener {
    Logger logger = LoggerFactory.getLogger(getClass());

    public void onMessageRed(String message) {
        logger.info("Message received RED ========= : " + message);
    }

    public void onMessageBlue(String message) {
        logger.info("Message received BLUE ========= : " + message);
    }


    public void onStructuredMessage(ITradeJmsMessage message) {
        logger.info("Message received BLUE ========= : " + message);
    }
}