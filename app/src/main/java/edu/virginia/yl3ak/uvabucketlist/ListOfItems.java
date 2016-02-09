package edu.virginia.yl3ak.uvabucketlist;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ListOfItems {
    private static ListOfItems sList;
    private List<Item> list;

    public static ListOfItems get(Context context) {
        if (sList == null) {
            sList = new ListOfItems(context);
        }
        return sList;
    }

    private ListOfItems(Context context){
        list = new ArrayList<Item>();
        for (int i = 0; i < 20; i++) {
            Item item = new Item();
            item.setTitle("Item No." + i);
            item.setCompleted(i%2 == 0);
            list.add(item);
        }
    }

    public List<Item> getList() {
        return list;
    }

    public Item getItem(UUID id) {
        for (Item item : list){
            if (item.getId().equals(id)){
                return item;
            }
        }
        return null;
    }

}
