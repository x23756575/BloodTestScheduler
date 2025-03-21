/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestscheduler;

import bloodtestscheduler.dll.DLL;
import bloodtestscheduler.dll.Node;
import bloodtestscheduler.queue.Queue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author samor
 */
public class PriorityQueue implements PriorityQueueInterface{  
    private ArrayList<Patients> prioQueue = new ArrayList<>();     
    
    private Priority priority;
    
    File f = new File("patients.dat");
    File missed = new File("missed.dat");
    private DLL prioQueueDLL;
    private Queue queue;
    LocalDateTime currentTime;//added this method to check if patient has missed an appointment

    public PriorityQueue() {
        this.prioQueueDLL = new DLL();//this is a empty dll, i added this because i was getting getting prioQueueDLL is null in other methods
    }      
    public void updateDLL(DLL dll) {//to update the double linked list to most recent values so i added this method to update. i call in this method BloodJFrame class
        this.prioQueueDLL = dll;
    }  
    public void updateQueue(Queue queue){//to update the queue so content is recent
        this.queue = queue;
    }
    public void save() {
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
            oos.writeObject(prioQueueDLL);
        System.out.println(prioQueueDLL.getHead());//this is a debug to check if the dll is being saved properly
        System.out.println(prioQueueDLL.size());//..
        } catch(IOException e){
        System.out.println(e);
        }
    } 
    public void noShowSave() {
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(missed))) {
            oos.writeObject(queue);
            System.out.println("Queue Saved");
        } catch(IOException e){
        System.out.println(e);
        }
    } 
    public void checkShownUp(){
        currentTime = LocalDateTime.now();  ///gets current time
    if (prioQueueDLL == null) {
        System.out.println("the dll is null");
        return;
    }        
        Node currentNode = prioQueueDLL.getHead();
        while(currentNode != null){
            Patients patient = currentNode.getElement();
            
            if(currentTime.isAfter(patient.getTime().plusMinutes(15))){//i added this to check if user hasnt shownup for there appointment with 15 minutes leeway
                
                patient.setShownUp(false);//this changes the shownUp boolean value to false because the user hasnt show up               
                prioQueueDLL.remove(patient);//removes from dll
                queue.enqueue(patient);//add patient to queue

            }
            currentNode = currentNode.getNext();
        }
        
              
        noShowSave();
    }
    
    

    @Override
    public void enqueue(String name, String details, int age, Priority priority, boolean shownUp,boolean fromWard,LocalDateTime time) {

        if(priority == null){
            priority = Priority.LOW;//added this to test soem issues i was having
        }
        Patients temp = new Patients(name,details,age,priority,shownUp,fromWard,time);        
            
        prioQueueDLL.add(temp);
        save();
    }
    public void next(){
       prioQueueDLL.next();
    }
    public void back(){
       prioQueueDLL.back();
    }
    public String getPatientInfo(){
       return prioQueueDLL.getPatientInfo();
    }
    @Override
    public Object dequeue() {
        return prioQueue.remove(0);
    }

    @Override
    public boolean isEmpty() {
        return prioQueue.isEmpty();
    }

    @Override
    public int size() {
        return prioQueue.size();
    }

@Override
public String printPriorityQueue() {
    StringBuilder ss = new StringBuilder();
    
    Node currentNode = prioQueueDLL.getHead();//gets head of list
    
    while (currentNode != null) {//loops while node isnt nul
        ss.append(currentNode.getElement()).append("\n");//appends to stringbuilder
        currentNode = currentNode.getNext();//gets next node so loop continues
    }
    
    return ss.toString();
}

    
}
