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

    //todo вот тут ты понаписал говнокода. Весь метод какая-то хрень
    /*
    1) 1 проверка если size == length - тогда расширяешь массив - создаешь новый с вдвое большим размером, копируешь туда элементы из исходного, созарняешь во flats ссылку на новый массив
       2 далее сдвигаешь элементы массива на один вправо, начиная с number
       3 в элемент массива с номером number записываешь ссылку на переданный flat

     */
    public void addFlat(int number, Flat flat){
        if(size<flats.length) {
            if (number < size) {
                Flat[] flats = new Flat[size+1];
                int j = 0;
                for (int i = 0; i < size; i++, j++) {
                    if (i != number) {
                        flats[j] = this.flats[i];
                    } else {
                        flats[j] = flat;
                        j++;
                    }
                }

                size++;
                System.arraycopy(flats, 0, this.flats, 0, size);
            } else {
                flats[size].setArea(flat.getArea());
                flats[size].setRoomsCount(flat.getRoomsCount());
                size++;

            }
        }
        else {

           Flat[] flats= new Flat[2*size];
            for (int i = 0; i <2*size ; i++) {
                flats[i]=new Flat();
            }
           System.arraycopy(this.flats,0,flats,0,size);
            flats[size].setRoomsCount(flat.getRoomsCount());
            flats[size].setArea(flat.getArea());
            size*=2;
            this.flats=new Flat[size];
            System.arraycopy(flats,0,this.flats,0,size);
        }
    }

    public void dellFlat(int number) {
        if(number<size){
            size--;
            Flat[] flats = new Flat[size]; //todo не нужно нвый массив создавать System.arraycopy может копировать элементы в рамках одного и того же массива
            //поэтому достаточно будет одного вызова метода arraycopy, чтоб сдвинуть элементы влево, начиная с number+1
            System.arraycopy(this.flats,0,flats,0,number);
            System.arraycopy(this.flats,number+1,flats,number,size-number-1);
        }
    }
    public Flat getBestSpace(){
        Flat flat=flats[0]; //todo не null, а flats[0]+(Почему нельзя null??)
        double maxSpace=0.0; //потому что: 1) здесь нужно double maxSpace = flat.getArea()
        for(int i = 0; i< size; i++){ //2) и потом цикл стартуешь не с 0, а с 1
            if(flats[i].getArea()>maxSpace){
                maxSpace= flats[i].getArea();
                flat= flats[i];
            }
        }
        return flat;
    }

}
