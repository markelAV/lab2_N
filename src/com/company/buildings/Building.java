package com.company.buildings;

public interface Building {
    int getCount();
    Floor[] getFloors();
    int  countQuarters();
    double areaTotal();
    int roomsTotal();
    Floor findFloor(int number);
    void modificationFloor(int number, Floor floor);
    Space findQuarters(int number);
    void modificationQuarters(int number, Space flat);
    void addQuarters(int number,Space flat);
    void removeQuarters(int number);
    Space getBestSpace();
    Space[] SortQuarters();
}
