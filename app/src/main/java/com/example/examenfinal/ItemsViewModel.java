package com.example.examenfinal;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.examenfinal.models.Item;
import com.example.examenfinal.models.ItemListItem;
import com.example.examenfinal.pokeapi.PokeAPI;

import java.util.List;

public class ItemsViewModel extends ViewModel {
    private final MutableLiveData<List<ItemListItem>> itemList = new MutableLiveData<>();
    private final MutableLiveData<Item> selectedItem = new MutableLiveData<>();

    public ItemsViewModel() {
        PokeAPI.getItemList(itemList);
    }

    public MutableLiveData<List<ItemListItem>> getItemList() {
        return itemList;
    }

    public void selectItem(ItemListItem itemListItem) {
        PokeAPI.getItem(itemListItem.getName(), selectedItem);
    }

    public MutableLiveData<Item> getSelectedItem() {
        return selectedItem;
    }
}
