package com.janrain.backplaneclient;

import java.util.List;

/**
 * @author Tom Raney
 */
public class MessageWrapper {

    private String nextURL;
    private List<BackplaneMessage> messages;
    private boolean moreMessages;

    public String getNextURL() {
        return nextURL;
    }

    public List<BackplaneMessage> getMessages() {
        return messages;
    }

    public boolean isMoreMessages() {
        return moreMessages;
    }

    public void setNextURL(String nextURL) {
        this.nextURL = nextURL;
    }

    public void setMessages(List<BackplaneMessage> messages) {
        this.messages = messages;
    }

    public void setMoreMessages(boolean moreMessages) {
        this.moreMessages = moreMessages;
    }
}
