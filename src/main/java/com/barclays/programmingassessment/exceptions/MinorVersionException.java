package com.barclays.programmingassessment.exceptions;

public class MinorVersionException extends Exception{
    public MinorVersionException(){
        super("Minor version found. Only Applied for higher version");
    }
}
