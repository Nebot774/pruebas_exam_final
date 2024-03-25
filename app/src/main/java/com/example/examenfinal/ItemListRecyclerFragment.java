package com.example.examenfinal;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenfinal.ItemListAdapter;

public class ItemListRecyclerFragment extends Fragment {
    private ItemsViewModel itemsViewModel;
    private RecyclerView recyclerView;
    private ItemListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ItemListAdapter();
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        itemsViewModel = new ViewModelProvider(requireActivity()).get(ItemsViewModel.class);
        itemsViewModel.getItemList().observe(getViewLifecycleOwner(), items -> {
            adapter.setItems(items);
            adapter.notifyDataSetChanged();
        });
    }
}
