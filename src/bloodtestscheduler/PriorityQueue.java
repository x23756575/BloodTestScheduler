/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestscheduler;

import java.util.ArrayList;

/**
 *
 * @author samor
 */
public class PriorityQueue implements PriorityQueueInterface{
    
    private ArrayList<PriorityEl> prioQueue = new ArrayList<>();
    private Priority priority;
    
    private int findInsertPos(Priority priority){
        PriorityEl temp;//to hold an element temporarily
        
        int currPosition = 0; 
        
        for (currPosition = 0; currPosition < prioQueue.size(); currPosition++) {
            temp = prioQueue.get(currPosition); //gets element of curr position
            if(temp.getPriority().getValue()< priority.getValue()){//this checks if temp priority value is lower therefore a higher priority
                //and it breaks and return the position so it can be used in enqueue to sort it correctly
                break;
            }  
        }
        return currPosition;
    }
    @Override
    public void enqueue(Object element,Priority priority) {
        PriorityEl temp = new PriorityEl(element, priority);
        
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
    public String printPriorityQueue() {
        
    }
    
}
