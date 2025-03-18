/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestscheduler.queue;

import bloodtestscheduler.Patients;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author samor
 */
public class Queue implements QueueInterface,Serializable{
   private ArrayList<Patients> queue;
    
    public Queue(){
        queue = new ArrayList<>(); 
    }
    
    @Override
    public int size(){
       return queue.size();
    }
    @Override
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    @Override
    public void enqueue(Patients patient){
        if (queue.size() >= 5) {//always keeps queue at a limit of 5
             queue.remove(0);
        }
        queue.add(patient);
    }
    @Override
    public Patients dequeue(){
        if(!queue.isEmpty()){
            return queue.remove(0);
        }else{
            return null;
        }
    }

    public void recursive(int index,StringBuilder ss){// this method uses recursion to print elements from the queue
        if(index < 0){
            return;//this is a needed base case so the method doesnt lead to an error
        }
        
        ss.append(queue.get(index)).append("\n");
        recursive(index - 1,ss);//this will move the function down the queue each time its called
    }
    
    public String displayQueue(){
        
        StringBuilder ss = new StringBuilder();
        recursive(queue.size() -1,ss);//starts at top of queue
        
        return ss.toString();
   }    
}
