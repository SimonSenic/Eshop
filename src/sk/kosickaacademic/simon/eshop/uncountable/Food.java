package sk.kosickaacademic.simon.eshop.uncountable;

import sk.kosickaacademic.simon.eshop.Item;
import sk.kosickaacademic.simon.eshop.utilities.Utilities;

public class Food extends Item implements Weight {
    private double weight;

    public Food(String name, double weight, double price){
        super(name, price);
        this.weight = weight;
    }

    @Override
    public void setWeight(double w) {
        this.weight=w;
    }

    @Override
    public double getWeight(){
        return weight;
    }

    @Override
    public double getItemPrice(){
        return weight*getPrice();
    }

    @Override
    public String toString(){
        return "Food: " +getName() +", Price per kg: " +getPrice() +", Weight: " +weight +", Price: " + Utilities.formatPrice(getItemPrice());
    }

}
