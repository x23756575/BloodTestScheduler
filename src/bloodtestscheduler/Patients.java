/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestscheduler;

import java.time.LocalDateTime;

/**
 *
 * @author samor
 */
public class Patients {
    
    private String name,details;
    private int age;
    private Priority priority;
    private boolean shownUp;
    private boolean fromWard;
    private LocalDateTime time;

    public Patients(String name, String details, int age, Priority priority, boolean shownUp,boolean fromWard,LocalDateTime time) {
        this.name = name;
        this.details = details;
        this.age = age;
        this.priority = priority;
        this.shownUp = shownUp;
        this.fromWard = fromWard;
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public boolean getShownUp() {
        return shownUp;
    }

    public void setShownUp(boolean shownUp) {
        this.shownUp = shownUp;
    }

    public boolean getFromWard() {
        return fromWard;
    }

    public void setFromWard(boolean fromWard) {
        this.fromWard = fromWard;
    }




    
    

    
}
