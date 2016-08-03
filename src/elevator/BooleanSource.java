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
public class BooleanSource {
    private double probability;
    public BooleanSource(double value){
        probability=value;
    }
    
    public boolean requestArrive(){
        return probability > Math.random();
    }
}
