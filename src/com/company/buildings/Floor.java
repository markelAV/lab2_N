package com.company.buildings;

public interface Floor {
    int getCount();
    double areaTotal();
    int roomsTotal();
    Space[] getQuarters();
    Space findQuarters(int number);
    void modificationQuarters(int number, Space space);
    void addQuarters(int number, Space space);
    void removeQuarters(int number);
    Space getBestSpace();
}
