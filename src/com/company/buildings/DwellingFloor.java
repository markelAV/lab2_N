package com.company.buildings;

import java.util.Arrays;

public class DwellingFloor {
    private Flat[] floor;
    public Flat[] getFloor(){
        return floor;
    }
    public DwellingFloor(int number){
        floor=new Flat[number];
    }
    public DwellingFloor(Flat[] flats){
        floor=new Flat[flats.length];
        floor=flats;
    }
    public int getLengthFloor(){
        return floor.length;
    }
    public double getAreaFloor(){
        double areaF=0.0;
        for(int i =0;i<floor.length;i++){
            areaF+=floor[i].getArea();
        }
        return areaF;
    }
    public int getRoomsFloor(){
        int rooms=0;
        for(int i=0;i<floor.length;i++){
            rooms+=floor[i].getRooms();
        }
        return rooms;
    }
    public Flat getFlat(int number){
        return floor[number];
    }
    public void setFlat(int number,Flat flat){
        floor[number].setArea(flat.getArea());
        floor[number].setRooms(flat.getRooms());
    }
    public void addFlat(int number, Flat flat){
        if(number<floor.length) {
            Flat[] f = new Flat[floor.length + 1];
            int j=0;
            for (int i = 0; i < f.length; i++) {
                if (i != number) {
                    f[i] = floor[j];
                    j++;
                } else {
                    f[i] = flat;
                }
            }
            floor = Arrays.copyOf(f, floor.length + 1);
        }
    }
    public void dellFlat(int number) {
        Flat[] flats = new Flat[floor.length - 1];
        int j = 0;
        for (int i = 0; i < floor.length; i++) {
            if (i != number) {
                flats[j] = floor[i];
                j++;
            }
        }
        floor = flats;
    }
    public Flat getBestSpace(){
        Flat flat=null;
        double maxSpace=0.0;
        for(int i=0;i<floor.length;i++){
            if(floor[i].getArea()>maxSpace){
                maxSpace=floor[i].getArea();
                flat=floor[i];
            }
        }
        return flat;
    }

}
