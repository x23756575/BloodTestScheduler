/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bloodtestscheduler;

/**
 *
 * @author samor
 */
public interface PriorityQueueInterface {
    
    public void enqueue(Object element,Priority priority);
    public Object dequeue();        
    public boolean isEmpty();
    public int size();   
    public String printPriorityQueue();    
    
}
