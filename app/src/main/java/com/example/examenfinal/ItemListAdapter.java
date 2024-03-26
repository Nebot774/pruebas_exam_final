package com.example.examenfinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenfinal.R;
import com.example.examenfinal.models.ItemListItem;

import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {
    private List<ItemListItem> items;
    private ItemsViewModel itemsViewModel;
    private NavController navController;

    public ItemListAdapter(ItemsViewModel itemsViewModel, NavController navController) {
        this.itemsViewModel = itemsViewModel;
        this.navController = navController;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_item_list, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemListItem item = items.get(position);
        holder.itemNameTextView.setText(item.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemsViewModel.selectItem(item);
                navController.navigate(R.id.action_itemListRecyclerFragment_to_itemDetailFragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    public void setItems(List<ItemListItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView itemNameTextView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemNameTextView = itemView.findViewById(R.id.item_name_text_view);
        }
    }
}
