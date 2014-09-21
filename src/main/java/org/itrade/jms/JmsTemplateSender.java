package org.itrade.jms;

import org.itrade.commons.jms.ITradeJmsMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;

@Service
public class JmsTemplateSender {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("jmsTemplateText")
    private JmsTemplate jmsTemplateText;

    @Autowired
    @Qualifier("jmsTemplate")
    private JmsTemplate jmsTemplate;

    public void sendMessage(String msg) {
        try {
            jmsTemplateText.send("DemoQueue", new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    TextMessage message = session.createTextMessage("test message");
                    message.setStringProperty("PROP", "red");
                    return message;
                }
            });

            jmsTemplateText.send("DemoQueue", new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    TextMessage message = session.createTextMessage("test message");
                    message.setStringProperty("text", "Hello World");
                    message.setStringProperty("PROP", "blue");
                    return message;
                }
            });
        } catch (JmsException e) {
            logger.error("Error when sending event: " + msg, e);
        }
    }

    public void sendMessageToInjection(String message, String type) {
        try {
            ITradeJmsMessage iTradeJmsMessage = new ITradeJmsMessage();
            iTradeJmsMessage.setType(type);
            iTradeJmsMessage.setOrientation("INCOMING");
            iTradeJmsMessage.setBody(message);
            jmsTemplate.convertAndSend(iTradeJmsMessage);
        } catch (JmsException e) {
            logger.error("Error when sending event: " + message, e);
        }
    }
}
