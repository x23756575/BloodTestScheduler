/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bloodtestscheduler.stack;

import bloodtestscheduler.Patients;

/**
 *
 * @author samor
 */
public interface StackInterface {
    
    public void push(Patients patient);
    public Patients pop();      
    public boolean isEmpty();
    public int size();
    public String displayStack();    
}
