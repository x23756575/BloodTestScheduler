/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestscheduler;

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
    
    LocalDateTime currentTime;//added this method to check if patient has missed an appointment
    
    private void checkShownUp(){
        currentTime = LocalDateTime.now();  ///gets current time  
        for(int i = 0; i < prioQueue.size();i++){
            
            Patients temp = prioQueue.get(i);
            if(currentTime.isAfter(temp.getTime().plusMinutes(15))){//checks if current time is after the appointments time, if true remove from prio queue and adds to now show list
                prioQueue.remove(temp);
                temp = new Patients(temp.getName(),temp.getDetails(),temp.getAge(),temp.getPriority(),false,temp.getFromWard(),temp.getTime());//this changes the shownUp boolean value to false because the user hasnt show up
                noShow.add(temp);//adds the patient to the noShow arraylist 
            
            }else{
                System.out.println("patient appointment has time to show up");
            }
        }
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
        
        if(index < size()){
            prioQueue.add(temp);
        }else{
            prioQueue.add(index, temp);
        }
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
    public String printPriorityQueue() {//prints priorityqueue
        StringBuilder ss =new StringBuilder();
        
        for(int i = 0; i< prioQueue.size();i++){
            
            ss.append(prioQueue.get(i));
            
        }
          return ss.toString();
        
    }
    
}
