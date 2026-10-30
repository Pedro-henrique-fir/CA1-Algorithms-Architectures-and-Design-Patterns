/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodstorage;

/**
 *
 * @author mac
 */
public class CircularFoodQueue {
    
    private FoodItem[] items;
    private int limit;
    private int front;
    private int rear;
    private int count;
    
    public CircularFoodQueue(int limit){
    
        this.limit = limit;
        this.items = new FoodItem[limit];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
        
    }
    
    public boolean isEmpty(){
        
        return count == 0;
        
    }

    public boolean isFull(){
        
        return count == limit;
        
    }
    
    
    public int size(){
        
        return count;
        
    }
    
    public boolean enqueue(FoodItem item){
        
        if (isFull()){
      
            return false;
            
        } else {
        
            rear = (rear + 1) % limit;
            items[rear] = item;
            count++;

            return true;
        
        }
    }
    
    public FoodItem dequeue() {
        if (isEmpty()){
            return null;
        }
        
        FoodItem item = items[front];
        items[front] = null;
        front = (front + 1) % limit;
        count = count - 1;
        return item;
        
    }
    
    public FoodItem peek() {

        if (isEmpty()) {
            return null;
        }

        return items[front];
    }
    
    
    public void displayAll() {
       
        if (isEmpty()) {
            System.out.println("Storage is empty");
            return;
        }

        System.out.println("\n===== Stored Food Items =====");

        for (int i = 0; i < count; i++) {

            int index = (front + i) % limit;

            System.out.println((i + 1) + " - " + items[index]);

        }
    }
   
    
    public FoodItem[] search(FoodType type) {
        
        FoodItem[] results = new FoodItem[count];
        int found = 0;
        
        for (int i = 0; i < count; i++) {

            int index = (front + i) % limit;

            if (items[index].getType() == type) {
                results[found] = items[index];
                found = found + 1;
                
            }

        }
        
        return results;
    }
   
   
}
