package com.example.moviebookingticket.exception;

public class RequestAlreadyProcessed extends Exception{
    public RequestAlreadyProcessed(String errormessage){
        super(errormessage);
    }
}
