package org.itrade.beans;

import org.hibernate.validator.constraints.NotEmpty;

public class SimpleTextBean {
    @NotEmpty
    private String text;

    public SimpleTextBean() {
    }

    public SimpleTextBean(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "SimpleTextBean{" +
                "text='" + text + '\'' +
                '}';
    }
}
