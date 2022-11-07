package com.voltsoft.dev.lecture;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnimalAdapter extends RecyclerView.Adapter<LionViewHolder> {

    @NonNull
    @Override
    public LionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflateView(parent,R.layout.view_item_lion);
        return new LionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LionViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    private View inflateView(ViewGroup parent, int resource) {
        return LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
    }
}
