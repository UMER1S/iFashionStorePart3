package se2203b.assignments.adminapp;

import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public class ShoppingCart {

    ArrayList<Pair<Item, SimpleIntegerProperty>> items;

    public ShoppingCart(){
        items = new ArrayList<>();
    }

    public ArrayList<Pair<Item, SimpleIntegerProperty>> getItems() {
        return items;
    }

    public void setItems(ArrayList<Pair<Item, SimpleIntegerProperty>> items) {
        this.items = items;
    }

    public void addItem(Item item){
        //check if item is already in the shopping cart
        for( Pair<Item, SimpleIntegerProperty> pairs : this.items){
            if (pairs.getKey().getItemID() == item.getItemID()){
                //if its in the cart, just increment the count
                pairs.setValue(new SimpleIntegerProperty(pairs.getValue().getValue()+1));
                return; //exit
            }
        }
        //else add it to cart
        items.add(new Pair<Item, SimpleIntegerProperty>(item, new SimpleIntegerProperty(1)));
    }

    public void removeItem(Item item){
        //TODO: not needed yet for this assignment
    }

    public void setItemCount(Item item, int count){
        //TODO: not needed yet for this assignment
    }
}
