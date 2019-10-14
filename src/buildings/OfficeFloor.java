package buildings;

import java.util.Objects;

public class OfficeFloor {
    private Node<Office> head;

    private Node<Office> getNode(int index){
        Node<Office> currentNode = head;
        int currentIndex = 0;
        do {
            if (currentIndex == index) break;
            currentNode = currentNode.next;
        } while (!Objects.isNull(currentNode.value));
        return currentNode;
    }

    private void addNode(int index, Node<Office> node){
        Node<Office> previousNode = getNode(index-1);
        Node<Office> nextNode = previousNode.next;
        previousNode.next = node;
        node.next = nextNode;
    }

    private void removeNode(int index){
        Node<Office> previousNode = getNode(index-1);
        Node<Office> nextNode = previousNode.next.next;
        previousNode.next = nextNode;
    }

    OfficeFloor(int officesQuantity){
        Node<Office> currentNode = new Node<Office>();
        head.next = currentNode;
        for (int i = 2; i < officesQuantity; i++){
            Node<Office> nextNode = new Node<>();
            currentNode.next = nextNode;
            currentNode = nextNode;
        }
        currentNode.next = head;
    }

    OfficeFloor(Office[] offices){
        this(offices.length);
        Node<Office> currentNode = head.next;
        for (int i = 0; i < offices.length; i++){
            currentNode.value = offices[i];
            currentNode = currentNode.next;
        }
    }

    public int getOfficesQuantity(){
        int quantity = 0;
        Node<Office> currentNode = head.next;
            while (!Objects.isNull(currentNode.value)) {
                quantity++;
                currentNode = currentNode.next;
            }
        return quantity;
    }

    public int getArea(){
        int area = 0;
        Node<Office> currentNode = head.next;
        while (!Objects.isNull(currentNode.value)) {
            area+= currentNode.value.getArea();
            currentNode = currentNode.next;
        }
        return area;
    }

    public int getFlats(){
        int flats = 0;
        Node<Office> currentNode = head.next;
        while (!Objects.isNull(currentNode.value)) {
            flats+=currentNode.value.getRoomsQuantity();
            currentNode = currentNode.next;
        }
        return flats;
    }

    public Office[] getOffices(){
        int size = getOfficesQuantity();
        Node<Office> currentNode = head.next;
        Office[] offices = new Office[size];
        for(int i = 0; i< size; i++){
            offices[i] = currentNode.value;
            currentNode = currentNode.next;
        }
        return offices;
    }

    public Office getOffice(int index){
        Office office = null;
        Node<Office> currentNode = head.next;
        int currentIndex = 0;
        for (int i = 0; i < getOfficesQuantity(); i++){
            if(i == currentIndex)office = currentNode.value;
            currentNode = currentNode.next;
        }
        return office;
    }

    public void setOffice(int index, Office office){
        Office currentOffice = getOffice(index);
        currentOffice = office;
    }

    public void addOffice(int index){
        Node<Office> currentNode = head, nextNode, previousNode;
        for (int i = 0; i < getOfficesQuantity(); i++){
            if(i == index - 1){
                previousNode = currentNode;
                nextNode = currentNode.next;
                currentNode = new Node<>();
                previousNode.next = currentNode;
                currentNode.next = nextNode;
            }
            currentNode = currentNode.next;
        }
    }

    public void removeOffice(int index){
        Node<Office> currentNode = head, nextNode, previousNode;
        for (int i = 0; i < getOfficesQuantity(); i++){
            if(i == index - 1){
                previousNode = currentNode;
                nextNode = currentNode.next.next;
                previousNode.next=nextNode;
            }
            currentNode = currentNode.next;
        }
    }

    public Office getBestSpace(){
        Office office = new Office();
        Node<Office> currentNode = head.next;
        while (!Objects.isNull(currentNode.value)) {
            if(currentNode.value.getArea() > office.getArea()){
                office = currentNode.value;
            }
            currentNode = currentNode.next;
        }
        return office;
    }
}

