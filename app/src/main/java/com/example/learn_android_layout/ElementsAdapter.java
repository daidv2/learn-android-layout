package com.example.learn_android_layout;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Adapter cho danh sách phần tử Text dùng trong RecycleView
 * https://developer.android.com/develop/ui/views/layout/recyclerview
 */
public class ElementsAdapter extends RecyclerView.Adapter<ElementsAdapter.ElementViewHolder> {

    String[] arWords = new String[]{
            "Phần Tử 1", "Phần Tử 2",
            "Phần Tử 3", "Phần Tử 4",
            "Phần Tử 5", "Phần Tử 6",
            "Phần Tử 7", "Phần Tử 8", "Phần Tử 9", "Phần Tử 10",
            "Phần Tử 11", "Phần Tử 12", "Phần Tử 13", "Phần Tử 14",
            "Phần Tử 15", "Phần Tử 16", "Phần Tử 17",
            "Phần Tử 18", "Phần Tử 19", "Phần Tử 20", "Phần Tử 21",
            "Phần Tử 22", "Phần Tử 23", "Phần Tử 24", "Phần Tử 25"};

    /**
     * Lớp biểu diễn Holder trong RecycleView
     */
    public static class ElementViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ElementViewHolder(TextView itemView) {
            super(itemView);
            textView = itemView;
        }

        public TextView getTextView() {
            return textView;
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ElementViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        TextView v = (TextView) LayoutInflater.from(viewGroup.getContext())
                .inflate(android.R.layout.simple_list_item_1, viewGroup, false);
        return new ElementViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ElementViewHolder viewHolder, int position) {
        ((ElementViewHolder) viewHolder).getTextView().setText(arWords[position]);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return arWords.length;
    }
}
