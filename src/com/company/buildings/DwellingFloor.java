package com.company.buildings;


//todo подсмостри реализацию у java.util.ArrayList
public class DwellingFloor {
    private Flat[] flats; //todo переименуй. стандартные правила именования коллекций - тип во множественном числе, т.е. flats+
    private int size;
        /*todo добавь поле size, хранящее число добавленных квартир. +
    И ВСЕ циклы внутри методов у тебя будут НЕ от 0 до length (или for-each) с проверкой на !=null,
    а просто от 0 до size
     */
    //todo переименуй и измени реализацию с учетом наличия поля size - возвращаешь копию массива размера size+
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
        this.flats =new Flat[size]; //todo нафига создаешь новый массив, а потом ссылку на него все равно переписываешь+
        System.arraycopy(flats,0,this.flats,0,size);

    }
    //todo здесь вернуть size+
    public int getSize(){
        return size;
    }
    //todo переименуй и измени реализацию с учетом наличия поля size+
    //todo имя не ахти, areaTotal - было бы вообще супер. get используется в основном для свойств, если работаешь с атрибутом, а не что-то подсчитываешь+
    public double areaTotal(){
        double areaF=0.0;
        for(int i = 0; i< size; i++){
            areaF+= flats[i].getArea();
        }
        return areaF;
    }
    //todo переименуй и измени реализацию с учетом наличия поля size (см метод areaTotal)+
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
        //todo нене, тут не изменяешь объект, а сохраняешь в массив ссылку на передвавйемый flat+
        flats[number]=flat;

    }
    /*todo измени реализацию с учетом наличия поля size. +
   1) Не забывай каждый раз, добавляя Flat, увеличивать size
   2) Если в массиве уже нет места (length = size), то создавай новый НЕ на 1 элемент больше (операции создания и копирования затратные),
      обычно массив увеличивается в 1,5 или 2 раза
   3) Arrays - утилитный класс, незя пользовать
   4) Копирование элементов из массива в массив - System.arraycopy - он же не утильный =))))

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

    /*todo измени реализацию с учетом наличия поля size.
 1) Не забывай каждый раз, удаляя Flat, уменьшать size
 2) Не нужно уменьшать каждый раз размер массива. Уменьшай только size. Операции по созданию новых массивов и копированию элементов стараются выполнять как можно реже
 3) вынеси код, по копированию элементов массива в отдельный приватный метод (или используй System.arraycopy - он же не утильный =))))
*/
    public void dellFlat(int number) {
        if(number<size){
            size--;
            Flat[] flats = new Flat[size];
            System.arraycopy(this.flats,0,flats,0,number);
            System.arraycopy(this.flats,number+1,flats,number,size-number-1);
        }
    }
    public Flat getBestSpace(){
        Flat flat=flats[0]; //todo не null, а flats[0]+(Почему нельзя null??)
        double maxSpace=0.0;
        for(int i = 0; i< size; i++){
            if(flats[i].getArea()>maxSpace){
                maxSpace= flats[i].getArea();
                flat= flats[i];
            }
        }
        return flat;
    }

}
