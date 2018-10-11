package com.company.buildings;

public class Flat {
    private int rooms;
    private double area;
    private static final int sRooms=2;
    private static final double sArea=50;

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Flat(){
        this(sArea,sRooms);
    }
    public Flat(double area){
        this(area,sRooms);
    }
    public Flat(double area, int rooms){
        this.rooms=rooms;
        this.area=area;
    }

}
