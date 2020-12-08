package sk.kosickaacademic.simon.eshop;

import sk.kosickaacademic.simon.eshop.cart.Cart;
import sk.kosickaacademic.simon.eshop.countable.Goods;
import sk.kosickaacademic.simon.eshop.coupons.Coupon;
import sk.kosickaacademic.simon.eshop.coupons.ReadFile;
import sk.kosickaacademic.simon.eshop.services.Delivery;
import sk.kosickaacademic.simon.eshop.uncountable.Food;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Item lamp = new Goods("Lamp", 1, 0.83);
        Item bananas = new Food("Banana", 3, 0.35);
        Item apples = new Food("Apple", 2, 0.28);
        Item delivery = new Delivery(3.49);

        Cart cart = new Cart();
        cart.addItem(lamp);
        cart.addItem(bananas);
        cart.addItem(apples);
        cart.addItem(bananas);
        cart.addItem(apples);
        cart.addItem(apples);
        cart.addItem(delivery);

        cart.printItems();
        System.out.println();
        double totalPrice = cart.getTotalPrice();
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you have any discount coupon? (Y/N)");
        String a = sc.nextLine().toLowerCase(); String coupon;
        if(a.charAt(0)=='y'){
            System.out.println("Enter coupon code: ");
            coupon = sc.nextLine();
            ArrayList<Coupon> list = ReadFile.getCoupons();
            for(Coupon temp:list){
                if(temp.getCode().equals(coupon)){
                    System.out.println("Coupon is valid. ");
                    totalPrice=totalPrice*(1-(double)temp.getValue()/100);
                    list.remove(temp); break;
                }
                if(temp==list.get(list.size()-1) && !temp.equals(coupon)) System.out.println("Coupon is invalid. ");
            }
            ReadFile.updateCoupons(list);
        }
        System.out.println("Total price: " +totalPrice);
    }

}
