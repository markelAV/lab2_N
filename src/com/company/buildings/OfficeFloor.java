package com.company.buildings;

import com.company.SpaceIndexOutOfBoundsException;

public class OfficeFloor implements Floor{
    private Node head;
    private int count;
    private void listInit(Space[] offices){
        head=new Node();
        head.setNext(head);
        Node node;
        for(int i =0;i<offices.length;i++){
            node=new Node(offices[i]);
            addNode(node,i);
        }
    }

    public OfficeFloor(int count){
        Office[] offices = new Office[count];
        for(int i =0; i<count;i++){
            offices[i]=new Office(); //todo а сразу в цикле вызывать метод add () не засовывая в массив не?
        }
        listInit(offices);

    }
    public OfficeFloor(Space[] offices){
       listInit(offices);
    }

    public int getCount(){
        return count;
    }
    public double areaTotal(){
        Node current=head.getNext();
        double area=0.0;
        while(current!=head){
            if(current.getValue()!=null){
                area+=current.getValue().getArea();
            }
            current=current.getNext();
        }
        return area;
    }
    public int roomsTotal(){
        Node current=head.getNext();
        int rooms=0;
        while(current!=head){
            if(current.getValue()!=null){
                rooms+=current.getValue().getRoomsCount();
            }
            current=current.getNext();
        }
        return rooms;
    }
    public Space[] getQuarters(){
        Node current= head.getNext();
        Space[] offices= new Space[count];
        int i=0;
        while(current!=head) {
            if (current.getValue() != null) {
                offices[i] = current.getValue();
            }
            current = current.getNext();
            i++;
        }
        return offices;
    }
    public Space findQuarters(int number){
        //Node res =findNode(number);
        //if(res!=null) return res.getValue();
        //return null;
        return findNode(number).getValue();
    }
    public void modificationQuarters(int number, Space office){
        findNode(number).setValue(office);
    }
    public void addOffice(int number){
        addNode(new Node(),number);
    }
    public void addQuarters(int number, Space office){
        addNode(new Node(office),number);
    }
    public void removeQuarters(int number){
        removeNode(number);
    }
    public Space getBestSpace(){
        Space result = null;
        if(head.getNext()!=head){
            Node current = head.getNext();
            result=current.getValue();
            current=current.getNext();
            while(current!=head){
                if(current.getValue()!=null){
                    if(current.getValue().getArea()>result.getArea()){
                        result=current.getValue();
                    }
                }
                current=current.getNext();
            }
        }
        return result;
    }

    private Node findNode(int number){
        Node current=head.getNext();
        int k=0;
        while(current.getNext()!=head && k<number){
            current=current.getNext();
            k++;
        }
        if(k!=number || count==0) throw new SpaceIndexOutOfBoundsException();
        return current;
    }
    private void addNode(Node node, int number){
        Node current;
        Node next;
        if(number==0){
            current=head;
            next=head.getNext();
        }
        else {
            current = findNode(number - 1);
            next = current.getNext();
        }
        current.setNext(node);
        node.setNext(next);
        count++;
    }
    private void removeNode(int number) {
        if(number==0){
            Node current = findNode(0);
             head.setNext(current.getNext());
             count--;
        }
        else {
            Node current = findNode(number - 1);
            Node next;
            if (current != null && current.getNext() != head) {
                next = current.getNext().getNext();
                current.setNext(next);
                count--;
            }
        }
    }


}
class Node{
    private Node next;
    private Space value;

    public void setNext(Node next) {
        this.next = next;
    }
    public Node getNext() {

        return next;
    }
    public Space getValue() {
        return value;
    }
    public void setValue(Space value) {
        this.value = value;
    }

    public Node(){ this(null,null);}
    public Node(Space office){
        this(office,null);
    }
    public Node(Space office,Node next){
        this.next=next;
        value=office;
    }
}