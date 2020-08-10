package Outsource;

import java.util.ArrayList;
import java.util.Collections;

public class Sosanh implements Comparable<Sosanh> {

    private String id;
    private int price;

    @Override
    public int compareTo(Sosanh s) {  //sap xep theo id (String)
        return this.getId().compareTo(s.getId());
    }
//    su dung no
    Collections.sort(lh);  
    

    
//==========================================================================
    //sap xep theo price (Integer, Double,...), -1:1 =>DESC    1:-1 =>ASC
    public int compare(Sosanh s1, Sosanh s2) {
        if (s1.getPrice() > s2.getPrice()) {
            return -1;
        }
        return 1;
    }

    
//==========================================================================
    //sap xep theo String trong list, 
    ArrayList<String> list = new ArrayList<>();
    Collections.sort(list); //ASC

    Collections.sort(list, new Comparator<String>(){  //DESC
        public int compare(String s1, String s2) {  
                return s2.compareTo(s1);
          }
   });
    
    
    //==========================================================================
    //Sap xep ket hop hai du lieu 
    Collections.sort(tourList, new sortPrice().thenComparing(new sortTitle()));
    
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
