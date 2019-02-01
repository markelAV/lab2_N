package com.company;

public class InvalidSpaceAreaException extends IllegalArgumentException{
    public InvalidSpaceAreaException(){
        super("Некорректная площадь помещения");
    }
}
