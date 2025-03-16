/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package bloodtestscheduler;

import java.io.Serializable;

/**
 *
 * @author samor
 */
//https://ioflood.com/blog/java-enum-with-values/#:~:text=TL%3BDR%3A%20How%20Do%20I,SPRING%2C%20SUMMER%2C%20FALL%7D%20.
public enum Priority implements Serializable {
    HIGH(1),
    MEDIUM(2),
    LOW(3);// i created this enum class to assign priority to numbers. this will make it easier later on to check if priorities are more important or less important because are assigned values(1,2,3)
    //this means i can get the priority of an object from by getvalue() method.
    private int value;
    
    Priority(int value){    
      this.value = value;
    }
    public int getValue(){
        return value;
    }
    
}
