package com.janrain.backplaneclient;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author Tom Raney
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BackplaneMessage {

    private String bus;
    private String channel;
    private Object payload;
    private String source;
    private boolean sticky;
    private String type;
    private String messageURL;
    private String expire;

    public BackplaneMessage() {};

    public BackplaneMessage(
        String bus, 
        String channel, 
        String type, 
        Object payload, 
        boolean sticky, 
        String expire) 
    {
        this.bus = bus;
        this.channel = channel;
        this.payload = payload;
        this.sticky = sticky;
        this.type = type;
        this.expire = expire;
    }
    
    public BackplaneMessage(
        String bus, 
        String channel, 
        String type, 
        Object payload, 
        boolean sticky, 
        int timeTilExpires) 
    {
        this.bus = bus;
        this.channel = channel;
        this.payload = payload;
        this.sticky = sticky;
        this.type = type;

        // Ensure time until expiration is within range.
        if (timeTilExpires < 0)
        {
            timeTilExpires = 0;
        }
        else if (timeTilExpires > 28800)
        {
            timeTilExpires = 28800;
        }
        
        // Get current time, add time until expiration, format it and save.
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, timeTilExpires);                       
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));       
        this.expire = dateFormat.format(cal.getTime());
    }

    public String toString()
    {
        try
        {
            return new ObjectMapper().writeValueAsString(this);
        }
        catch (Exception e)
        {
            return "BackplaneMessage.toString() ERROR";
        }
    }
    
    public String getExpire() {
        return expire;
    }
    
    public String getBus() {
        return bus;
    }

    public String getChannel() {
        return channel;
    }

    public Object getPayload() {
        return payload;
    }

    public String getSource() {
        return source;
    }

    public boolean isSticky() {
        return sticky;
    }

    public String getType() {
        return type;
    }

    public String getMessageURL() {
        return messageURL;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    /**
     * This method is provided for the downstream message from the Backplane server.  Do not set the source field
     * for upstream messages.
     *
     * @param source
     */
    public void setSource(String source) {
        this.source = source;
    }

    public void setSticky(boolean sticky) {
        this.sticky = sticky;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method is provided for the downstream message from the Backplane server.  Do not set the messageURL
     * for upstream messages.
     *
     * @param messageURL
     */
    public void setMessageURL(String messageURL) {
        this.messageURL = messageURL;
    }
}
