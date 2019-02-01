package com.company;

public class InvalidRoomsCountException extends IllegalArgumentException {
    public InvalidRoomsCountException(){
        super("Неккоректное количество комнат в помещении ");
    }
}
