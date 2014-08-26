package org.itrade.alchemy;

import org.itrade.alchemy.api.AlchemyAPI;
import org.itrade.beans.SimpleTextBean;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class AlchemyManager {

    private AlchemyAPI alchemyObj;

    @PostConstruct
    public void init() {
        try {
            String home = System.getProperty("user.home");
            alchemyObj = AlchemyAPI.GetInstanceFromFile(home + "/alchemy_api_key.txt");
        } catch (IOException e) {
            throw new RuntimeException("Alchemy API failed to initialise", e);
        }
    }

    public String getEntitiesFromText(SimpleTextBean textBean) {
        // Extract a ranked list of named entities from a text string.
        Document doc = null;
        try {
            doc = alchemyObj.TextGetRankedNamedEntities(textBean.getText());
        } catch (Exception e) {
            throw new RuntimeException("Something went wring when calling AlchemyAPI", e);
        }

        if (doc == null) {
            throw new RuntimeException("Error: Alchemy document is empty");
        }

        return AlchemyUtils.getStringFromDocument(doc);
    }
}














