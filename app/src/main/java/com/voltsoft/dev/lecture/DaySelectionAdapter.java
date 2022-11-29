package com.voltsoft.dev.lecture;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.voltsoft.dev.lecture.model.DaySelection;

import java.util.ArrayList;
import java.util.Locale;

public class DaySelectionAdapter extends RecyclerView.Adapter<DaySelectionViewHolder> {

    public final Context context;

    DaySelectionAdapter(Context c) {
        this.context = c;
    }

    public ArrayList<DaySelection> itemList = new ArrayList<>();

    @NonNull
    @Override
    public DaySelectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DaySelectionViewHolder(inflateView(parent,R.layout.view_item_dayselection));
    }

    @Override
    public void onBindViewHolder(@NonNull DaySelectionViewHolder holder, int position) {
        DaySelection daySelection = itemList.get(position);

        Glide.with(context).load(daySelection.WordThumnail).centerCrop().into(holder.imageView);

        holder.numberView.setText(String.format(Locale.ENGLISH, "%d", daySelection.DaySelection));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    private View inflateView(ViewGroup parent, int resource) {
        return LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
    }
}
