package org.itrade.stanford;

/**
 * Created by dimapod on 14/09/14.
 */
public class TextWithSentiment {
    private String line;
    private int sentiment;

    public TextWithSentiment() {
    }

    public TextWithSentiment(String line, int sentiment) {
        super();
        this.line = line;
        this.sentiment = sentiment;
    }

    public TextWithSentiment(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }

    public int getSentiment() {
        return sentiment;
    }

    @Override
    public String toString() {
        return "TweetWithSentiment [line=" + line + ", sentiment=" + sentiment + "]";
    }
}
