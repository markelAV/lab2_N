package com.company.buildings;

public interface Building {
    int getCount();
    Floor[] getFloors();
    int  countQuarters(); //todo spacesQuantity
    double areaTotal();
    int roomsTotal();
    Floor findFloor(int number); //todo getFloor
    void modificationFloor(int number, Floor floor); //todo setFloor
    Space findQuarters(int number); //todo getSpace
    void modificationQuarters(int number, Space flat);//todo setFloor
    void addQuarters(int number,Space flat); //todo add
    void removeQuarters(int number); //todo remove
    Space getBestSpace();
    Space[] SortQuarters(); //todo sortedSpaces
}
