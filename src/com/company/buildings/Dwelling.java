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

    private DTO findIndexs(int number)
    {
        DTO dto=null;
        int i=number;
        int j=0;
        while(i>=0){
            i-=floors[j].getSize();
            if(i>=0){
                j++;
            }
            else{
                dto=new DTO(j,i+floors[j].getSize());
                break;
            }
        }
        return dto;
    }
    public Flat getFlat(int number){
        Flat flat=null;
        DTO dto=findIndexs(number);
        if(dto!=null){
            flat=floors[dto.getIndexOfFloor()].getFlat(dto.getIndexOfFlat());
        }

        return flat;


    }

    public void setFlat(int number,Flat flat){
        Flat flat1=getFlat(number);
        if(flat1!=null){
            flat1=flat;
        }
    }

    public void addFlat(int number,Flat flat) {
        DTO dto=findIndexs(number);
        if(dto!=null){
            floors[dto.getIndexOfFloor()].addFlat(dto.getIndexOfFlat(),flat);
        }

    }
    public void dellFlat(int number) {
        DTO dto=findIndexs(number);
        if(dto!=null){
            floors[dto.getIndexOfFloor()].dellFlat(dto.getIndexOfFlat());
        }

    }
    public Flat getBestSpace(){
        Flat bestSpace=floors[0].getBestSpace();
        Flat flat;
        double mArea=bestSpace.getArea();
        for(int i=1;i<size;i++){
            //todo дважды делаешь поиск - используй переменную, в которую запишешь bestSpace+
            flat=floors[i].getBestSpace();
            if(flat.getArea()> mArea){
                bestSpace=flat;
                mArea=flat.getArea();
            }
        }
        return bestSpace;
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


