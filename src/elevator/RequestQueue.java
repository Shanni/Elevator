/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

import java.util.LinkedList;

/**
 *
 * @author shanliu
 */
public class RequestQueue {
    private LinkedList<Request> q;
    public RequestQueue(){
        q = new LinkedList<>();
    }
    
    public boolean enqueue(Request r){
        return q.offer(r);
    }
    
    public Request dequeue(){
        return q.poll();
    }
    
    public int size(){
        return q.size();
    }
    
    public boolean isEmpty(){
        return q.isEmpty();
    }
}
