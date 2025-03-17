/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bloodtestscheduler.dll;

import bloodtestscheduler.Patients;

public interface LinearListInterface {
    
    public boolean isEmpty();
    public int size();
    public void remove(Patients patient);
    public void add(Patients patient);
    public void printList();

    
}
