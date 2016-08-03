/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author shanliu
 */
public class Simulator {
//    private static double prob;
//    private static int numFloor;
//    private static int numElevator;
//    private static int len;
    
    public static void simulate(double prob, int numFloor, int numElevator, int len){
//        prob=probability;
//        numFloor=numberFloor;
//        numElevator=numberElevator;
//        len=length;
        
        boolean debug=true;
        
        BooleanSource haveRequest=new BooleanSource(prob);
        RequestQueue queue=new RequestQueue();
        List<Elevator> idleElevators =new ArrayList<>();
        List<Elevator> occupiedElevators=new ArrayList<>();
        
        int totalRequest=0;
        int totalWaitTime=0;
        
        // initialize elevators
        for(int i=0;i<numElevator;i++){
            idleElevators.add(new Elevator());
        }
        
        // elevator starting to run
        for(int time=1;time<=len;time++){
            if(debug){
                System.out.println("Time: "+time);
                for(Elevator e: occupiedElevators){
                    System.out.println("Elevator at floor: "+e.getCurrentFloor()+ " Elevator state: "+ 
                            e.getElevatorState() + 
                        " "+e.getRequest().toString());
                }
    
            }
            //a person come to the evelator
            if(haveRequest.requestArrive()){
                Request r=new Request(numFloor);
                r.setTimeEntered(time);
                queue.enqueue(r);
                totalRequest++;
            }
            
            // operating a elevator
            if(!idleElevators.isEmpty() && !queue.isEmpty()){
                Elevator e=idleElevators.remove(0);
                e.setElevatorState(e.TO_SOURCE);
                e.setRequest(queue.dequeue());
                occupiedElevators.add(e);
            }
            
            for(Elevator e: occupiedElevators){
                if(e.getElevatorState()==e.TO_SOURCE){
                    if(e.getCurrentFloor()==e.getRequest().getSourceFloor()){
                        e.setElevatorState(e.TO_DESTINASTION);
                        totalWaitTime+=time-e.getRequest().getTimeEntered();
                    }
                    else{
                        if(e.getCurrentFloor()<e.getRequest().getSourceFloor()){
                            e.setCurrentFloor(e.getCurrentFloor()+1);
                        }else{
                            e.setCurrentFloor(e.getCurrentFloor()-1);
                        }
                    }
                }
                if(e.getElevatorState()==e.TO_DESTINASTION){
                    if(e.getCurrentFloor()==e.getRequest().getDestinationFloor()){
                        e.setElevatorState(e.IDLE);
                        totalWaitTime+=time-e.getRequest().getTimeEntered();
                        e.setRequest(null);
                        occupiedElevators.remove(e);
                        idleElevators.add(e);
                    }else{
                        if(e.getCurrentFloor()<e.getRequest().getDestinationFloor()){
                            e.setCurrentFloor(e.getCurrentFloor()+1);
                        }else{
                            e.setCurrentFloor(e.getCurrentFloor()-1);
                        }
                    }
                }
            }
            
            if(debug){
                System.out.println("total wait: "+totalWaitTime +" total request:" +totalRequest);
            }
        }
    }
}
