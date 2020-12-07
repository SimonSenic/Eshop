package sk.kosickaacademic.simon.eshop;

public abstract class Item {
    String name;
    double price;

    public Item(String name, double price){
        this.name=name;
        this.price=price;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public abstract double getItemPrice();
}
