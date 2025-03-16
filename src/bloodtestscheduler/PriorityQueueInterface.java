/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bloodtestscheduler;

import java.time.LocalDateTime;

/**
 *
 * @author samor
 */
public interface PriorityQueueInterface {
    
    public void enqueue(String name, String details, int age, Priority priority, boolean shownUp,boolean fromWard,LocalDateTime time);
    public Object dequeue();        
    public boolean isEmpty();
    public int size();   
    public String printPriorityQueue();    
    
}
