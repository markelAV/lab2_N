package com.company;

import com.company.buildings.*;

public class Main {

    public static void main(String[] args) {

        int[] rooms ={1,2,3,4,5};
        int size=5;
        double[] area={36.8,49.2,60.0,70.5,81.4};
        Office office = new Office(10,100.0);
        Flat flat = new Flat();
        Office[] offices = new Office[size];
        for(int i=0;i<size;i++){
            offices[i]=new Office(rooms[i],area[i]);
        }
        OfficeFloor officeFloor = new OfficeFloor(5);
        OfficeFloor[] officeFloors = new OfficeFloor[4];
        for(int i = 0;i<4;i++){
            officeFloors[i]= new OfficeFloor(offices);
        }
        OfficeBuilding officeBuilding = new OfficeBuilding(officeFloors);
        System.out.println(officeBuilding.getCount());
        System.out.println(officeBuilding.countQuarters());
        System.out.println(officeBuilding.areaTotal());
        System.out.println(officeBuilding.roomsTotal());

        //OfficeFloor[] officeFloors1 = officeBuilding.getFloors();
        //OfficeFloor officeFloor1 = officeBuilding.findFloor(0);
        //officeBuilding.removeQuarters(19);
        //officeBuilding.addQuarters(17,office);
        //officeBuilding.modificationQuarters(16,office);
        //System.out.println(officeBuilding.findQuarters(6).getRoomsCount());
        //officeBuilding.modificationFloor(officeFloor,1);
        /*System.out.println('*');
        Office[] offices1=officeBuilding.SortQuarters();
        for(int i=0;i<offices1.length;i++){
            System.out.println(offices1[i].getArea());
        }
        System.out.println('*');
        */
        //System.out.println(officeBuilding.getBestSpace().getArea());
       // officeBuilding.addQuarters(0,flat);
        System.out.println("Now");
        System.out.println(officeBuilding.getCount());
        System.out.println(officeBuilding.countQuarters());
        System.out.println(officeBuilding.areaTotal());
        System.out.println(officeBuilding.roomsTotal());







       /* Flat[] flats =new Flat[rooms.length];
        for(int i=0;i<flats.length;i++){
            flats[i]=new Flat(area[i],rooms[i]);
        }
        DwellingFloor[] floors=new DwellingFloor[4];
        for(int i=0;i<floors.length;i++){
            floors[i]=new DwellingFloor(flats);
        }
        Flat bigFlat =new Flat(100.12,6);
        Dwelling home = new Dwelling(floors);
        //int f=home.findQuarters();
        int r=home.roomsTotal();
        double a=home.areaTotal();
        Flat flat =home.findQuarters(13);
        home.modificationQuarters(15,flat);
        home.addQuarters(14,bigFlat);
        home.removeQuarters(12);
        Flat[] fls =home.SortQuarters();
        System.out.println(home.areaTotal());
        flat=home.getBestSpace();
        System.out.println(2);*/


    }
}
