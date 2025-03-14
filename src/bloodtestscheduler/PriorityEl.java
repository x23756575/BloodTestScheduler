/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestscheduler;

/**
 *
 * @author samor
 */
public class PriorityEl {
    

    private Object element;    
    private Priority priority;
    
    public PriorityEl(Object element,Priority priority){
        this.element = element;
        this.priority = priority;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    @Override
    public String toString() {
        return "Priority " + priority + "\n "+ "element:" + element;
    }    
}
