package com.example.controlebb;

import java.io.Serializable;

public abstract class Manager implements Serializable {
    String name;
    String ID;
    float Hours;

    public Manager(String name, String ID, float hours) {
        this.name = name;
        this.ID = ID;
        Hours = hours;
    }
    abstract float calculCout();


}
class Senior extends Manager{
    public Senior(String name, String ID, float hours) {
        super(name, ID, hours);
    }

    float calculCout(){
        if (this.Hours>2000) return 2500*2000+(this.Hours-2000)*3500;
        else return this.Hours*2500;

    }
        }
class Junior extends Manager{
    public Junior(String name, String ID, float hours) {
        super(name, ID, hours);
    }

    float calculCout(){
        if (this.Hours>2500) return 2500*2000+(this.Hours-2500)*3000;
        else return this.Hours*2000;

    }
}
