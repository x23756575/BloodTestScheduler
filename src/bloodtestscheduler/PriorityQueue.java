/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestscheduler;

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
    private ArrayList<Patients> noShow = new ArrayList<>(); 
    
    private Priority priority;
    
    File f = new File("patients.dat");
    File missed = new File("missed.dat");
    
    LocalDateTime currentTime;//added this method to check if patient has missed an appointment
    public void setPrioQueue(ArrayList<Patients> prioQueue){//made this method so the same copy of the arraylist is transferrable from my bloodjframe class to this class because i was haveing issue prior with one class not having the same arraylist
        this.prioQueue = prioQueue;
    }
    public void setNoShow(ArrayList<Patients> noShow){
        this.noShow = noShow;
    }
    
    public void save() {
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
            oos.writeObject(prioQueue);
            System.out.println("prio Queue Saved");
        } catch(IOException e){
        System.out.println(e);
        }
    } 
    public void noShowSave() {
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(missed))) {
            oos.writeObject(noShow);
            System.out.println("Queue Saved");
        } catch(IOException e){
        System.out.println(e);
        }
    } 
    public void checkShownUp(){
        currentTime = LocalDateTime.now();  ///gets current time  
        for(int i = 0; i < prioQueue.size();i++){
            
            Patients temp = prioQueue.get(i);
            LocalDateTime tempTime = temp.getTime();
            
            if(currentTime.isAfter(temp.getTime().plusMinutes(15))){//checks if current time is after the appointments time, if true remove from prio queue and adds to now show list
                
                System.out.println(currentTime +"|"+ tempTime);
                
                temp.setShownUp(false);//this changes the shownUp boolean value to false because the user hasnt show up               
                prioQueue.remove(temp);
                noShow.add(temp);//adds the patient to the noShow arraylist 

                
            }else{
                System.out.println("patient appointment has time to show up");
            }
        }                
        noShowSave();
    }
    
    
    private int findInsertPos(Priority priority){
        Patients temp;
        
        int currPosition = 0; 
        
        for (currPosition = 0; currPosition < prioQueue.size(); currPosition++) {
            temp = prioQueue.get(currPosition); //gets element of curr position
            if( temp.getPriority() != null &&  temp.getPriority().getValue() > priority.getValue()){//this checks if temp priority value is lower therefore a higher priority
                //and it breaks and return the position so it can be used in enqueue to sort it correctly
                break; //1, 2 ,3 ,4 ,5. insert 3.
            }  
        }
        return currPosition;
    }
    @Override
    public void enqueue(String name, String details, int age, Priority priority, boolean shownUp,boolean fromWard,LocalDateTime time) {

        if(priority == null){
            priority = priority.LOW;//added this to test soem issues i was having
        }
        Patients temp = new Patients(name,details,age,priority,shownUp,fromWard,time);        
            
        
        int index = findInsertPos(priority);
        
        prioQueue.add(index, temp);
        checkShownUp();
      
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
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < prioQueue.size(); i++) {
            sb.append(prioQueue.get(i)).append("\n");
        }
        
        return sb.toString();
    }
    
}
