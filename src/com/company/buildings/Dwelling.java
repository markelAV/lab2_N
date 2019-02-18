package com.company.buildings;

public class Dwelling implements Building {
    private Floor[] floors;
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
    public int getCount(){
        return size;
    }
    public Floor[] getFloors(){
        DwellingFloor[] floors=new DwellingFloor[size];
        System.arraycopy(this.floors,0,floors,0,size);
        return floors;

    }

    public int countQuarters(){
        int res=0;
        for (int i = 0; i <floors.length ; i++) {
            res+=floors[i].getCount();
        }
        return res;
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
            rooms+=floors[i].roomsTotal();
        }
        return rooms;
    }
    public Floor findFloor(int number){
        return floors[number];
    }
    public void modificationFloor(int number, Floor floor){
        this.floors[number]=floor;

    }

    private DTO findIndexs(int number) {
        DTO dto=null;
        int i=number;
        int j=0;
        while(i>=0){
            i-=floors[j].getCount();
            if(i>=0){
                j++;
            }
            else{
                dto=new DTO(j,i+floors[j].getCount());
                break;
            }
        }
        return dto;
    }
    public Space findQuarters(int number){
        Space flat=null;
        DTO dto=findIndexs(number);
        if(dto!=null){
            flat=floors[dto.getIndexOfFloor()].findQuarters(dto.getIndexOfFlat());
        }
        return flat;
    }

    public void modificationQuarters(int number, Space flat){
        DTO indexs = findIndexs(number);
        if(indexs!=null) {
            floors[indexs.getIndexOfFloor()].modificationQuarters(indexs.getIndexOfFlat(), flat);
        }
    }

    public void addQuarters(int number, Space flat) {
        DTO dto=findIndexs(number);
        if(dto!=null){
            floors[dto.getIndexOfFloor()].addQuarters(dto.getIndexOfFlat(),flat);
        }

    }
    public void removeQuarters(int number) {
        DTO dto=findIndexs(number);
        if(dto!=null){
            floors[dto.getIndexOfFloor()].removeQuarters(dto.getIndexOfFlat());
        }

    }
    public Space getBestSpace(){
        Space bestSpace=floors[0].getBestSpace();
        Space flat;
        double mArea=bestSpace.getArea();
        for(int i=1;i<size;i++){
            flat=floors[i].getBestSpace();
            if(flat.getArea()> mArea){
                bestSpace=flat;
                mArea=flat.getArea();
            }
        }
        return bestSpace;
    }

    public Space[] SortQuarters(){
        int n=0;

        Space[] flats = null;
        for(int i=0;i<floors.length;i++){
            n+=floors[i].getCount();
        }
        if(n>0){
            flats=new Space[n];
            int k=0;
            for(int i=0;i<floors.length;i++){
                for(int j = 0; j<floors[i].getCount(); j++){
                    flats[j+k]=floors[i].findQuarters(j);
                }
                k+=floors[i].getCount();
            }

            for(int i = flats.length-1 ; i > 0 ; i--){
                for(int j = 0 ; j < i ; j++){

            if( flats[j].getArea() < flats[j+1].getArea() ){
                Space tmp = flats[j];
                flats[j] = flats[j+1];
                flats[j+1] = tmp;
            }
        }
    }

        }
        return flats;
    }

    private class DTO{
        private int indexOfFlat;
        private int indexOfFloor;

        public int getIndexOfFlat() {
            return indexOfFlat;
        }

        public int getIndexOfFloor() {
            return indexOfFloor;
        }

        public void setIndexOfFlat(int indexOfFlat) {
            this.indexOfFlat = indexOfFlat;
        }

        public void setIndexOfFloor(int indexOfFloor) {
            this.indexOfFloor = indexOfFloor;
        }
        public DTO(){
            this(0,0);
        }
        public DTO(int nFloor,int nFlat){
            indexOfFlat=nFlat;
            indexOfFloor=nFloor;
        }
    }

}


