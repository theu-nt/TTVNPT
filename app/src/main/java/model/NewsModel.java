package model;

import java.util.List;

public class NewsModel {

    private String status;
    private List<item> items;

    public String getStatus() {
        return status;
    }

    public NewsModel(String status, List<item> items) {
        this.status = status;
        this.items = items;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<item> getItems() {
        return items;
    }

    public void setItems(List<item> items) {
        this.items = items;
    }
}
