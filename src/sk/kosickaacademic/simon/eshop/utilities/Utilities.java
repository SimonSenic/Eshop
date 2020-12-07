package sk.kosickaacademic.simon.eshop.utilities;

public class Utilities {
    public static double formatPrice(double price){
        double result=(double)Math.round(price*100)/100;
        return result;
    }
}
