/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestscheduler.stack;

import bloodtestscheduler.Patients;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author samor
 */
public class Stack implements StackInterface, Serializable{
   
    private ArrayList<Patients> stack;
    public Stack() {
        stack = new ArrayList<>();    
    }
   
    @Override
    public boolean isEmpty(){
        return stack.isEmpty();
       
        
    }
    
    public void push(Patients patient){
        if(stack.size() < 5){//max size of stack is 5
            stack.add(patient);
        }else{
            System.out.println("stack is full");
        }
    }
    
    @Override
    public Patients pop(){
        if (!(stack.isEmpty())){
            return stack.remove(stack.size() - 1);
        }else{
            return null;
        }
    }
    
    @Override
    public int size(){
        return stack.size();
    }
    public void recursive(int index,StringBuilder ss){// this method uses recursion to print elements from the stack
        if(index < 0){
            return;//this is a needed base case so the method doesnt lead to an error
        }
        ss.append(stack.get(index)).append("\n");
        recursive(index - 1,ss);//this will move the function down the stack each time its called
     
    }
    @Override
    
    public String displayStack(){
        StringBuilder ss = new StringBuilder();
        
        recursive(stack.size() -1,ss);//starts at top of stack 
        return ss.toString();
    }

    
}
    

