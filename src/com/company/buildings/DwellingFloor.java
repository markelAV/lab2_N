package com.company.buildings;


public class DwellingFloor {
    private Flat[] flats;
    private int size;

    public Flat[] getFlats(){
        Flat[] flats=new Flat[size];
        System.arraycopy(this.flats,0,flats,0,size);
        return flats;

    }

    public DwellingFloor(int number){
        size=number;
        flats =new Flat[size];
        for (int i = 0; i <size; i++) {
            flats[i]=new Flat();

        }
    }

    public DwellingFloor(Flat[] flats){
        size=flats.length;
        this.flats =new Flat[size];
        System.arraycopy(flats,0,this.flats,0,size);

    }
    public int getSize(){
        return size;
    }

    public double areaTotal(){
        double areaF=0.0;
        for(int i = 0; i< size; i++){
            areaF+= flats[i].getArea();
        }
        return areaF;
    }
    public int roomsTotal(){
        int rooms=0;
        for(int i = 0; i< size; i++){
            rooms+= flats[i].getRoomsCount();
        }
        return rooms;
    }
    public Flat getFlat(int number){
        return flats[number];
    }
    public void setFlat(int number,Flat flat){
        flats[number]=flat;

    }

    public void addFlat(int number, Flat flat) {

        if (number <= size) {
            if (size == flats.length) {
                Flat[] flats = new Flat[size * 2];
                System.arraycopy(this.flats, 0, flats, 0, size);
                this.flats = flats;
            }
            System.arraycopy(this.flats, number, this.flats, number + 1, size - number);
            this.flats[number] = flat;
//todo size забыл увеличить
        }
    }

    public void dellFlat(int number) {

        if(number<size){

            System.arraycopy(this.flats,number+1,flats,number,size-number);
            size--;
        }
    }
    public Flat getBestSpace(){
        Flat flat=flats[0];
        double maxSpace=flat.getArea();
        for(int i = 1; i< size; i++){
            if(flats[i].getArea()>maxSpace){
                maxSpace= flats[i].getArea();
                flat= flats[i];
            }
        }
        return flat;
    }

}
