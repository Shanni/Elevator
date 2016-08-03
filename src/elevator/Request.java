/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

/**
 *
 * @author shanliu
 */
public class Request {
    private int sourceFloor;
    private int destinationFloor;
    private int timeEntered;
    
    public Request(int numFloor){
        sourceFloor = (int)(Math.random()*numFloor ) +1;
        destinationFloor = (int)(Math.random()*numFloor ) +1;
    }
    
    public int getSourceFloor() {
        return sourceFloor;
    }

    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public int getTimeEntered() {
        return timeEntered;
    }

    public void setTimeEntered(int timeEntered) {
        this.timeEntered = timeEntered;
    }
    
    public String toString(){
        return String.format("\t < Src: %d Dest: %d  EnterTime: %d>", 
                this.sourceFloor, this.destinationFloor, this.timeEntered);
    }
}
