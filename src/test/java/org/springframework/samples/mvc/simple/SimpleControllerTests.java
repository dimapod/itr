package org.springframework.samples.mvc.simple;

import org.itrade.alchemy.AlchemyUtils;
import org.itrade.alchemy.api.AlchemyAPI;
import org.itrade.controller.SimpleController;
import org.junit.Test;
import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SimpleControllerTests {

	@Test
	public void simple() throws Exception {
		standaloneSetup(new SimpleController()).build()
			.perform(get("/simple"))
			.andExpect(status().isOk())
			.andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
			.andExpect(content().string("Hello world!"));
	}

	@Test
	public void mockito() throws Exception {
        SimpleController simpleController = mock(SimpleController.class);
        when(simpleController.simple()).thenReturn("Mockito rocks");
        simpleController.simple();
        verify(simpleController, times(1));
    }

    //@Test
    public void alchemy() throws Exception {
        // Create an AlchemyAPI object.
        AlchemyAPI alchemyObj = AlchemyAPI.GetInstanceFromFile("/tmp/alchemy_api_key.txt");

/*
        // Extract a ranked list of named entities for a web URL.
        Document doc = alchemyObj.URLGetRankedNamedEntities("http://www.techcrunch.com/");
        System.out.println(getStringFromDocument(doc));
*/

        // Extract a ranked list of named entities from a text string.
        Document doc = alchemyObj.TextGetRankedNamedEntities(
                "Hello there, my name is Bob Jones. I live in the United States of America.  " +
                        "Where do you live, Fred?");
        System.out.println(AlchemyUtils.getStringFromDocument(doc));
    }
}
