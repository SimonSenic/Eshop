package sk.kosickaacademic.simon.eshop.countable;

import sk.kosickaacademic.simon.eshop.Item;
import sk.kosickaacademic.simon.eshop.utilities.Utilities;

public class Goods extends Item implements Count {
    private int count;

    public Goods(String name, int count, double price){
        super(name, price);
        this.count=count;
    }

    @Override
    public int getCount(){
        return count;
    }

    @Override
    public double getItemPrice(){
        return getPrice()*count;
    }

    @Override
    public String toString(){
        return "Goods: " +getName() +", Price per piece: " +getPrice() +", Count: " +count +", Price: " +Utilities.formatPrice(getItemPrice());
    }

}
