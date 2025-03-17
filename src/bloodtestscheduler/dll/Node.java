/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestscheduler.dll;

import bloodtestscheduler.Patients;
import java.io.Serializable;
        
public class Node implements Serializable{
    private Patients element;
    private Node next;  
    private Node prev; 

    public Node(Patients element, Node prev, Node next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }
    public Patients getElement() {
        return element;
    }
        
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
    
}

