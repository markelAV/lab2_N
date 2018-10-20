package com.company.buildings;

public class Dwelling {
    private DwellingFloor[] floors;
    private int size;
    public Dwelling(int number,int[] nFlat){
        size=number;
        floors=new DwellingFloor[number];
        for(int i=0;i<size;i++){
            floors[i]=new DwellingFloor(nFlat[i]);
        }

    }
    public Dwelling(DwellingFloor[] floors){
        size=floors.length;
        this.floors=new DwellingFloor[size];
        System.arraycopy(floors,0,this.floors,0,size);
    }
    public int getSize(){
        return size;
    }
    public DwellingFloor[] getFloors(){
        DwellingFloor[] floors=new DwellingFloor[size];
        System.arraycopy(this.floors,0,floors,0,size);
        return floors;

    }
    public int  countFlat(DwellingFloor floor){
        return floor.getSize();
    }
    public double areaTotal(){
        double area=0.0;
        for(int i=0; i<size;i++){
            area+=floors[i].areaTotal();
        }
        return area;
    }
    public int roomsTotal(){
        int rooms=0;
        for(int i=0; i<floors.length;i++){
            Flat[]flats=floors[i].getFlats();
            for (int j=0;j<flats.length;j++){
                rooms+=flats[j].getRoomsCount();
            }
        }
        return rooms;
    }
    public DwellingFloor getFloor(int number){
        return floors[number];
    }
    public void setFloor(int number,DwellingFloor floor){
        this.floors[number]=floor;

    }
    public Flat getFlat(int number){
        Flat flat=null;
        int i =number;
        int j=0;
        //todo убирай дублирование
        while(i>=0){
            i-=floors[j].getSize();
            if(i>=0){
                j++;
            }
            else{
                flat=floors[j].getFlat(i+floors[j].getSize());
                break;
            }
        }

        return flat;


    }
    //todo set изменяет ссылку на flat в массиве, а не сам объект+
    public void setFlat(int number,Flat flat){
        Flat flat1=getFlat(number);
        if(flat1!=null){
            flat1=flat;
        }
    }

    public void addFlat(int number,Flat flat) {
        int i = number;
        int j = 0;
        //todo убирай дублирование+
        while (i >= 0) {
            i -= floors[j].getSize();
            if (i >= 0) {
                j++;
            } else {
                floors[j].addFlat(i+floors[j].getSize(),flat);
                break;
            }
        }
    }
    public void dellFlat(int number) {
        int i = number;
        int j = 0;
        //todo убирай дублирование+
        while (i >= 0) {
            i -= floors[j].getSize();
            if (i>= 0) {
                j++;

            } else {
                floors[j].dellFlat(i+floors[j].getSize());
                break;
            }
        }
    }
    public Flat getBestSpace(){
        Flat f=null;
        double mArea=0.0;
        double area=0.0;
        for(int i=0;i<size;i++){
            //todo дважды делаешь поиск - используй переменную, в которую запишешь bestSpace+
           area=floors[i].getBestSpace().getArea();
            if(area> mArea){
                f=floors[i].getBestSpace();
                mArea=area;

            }

        }
        return f;
    }

    public Flat[] getSortFlat(){
        int n=0;

        Flat[] flats = null;
        for(int i=0;i<floors.length;i++){
            n+=floors[i].getSize();
        }
        if(n>0){
            flats=new Flat[n];
            int k=0;
            for(int i=0;i<floors.length;i++){
                for(int j=0;j<floors[i].getSize();j++){
                    flats[j+k]=floors[i].getFlat(j);
                }
                k+=floors[i].getSize();
            }

            for(int i = flats.length-1 ; i > 0 ; i--){
                for(int j = 0 ; j < i ; j++){

            if( flats[j].getArea() < flats[j+1].getArea() ){
                Flat tmp = flats[j];
                flats[j] = flats[j+1];
                flats[j+1] = tmp;
            }
        }
    }

        }
        return flats;
    }

}


