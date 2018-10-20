package com.company.buildings;

public class Flat {
    private int roomsCount; //todo roomsCOunt было бы корректнее +
    private double area;
    private static final int ROOMS_COUNT_DEFAULT =2; //todo Константы в Java записываются в формате ROOMS_COUNT_DEFAULT +
    private static final double AREA_DEFAULT =50;

    public int getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(int roomsCount) {
        this.roomsCount = roomsCount;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Flat(){
        this(AREA_DEFAULT, ROOMS_COUNT_DEFAULT);
    }
    public Flat(double area){
        this(area, ROOMS_COUNT_DEFAULT);
    }
    public Flat(double area, int rooms){
        this.roomsCount =rooms;
        this.area=area;
    }

}
