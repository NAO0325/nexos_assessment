/*
 * Nexos Software
 */
package com.credibanco.assessment.library.exceptions;

/**
 *
 * @author Napoleon Avila Ochoa
 */
public class ServicosWebException extends Exception {

    private String description;

    public ServicosWebException(String message) {
        super(message);
    }

    public ServicosWebException(String message, String description) {
        super(message);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
