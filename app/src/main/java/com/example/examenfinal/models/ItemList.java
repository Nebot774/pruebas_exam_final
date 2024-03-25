package com.example.examenfinal.models;

import java.util.List;

public class ItemList {
    private int count;
    private String next;
    private String previous;
    private List<ItemListItem> results;

    // Constructor vacío
    public ItemList() {
    }

    // Constructor con todos los campos
    public ItemList(int count, String next, String previous, List<ItemListItem> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    // Getters y setters
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<ItemListItem> getResults() {
        return results;
    }

    public void setResults(List<ItemListItem> results) {
        this.results = results;
    }
}

