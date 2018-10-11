package com.company;

import com.company.buildings.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] rooms ={1,2,3,4,5};
        double[] area={36.8,49.2,60.0,70.5,81.4};
        Flat[] flats =new Flat[rooms.length];
        for(int i=0;i<flats.length;i++){
            flats[i]=new Flat(area[i],rooms[i]);
        }
        DwellingFloor[] floors=new DwellingFloor[4];
        for(int i=0;i<floors.length;i++){
            floors[i]=new DwellingFloor(flats);
        }
        Dwelling home = new Dwelling(floors);
        int f=home.getFlats();
        int r=home.getRoomsDwellling();
        double a=home.getAreaDwelling();
        Flat flat =home.getFlat(13);
        home.setFlat(15,flat);
        home.addFlat(14,flat);
        home.dellFlat(12);
        Flat[] fls =home.getSortFlat();
        System.out.println(home.getBestSpace().getArea());

    }
}
