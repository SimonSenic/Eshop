package sk.kosickaacademic.simon.eshop.cart;

import sk.kosickaacademic.simon.eshop.Item;
import sk.kosickaacademic.simon.eshop.utilities.Utilities;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> list;

    public Cart(){
        list = new ArrayList<>();
    }

    public void addItem(Item newItem){
        list.add(newItem);
    }

    public int getItemsCount(){
        return list.size();
    }

    public double getTotalPrice(){
        double total=0;
        for(Item temp:list){
            total=total+temp.getItemPrice();
        }

        return Utilities.formatPrice(total);
    }

    public void printItems(){
        System.out.println("Cart Content: ");
        for(Item temp:list)
            System.out.println(" -  " +temp.toString());
    }

}
