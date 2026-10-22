/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodstorage;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author mac
 */
public class FoodItem {
    
    private static DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static DateTimeFormatter dataTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    
    private  FoodType type;
    private  int weightGrams;
    private  LocalDate bestBefore;
    private  LocalDateTime storedAt;
    
    public FoodItem(FoodType type, int weightGrams, LocalDate bestBefore) {
        this.type = type;
        this.weightGrams = weightGrams;
        this.bestBefore = bestBefore;
        this.storedAt = LocalDateTime.now();
        
    }
    
    public FoodType getType() {
        return type;
    }

    public int getWeightGrams() {
        return weightGrams;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public LocalDateTime getStoredAt() {
        return storedAt;
    }
    
    @Override
    public String toString() {
        return type + " | " + weightGrams + "g | best before " + bestBefore.format(dataFormat) + " | placed at " + storedAt.format(dataTimeFormat);
        
    }

    
}
