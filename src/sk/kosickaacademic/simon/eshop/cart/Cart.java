package sk.kosickaacademic.simon.eshop.cart;

import sk.kosickaacademic.simon.eshop.Item;
import sk.kosickaacademic.simon.eshop.countable.Count;
import sk.kosickaacademic.simon.eshop.services.Service;
import sk.kosickaacademic.simon.eshop.uncountable.Weight;
import sk.kosickaacademic.simon.eshop.utilities.Utilities;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> list;

    public Cart(){
        list = new ArrayList<>();
    }

    public void addItem(Item newItem){
        if(newItem instanceof Count && ((Count)newItem).getCount()>0)
            list.add(newItem);
        if(newItem instanceof Weight && ((Weight)newItem).getWeight()>0){
            boolean IsAlreadyInCard = false;
            for(Item temp:list)
                if(temp.getName().equals(newItem.getName()) && temp.getPrice()==newItem.getPrice()){
                    ((Weight)temp).setWeight(((Weight)temp).getWeight() + ((Weight)newItem).getWeight());
                    IsAlreadyInCard = true; break;
                }
            if(IsAlreadyInCard==false) list.add(newItem);
        }
        if(newItem instanceof Service)
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
