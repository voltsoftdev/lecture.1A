package com.voltsoft.dev.lecture;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LionViewHolder extends RecyclerView.ViewHolder {

    public ImageView    animalImageView;
    public TextView     nameView;
    public TextView     genderView;
    public TextView     gradeView;

    public LionViewHolder(@NonNull View itemView) {
        super(itemView);

        animalImageView = itemView.findViewById(R.id.imageView);
        nameView = itemView.findViewById(R.id.nameView);
        genderView = itemView.findViewById(R.id.genderView);
        gradeView = itemView.findViewById(R.id.gradeView);
    }
}
