package com.vti.exception;

public class ClassRoomNotFoundException extends RuntimeException{
    public ClassRoomNotFoundException(String message){
        super(message);
    }
}
