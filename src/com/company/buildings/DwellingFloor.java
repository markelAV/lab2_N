package com.company.buildings;

import java.util.Arrays;

//todo подсмостри реализацию у java.util.ArrayList
public class DwellingFloor {
    private Flat[] floor; //todo переименуй. стандартные правила именования коллекций - тип во множественном числе, т.е. flats
        /*todo добавь поле size, хранящее число добавленных квартир.
    И ВСЕ циклы внутри методов у тебя будут НЕ от 0 до length (или for-each) с проверкой на !=null,
    а просто от 0 до size
     */
    //todo переименуй и измени реализацию с учетом наличия поля size - возвращаешь копию массива размера size
    public Flat[] getFloor(){
        return floor;
    }
    public DwellingFloor(int number){
        floor=new Flat[number];
    }
    public DwellingFloor(Flat[] flats){
        floor=new Flat[flats.length]; //todo нафига создаешь новый массив, а потом ссылку на него все равно переписываешь
        floor=flats;
    }
    //todo здесь вернуть size
    public int getLengthFloor(){
        return floor.length;
    }
    //todo переименуй и измени реализацию с учетом наличия поля size
    //todo имя не ахти, areaTotal - было бы вообще супер. get используется в основном для свойств, если работаешь с атрибутом, а не что-то подсчитываешь
    public double getAreaFloor(){
        double areaF=0.0;
        for(int i =0;i<floor.length;i++){
            areaF+=floor[i].getArea();
        }
        return areaF;
    }
    //todo переименуй и измени реализацию с учетом наличия поля size (см метод getAreaFloor)
    public int getRoomsFloor(){
        int rooms=0;
        for(int i=0;i<floor.length;i++){
            rooms+=floor[i].getRooms();
        }
        return rooms;
    }
    public Flat getFlat(int number){
        return floor[number];
    }
    public void setFlat(int number,Flat flat){
        //todo нене, тут не изменяешь объект, а сохраняешь в массив ссылку на передвавйемый flat
        floor[number].setArea(flat.getArea());
        floor[number].setRooms(flat.getRooms());
    }
    /*todo измени реализацию с учетом наличия поля size.
   1) Не забывай каждый раз, добавляя Flat, увеличивать size
   2) Если в массиве уже нет места (length = size), то создавай новый НЕ на 1 элемент больше (операции создания и копирования затратные),
      обычно массив увеличивается в 1,5 или 2 раза
   3) Arrays - утилитный класс, незя пользовать
   4) Копирование элементов из массива в массив - System.arraycopy - он же не утильный =))))

 */
    public void addFlat(int number, Flat flat){
        if(number<floor.length) {
            Flat[] f = new Flat[floor.length + 1];
            int j=0;
            for (int i = 0; i < f.length; i++) {
                if (i != number) {
                    f[i] = floor[j];
                    j++;
                } else {
                    f[i] = flat;
                }
            }
            floor = Arrays.copyOf(f, floor.length + 1);
        }
    }
    /*todo измени реализацию с учетом наличия поля size.
 1) Не забывай каждый раз, удаляя Flat, уменьшать size
 2) Не нужно уменьшать каждый раз размер массива. Уменьшай только size. Операции по созданию новых массивов и копированию элементов стараются выполнять как можно реже
 3) вынеси код, по копированию элементов массива в отдельный приватный метод (или используй System.arraycopy - он же не утильный =))))
*/
    public void dellFlat(int number) {
        Flat[] flats = new Flat[floor.length - 1];
        int j = 0;
        for (int i = 0; i < floor.length; i++) {
            if (i != number) {
                flats[j] = floor[i];
                j++;
            }
        }
        floor = flats;
    }
    public Flat getBestSpace(){
        Flat flat=null; //todo не null, а flats[0]
        double maxSpace=0.0;
        for(int i=0;i<floor.length;i++){
            if(floor[i].getArea()>maxSpace){
                maxSpace=floor[i].getArea();
                flat=floor[i];
            }
        }
        return flat;
    }

}
