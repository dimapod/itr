package org.itrade.stanford;

import org.junit.Before;
import org.junit.Test;

public class SentimentAnalyzerTest {

    private SentimentAnalyzer sentimentAnalyzer;
    private String positiveReview;
    private String negativeReview;

    @Before
    public void setUp() throws Exception {
        sentimentAnalyzer = new SentimentAnalyzer();

        positiveReview = "I have got to tell anyone who will listen that this is one of THE best adventure movies I've ever seen.";
        negativeReview = "Clearly you were offered a few bucks to help promote this film and give it some credibility, but is money worth more than credibility?";
    }

    @Test
    public void should_detect_positive_sentiment() {
        TextWithSentiment sentiment = sentimentAnalyzer.findSentiment(positiveReview);
        System.out.println(sentiment);
    }

    @Test
    public void should_detect_negative_sentiment() {
        TextWithSentiment sentiment = sentimentAnalyzer.findSentiment(negativeReview);
        System.out.println(sentiment);
    }

}