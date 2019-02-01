package com.company.buildings;

import com.company.InvalidRoomsCountException;
import com.company.InvalidSpaceAreaException;

public class Office implements Space {
    private double area;
    private int roomsCount;
    private static final int ROOMS_COUNT_DEFAULT=1;
    private static final double AREA_DEFAULT= 250;
    public Office(){
        this(ROOMS_COUNT_DEFAULT, AREA_DEFAULT);
    }
    public Office(double area){
        this(ROOMS_COUNT_DEFAULT,area);
    }
    public Office(int roomsCount,double area) {
        setArea(area);
        setRoomsCount(roomsCount);
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(int roomsCount) {
        if(roomsCount<=0) throw new InvalidRoomsCountException();
        this.roomsCount = roomsCount;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        if(area <=0) throw new InvalidSpaceAreaException();
        this.area = area;
    }
}
