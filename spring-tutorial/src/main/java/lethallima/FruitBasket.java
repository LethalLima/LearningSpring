package lethallima;

import java.util.List;

/**
 * Created by jeffrey.lima on 4/18/2016.
 */
public class FruitBasket {
    private String name;
    private List<String> fruits;

    public FruitBasket(String name, List<String> fruits){
        this.name = name;
        this.fruits = fruits;
    }

//    @Override
//    public String toString() {
//        return "FruitBasket{" +
//                "name='" + name + '\'' +
//                ", fruits=" + fruits +
//                '}';
//    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(name);
        sb.append(" contains:\n");

        for(String fruit: fruits){
            sb.append(fruit);
            sb.append('\n');
        }

        return sb.toString();
    }
}
