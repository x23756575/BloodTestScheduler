package bloodtestscheduler.dll;

import bloodtestscheduler.Patients;
import java.io.Serializable;

public class DLL implements LinearListInterface, Serializable {
    private Node head;
    private Node curr;
    private Node last;
    private int size;

    public DLL() {
        head = null;
        last = null;
        curr = head;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }
    public Node getCurr() {
        return curr;
    }

    public void setCurr(Node curr) {
        this.curr = curr;
    }
    public int size() {
        return size;
    }

    public Node getHead(){
        return head;
    }
    @Override
    public void add(Patients patient) {
        Node newNode = new Node(patient, null, null);

        if (head == null) {
            head = newNode;//if head is null, the newnode becomes the first node on the list
            last = newNode;//so it becomes the head and last
            curr = head;
        } else {
            Node currentNode = head;
            
            while (currentNode != null && patient.getPriority().getValue() < currentNode.getElement().getPriority().getValue()) {//keeps looping to find position to insert patient
                currentNode = currentNode.getNext();//this line keeps the traversal continuing as long as the priority is less than the currentnode
            }

            if (currentNode == null) {//this will a patient to the end or the start if the list is empty
                last.setNext(newNode);//sets pointer of lastnode to the new node
                newNode.setPrev(last);//sets prev pointer of new node to last creating a connection
                last = newNode;//the new node becomes the last node
                
            } else if (currentNode == head) {
                newNode.setNext(head);//newnode points to head
                head.setPrev(newNode);//sets prev to head
                head = newNode;//sets the new head since new node is now at the start of list
            } else {
                Node prevNode = currentNode.getPrev();//this holds a temporary value of the prevous node necessary for this insertioon
                prevNode.setNext(newNode);//sets the previous nodes next pointer to the newnode
                newNode.setPrev(prevNode);//newNode points back to the prevnode like this            prevNode ⇆ newNode
                newNode.setNext(currentNode);//new node next pointer connects to currentnode
                currentNode.setPrev(newNode);//newnode prev pointers points back to new node  prevNode ⇆ newNode ⇆ currentNode.
                //this is what i use to solve dll problems as i can visualise the pointers and where the node is being added in dll
            }
        }

        size++;
        curr = head;
    }
    
public void next() {
    
    if (curr == null) {//null check so curr is never null which will cause issues
        curr = head;  //sets curr to start of list
    }
    
    if (curr != null) {
        if (curr.getNext() != null) {
            curr = curr.getNext(); //sets curr to next node so it can traverse through the list
        } else {
            System.out.println("no node is next");
        }
    } else {
        System.out.println("jildjailwjdalai");
    }

}

public void back() {
    
    if (curr == null) {//null check so curr is never null which will cause issues
        curr = head;  // If curr is null, initialize it to the last node.
    }
    
    if (curr != null) {
        if (curr.getPrev() != null) {
            curr = curr.getPrev(); //sets curr to previous so we can go back through the list
            System.out.println("Moved to the previous node: " + curr.getElement());
        } else {
            System.out.println("no node is behind");
        }
    } else {
        System.out.println("random check");
    }

}


public String getPatientInfo(){//this method gets the element of the curr. i used this with other method like next() back() to print out the patient
    if (curr == null) {
        return "curr is null";
    }
//    @
    try {
        return curr.getElement().toString();
    } catch (NullPointerException e) {
        return "patient data null";
    }
}

        


    @Override
    public void remove(Patients patient) {//takes in a patient object

        Node currentNode = head;
        while(currentNode != null){
            
            if(currentNode.getElement().equals(patient)){//if the element is patient
                
                if(currentNode == head){
                    head = currentNode.getNext(); // Move head to the next node
                    
                    if (head != null) {  // If head is not null, update its prev pointer
                        head.setPrev(null);
                    }                    
                }else if(currentNode == last){//checks if the patient that being removed is at the end of the list
                    
                    Node temp = last.getPrev();// it gets the node before the last element and sets the next pointer of it to null
                    if(temp != null){           // basically disconnecting the last element from the list
                     temp.setNext(null);                       
                    }

                }else{
                    if (currentNode.getPrev() != null) {//if element is not at the head or last
                        currentNode.getPrev().setNext(currentNode.getNext());//get previous node and sets it the node after currentnode
                    }
            
                    if (currentNode.getNext() != null) {
                        currentNode.getNext().setPrev(currentNode.getPrev());//gets the next node after currentNode thats being removed and sets it to the previous node of currentNode
                    }  
                    
                }
                       size--;//decrements after removing one
                       break;
            }
              currentNode = currentNode.getNext(); //moves to the next node
        }
    }
@Override
public void printList(){
    
}
@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    Node currentNode = head;

    while (currentNode != null) {//loops through list
        sb.append(currentNode.getElement().toString()).append("\n");//appends elements to a list
        currentNode = currentNode.getNext();//gets next so loop continues
    }

    return sb.toString();
}


}
