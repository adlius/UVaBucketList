package edu.virginia.yl3ak.uvabucketlist;

import java.util.UUID;

public class Item {
    private UUID listItemId;
    private String listItemTitle;
    private String listItemDescription;
    private boolean listItemCompleted;

    public Item() {
        listItemId = UUID.randomUUID();
    }

    public UUID getId() {
        return listItemId;
    }

    public String getTitle() {
        return listItemTitle;
    }

    public String getDescription() {
        return listItemDescription;
    }

    public boolean isCompleted() {
        return listItemCompleted;
    }

    public void setTitle(String title) {
        listItemTitle = title;
    }

    public void setDescription(String description) {
        listItemDescription = description;
    }

    public void setCompleted(boolean completed) {
        listItemCompleted = completed;
    }

}
