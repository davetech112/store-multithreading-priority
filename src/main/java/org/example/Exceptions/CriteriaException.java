package org.example.Exceptions;

public class CriteriaException extends Exception{
   private String message;

    public CriteriaException(String message) {
        super(message);
        this.message = message;
    }
}
