/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bloodtestscheduler.queue;

import bloodtestscheduler.Patients;

/**
 *
 * @author samor
 */
public interface QueueInterface {
    
    public int size();
    public boolean isEmpty();
    public void enqueue(Patients patient);
    public Patients dequeue();  
}
