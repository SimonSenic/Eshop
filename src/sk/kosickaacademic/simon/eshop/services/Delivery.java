package sk.kosickaacademic.simon.eshop.services;

import sk.kosickaacademic.simon.eshop.Item;

public class Delivery extends Item implements Service {
    public Delivery(double price) {
        super("delivery", price);
    }

    @Override
    public double getItemPrice() {
        return getPrice();
    }

    @Override
    public String toString(){
        return "Delivery: " +getPrice();
    }
}
