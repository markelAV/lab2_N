package com.company.buildings;

import com.company.FloorIndexOutOfBoundsException;

public class OfficeBuilding implements Building {
    private DoubleNode head;
    private int count;
    private DoubleNode findNode(int number){
        int k =0;
        DoubleNode res=head.getNext();
        while(res.getNext()!=head && k<number){
            k++;
            res=res.getNext();
        }
        if(k!=number || count==0) throw new FloorIndexOutOfBoundsException();
        return res;
    }
    private void addNode(int number, DoubleNode node) {
        DoubleNode current;
        DoubleNode next;
        if (number == 0) {
            current=head;
            next=head.getNext();
        } else {
            current = findNode(number - 1);
            next = current.getNext();
        }
            node.setNext(next);
            node.setPrev(current);
            current.setNext(node);
            next.setPrev(node);
            count++;
    }
    private void removeNode(int number){
        DoubleNode current;
        DoubleNode next;
        if(number==0){
            findNode(0);
            current=head;
            next=current.getNext().getNext();
        }
        else {
            current = findNode(number - 1);
            next = current.getNext().getNext();
        }
        next.setPrev(current);
        current.setNext(next);
        count--;
    }

    public OfficeBuilding(int countFloor,int[] countsOffice){ //todo нужна ли проверка на countsOffice.length >= countFloot ???
        head = new DoubleNode();
        head.setNext(head);
        head.setPrev(head);
        for(int i=0; i<countFloor;i++){
            addNode(i,new DoubleNode(new OfficeFloor(countsOffice[i])));
        }
    }
    public OfficeBuilding(OfficeFloor[] floors){
        head = new DoubleNode();
        head.setNext(head);
        head.setPrev(head);
        for(int i=0; i<floors.length;i++){
            addNode(i,new DoubleNode(floors[i]));
        }
    }

    public int getCount(){ return count;}
    public int countQuarters(){
        int res =0;
        DoubleNode current =head.getNext();
        while(current!=head){
            if(current.getValue()!=null) {
                res += current.getValue().getCount();
            }
            current=current.getNext();
        }
        return res;
    }
    public double areaTotal(){
        double res =0.0;
        DoubleNode current =head.getNext();
        while(current!=head){
            if(current.getValue()!=null) {
                res += current.getValue().areaTotal();
            }
            current=current.getNext();
        }
        return res;
    }
    public int roomsTotal(){
        int res =0;
        DoubleNode current =head.getNext();
        while(current!=head){
            if(current.getValue()!=null) {
                res += current.getValue().roomsTotal();
            }
            current=current.getNext();
        }
        return res;
    }
    public Floor[] getFloors(){
        Floor[] res = new Floor[count];
        DoubleNode curent = head.getNext();
        int k=0;
        while(curent!=head && k<count){
            res[k]=curent.getValue();
            curent=curent.getNext();
            k++;
        }
        return res;
    }
    public Floor findFloor(int number){
        Floor result=null;
        DoubleNode current =findNode(number);
        if(current!=null){result=current.getValue();}
        return result;
    }
    public void modificationFloor(int number, Floor floor ){
        DoubleNode current = findNode(number);
        if(current!=null){
            current.setValue(floor);
        }
    }
    private DTO findIndexOfOffice(int number){
        DTO dto = new DTO();
        int k=0;
        int fl=0;
        int of =number;
        DoubleNode current=head.getNext();
        while(current!=head && k<number){
            k+=current.getValue().getCount();
            current=current.getNext();
            fl++;

        }
        if(current==head && k<number) return new DTO(-1,-1);
        if(k>number){
            current=current.getPrev();
            k-=current.getValue().getCount();
            of -=k;
            fl--;
        }
        else{
            if(fl<count) {of =0;}
            else {
                fl--;
                of-=k-current.getPrev().getValue().getCount();
            }

        }
        return new DTO(fl,of);
    }
    public Space findQuarters(int number){
        Floor officeFloor =null;
        DTO dto = findIndexOfOffice(number);
        if(dto.getIndexOfFloor()!=-1){
           return findFloor(dto.indexOfFloor).findQuarters(dto.indexOfFlat) ;
        }
        return null;
    }
    public void modificationQuarters(int number, Space office){
        Floor officeFloor =null;
        DTO dto = findIndexOfOffice(number);
        if(dto.getIndexOfFloor()!=-1){
            findFloor(dto.indexOfFloor).modificationQuarters(dto.getIndexOfFlat(),office);
        }
        
    }
    public void addQuarters(int number, Space office){ //todo control add &&?? proverit
        DTO dto = findIndexOfOffice(number);
        if(dto.getIndexOfFloor()!=-1){
            Floor officeFloor = findFloor(dto.getIndexOfFloor());
            officeFloor.addQuarters(dto.getIndexOfFlat(),office);
        }
    }
    public void removeQuarters(int number){
        OfficeFloor officeFloor =null;
        DTO dto = findIndexOfOffice(number);
        if(dto.getIndexOfFloor()!=-1){
            findFloor(dto.getIndexOfFloor()).removeQuarters(dto.getIndexOfFlat());
        }
    }
    public Space getBestSpace(){
        Space res = null;
        if(head.getNext()!=head) {
            res = head.getNext().getValue().getBestSpace();
            DoubleNode current = head.getNext().getNext();
            Space office=null;
            while (current!=head){
                office= current.getValue().getBestSpace();
                if(office.getArea()>res.getArea()){
                    res=office;
                }
                current=current.getNext();
            }
        }
        return res;
    }
    public Space[] SortQuarters(){
        int n = countQuarters();
        Space[] offices = new Space[n];
        Floor[] officeFloors = getFloors();
        int k=0;
        for(int i =0;i<officeFloors.length && k<n;i++){
            Space[] o = officeFloors[i].getQuarters();
            for(int j =0; j<o.length && k<n;j++){
                offices[k]=o[j];
                k++;
            }
        }
        Space temp=null;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(offices[i].getArea()<offices[j].getArea()){
                    temp = offices[i];
                    offices[i]=offices[j];
                    offices[j]=temp;
                }
            }
        }
        return  offices;
    }

    private class DoubleNode {
        private DoubleNode next;
        private DoubleNode prev;
        private Floor value;
        public DoubleNode getPrev() {
            return prev;
        }
        public void setPrev(DoubleNode prev) {
            this.prev = prev;
        }
        public void setNext(DoubleNode next) {
            this.next = next;
        }
        public DoubleNode getNext() {

            return next;
        }
        public Floor getValue() {
            return value;
        }
        public void setValue(Floor value) {
            this.value = value;
        }
        public DoubleNode(){ this(null,null,null);}
        public DoubleNode(Floor office){
            this(office,null,null);
        }
        public DoubleNode(Floor office, DoubleNode next, DoubleNode prev){
            this.next=next;
            this.prev=prev;
            value=office;
        }
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


