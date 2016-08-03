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
public class Elevator {

    private int currentFloor;
    private int elevatorState;
    private Request request;
    
    final int IDLE=1;
    final int TO_SOURCE=2;
    final int TO_DESTINASTION=3;
    
    public Elevator(){
        request=null;
        elevatorState=IDLE;
        currentFloor=1;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getElevatorState() {
        return elevatorState;
    }

    public void setElevatorState(int elevatorState) {
        this.elevatorState = elevatorState;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
    
}
