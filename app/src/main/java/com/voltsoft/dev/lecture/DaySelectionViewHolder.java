package com.voltsoft.dev.lecture;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DaySelectionViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView numberView;

    public DaySelectionViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.daySelectionThumbnail);
        numberView = itemView.findViewById(R.id.dayPrefix);
    }
}
