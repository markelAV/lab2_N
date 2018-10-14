package com.company.buildings;

//todo все тудушки из DwellingFloor применимы и к этому классу. ДОполнительные todo cм по тексту
public class Dwelling {
    private DwellingFloor[] floors; //todo тут floors назвал, к кто мешал в DwellingFloor flats назвать? =))))
    public Dwelling(int number,int[] nFlat){
        floors=new DwellingFloor[number];
        for(int i=0;i<number;i++){
            floors[i]=new DwellingFloor(nFlat[i]);
        }

    }
    public Dwelling(DwellingFloor[] floors){
        this.floors=new DwellingFloor[floors.length];
        this.floors=floors;
    }
    public int getSizeFloors(){
        return floors.length;
    }
    public DwellingFloor[] getFloors(){
        return floors;

    }
    public int  getFlats(){
        int nFlats=0;
        for(int i=0;i<floors.length;i++){
            nFlats=floors[i].getRoomsFloor();
        }
        return nFlats;
    }
    public double getAreaDwelling(){
        double area=0.0;
        for(int i=0; i<floors.length;i++){
            area+=floors[i].getAreaFloor();
        }
        return area;
    }
    public int getRoomsDwellling(){
        int rooms=0;
        for(int i=0; i<floors.length;i++){
            Flat[]flats=floors[i].getFloor();
            for (int j=0;j<flats.length;j++){
                rooms+=flats[j].getRooms();
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
            if((i-floors[j].getLengthFloor())>=0){
                i-=floors[j].getLengthFloor();
                j++;

            }
            else{
                flat=floors[j].getFlat(i);
                break;
            }
        }

        return flat;
    }
    //todo set изменяет ссылку на flat в массиве, а не сам объект
    public void setFlat(int number,Flat flat){
        Flat flat1=getFlat(number);
        if(flat1!=null){
            flat1.setArea(flat.getArea());
            flat1.setRooms(flat.getRooms());
        }
    }

    public void addFlat(int number,Flat flat) {
        int i = number;
        int j = 0;
        //todo убирай дублирование
        while (i >= 0) {
            if ((i - floors[j].getLengthFloor()) >= 0) {
                i -= floors[j].getLengthFloor();
                j++;

            } else {
                floors[j].addFlat(i,flat);
                break;
            }
        }
    }
    public void dellFlat(int number) {
        int i = number;
        int j = 0;
        //todo убирай дублирование
        while (i >= 0) {
            if ((i - floors[j].getLengthFloor()) >= 0) {
                i -= floors[j].getLengthFloor();
                j++;

            } else {
                floors[j].dellFlat(i);
                break;
            }
        }
    }
    public Flat getBestSpace(){
        Flat f=null;
        double mArea=0.0;
        for(int i=0;i<floors.length;i++){
            //todo дважды делаешь поиск - используй переменную, в которую запишешь bestSpace
            if((floors[i].getBestSpace().getArea())> mArea){
                f=floors[i].getBestSpace();
                mArea=f.getArea();

            }

        }
        return f;
    }

    public Flat[] getSortFlat(){
        int n=0;

        Flat[] flats = null;
        for(int i=0;i<floors.length;i++){
            n+=floors[i].getLengthFloor();
        }
        if(n>0){
            flats=new Flat[n];
            int k=0;
            for(int i=0;i<floors.length;i++){
                for(int j=0;j<floors[i].getLengthFloor();j++){
                    flats[j+k]=floors[i].getFlat(j);
                }
                k+=floors[i].getLengthFloor();
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


