package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Carrello {
    private HashMap<Prodotto, Integer> map;
    public Carrello () {

        map = new HashMap<>();

    }

    public void add (Prodotto p, int qt) {

        if (map.containsKey(p)) {

            int qtC = map.get(p) +  qt;

            map.put(p, qtC);

        } else map.put(p, qt);

    }

    public Set<Map.Entry<Prodotto, Integer>> getEntryset(){
        return map.entrySet();
    }

    public int size(){
        return map.size();
    }

    public void  removeProduct(Prodotto p ){
       map.remove(p);
    }


}
