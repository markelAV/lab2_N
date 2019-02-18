package com.company.buildings;

public interface Floor {
    int getCount(); //todo лучше size назвать
    double areaTotal();
    int roomsTotal();
    Space[] getQuarters();//todo лучше getSpaces назвать
    Space findQuarters(int number); //todo лучше getSpace назвать
    void modificationQuarters(int number, Space space); //todo лучше setSpace назвать
    void addQuarters(int number, Space space); //todo лучше просто add оставить
    void removeQuarters(int number); //todo лучше просто remove оставить
    Space getBestSpace();
}
