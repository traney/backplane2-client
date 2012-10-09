package com.janrain.backplaneclient;

/**
 * @author Tom Raney
 */
public class UnauthorizedScopeException extends Throwable {
    public UnauthorizedScopeException(String response) {
        super(response);
    }
}
