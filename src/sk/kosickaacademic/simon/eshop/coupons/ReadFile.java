package sk.kosickaacademic.simon.eshop.coupons;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    public static ArrayList<Coupon> getCoupons(){
        ArrayList<Coupon> list = new ArrayList<>();

        try{
            File file = new File("resources/coupons.txt");
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] temp = line.split(" ");
                Coupon coupon = new Coupon(temp[0], Integer.parseInt(temp[1]));
                list.add(coupon);
            }
            sc.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return list;
    }

    public static void updateCoupons(ArrayList<Coupon> list){
        try{
            FileWriter fw = new FileWriter("resources/coupons.txt");
            for(Coupon temp:list)
                fw.write(temp.getCode() +" " +temp.getValue() +"\n");
            fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
