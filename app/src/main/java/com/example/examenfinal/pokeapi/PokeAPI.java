package com.example.examenfinal.pokeapi;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.example.examenfinal.models.*;

public class PokeAPI {
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private static PokeAPIService service = retrofit.create(PokeAPIService.class);

    public static void getMoveList(MutableLiveData<List<MoveListItem>> moveList){
        Call<MoveList> pokeCall = service.getMoveList(844, 0);
        pokeCall.enqueue(new Callback<MoveList>() {
            @Override
            public void onResponse(@NonNull Call<MoveList> call, @NonNull Response<MoveList> response) {
                if (response.isSuccessful()) {
                    MoveList list = response.body();
                    if (list != null) {
                        moveList.setValue(list.getResults());
                    }

                } else {
                    Log.e("QWERTY", " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(@NonNull Call<MoveList> call, @NonNull Throwable t) {
                Log.e("QWERTY", " onFailure: " + t.getMessage());
            }
        });
    }

    public static void getMove(String name, MutableLiveData<Move> move) {
        Call<Move> pokeCall = service.getMoveById(name);
        pokeCall.enqueue(new Callback<Move>() {
            @Override
            public void onResponse(@NonNull Call<Move> call, @NonNull Response<Move> response) {
                if (response.isSuccessful()) {
                    Move p = response.body();
                    if (p != null) {
                        move.setValue(p);
                    }
                } else {
                    Log.e("QWERTY", " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Move> call, @NonNull Throwable t) {
                Log.e("QWERTY", " onFailure: " + t.getMessage());
            }
        });
    }

    public static void getItemList(MutableLiveData<List<ItemListItem>> itemList) {
        service.getItemList().enqueue(new Callback<ItemList>() {
            @Override
            public void onResponse(Call<ItemList> call, Response<ItemList> response) {
                if (response.isSuccessful()) {
                    ItemList list = response.body();
                    if (list != null) {
                        itemList.setValue(list.getResults());
                    }
                } else {
                    Log.e("API_ERROR", "Error getting item list: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ItemList> call, Throwable t) {
                Log.e("API_ERROR", "Error getting item list", t);
            }
        });
    }

    public static void getItem(String name, MutableLiveData<Item> item) {
        service.getItem(name).enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                if (response.isSuccessful()) {
                    item.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                Log.e("API_ERROR", "Error getting item", t);
            }
        });
    }
}