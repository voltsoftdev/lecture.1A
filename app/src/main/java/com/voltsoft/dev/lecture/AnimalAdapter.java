package com.voltsoft.dev.lecture;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.voltsoft.dev.lecture.model.Animal;
import com.voltsoft.dev.lecture.model.Lion;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int LION = 100;
    private final int FRIEND = 200;

    public ArrayList<Animal> itemList = new ArrayList<>();

    // (1) 아이템 '뷰' 홀더를 생성하는 곳
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.d("woozie", "++ 아이템뷰홀더가 생성됨 ! viewType:" + viewType);

        if (viewType == LION) {
            View itemView = inflateView(parent, R.layout.view_item_lion);
            return new LionViewHolder(itemView);
        }
        else
        {
            View itemView = inflateView(parent, R.layout.view_item_friend);
            return new FriendViewHolder(itemView);
        }
    }
    // (2) 아이템 '뷰'에 정보를 입히는(bind) 곳
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        int viewType = getItemViewType(position);
        if (viewType == LION) {
            Lion lion = (Lion) this.itemList.get(position);

            LionViewHolder lionViewHolder = (LionViewHolder) holder;

            ImageView thumbnailView = lionViewHolder.animalImageView;
            Glide.with(holder.itemView.getContext()).load(lion.thumbnail).into(thumbnailView);
        }
        else
        {

        }
    }
    // (3) 리스트뷰(리싸이클러뷰)의 아이템을 몇개를 보여줄 것 인지 정하는 곳
    @Override
    public int getItemCount() {
        return itemList.size();
    }
    // (4) 몇번째(position) 마다 어떤 아이템뷰를 보여줄지 정하는 곳
    @Override
    public int getItemViewType(int position) {
        Log.d("woozie", "++ 몇번째(position) 마다 어떤 아이템뷰를 보여줄지 정하는 곳 position:" + position);

        // return super.getItemViewType(position);
        Animal animal = itemList.get(position);

        if (animal instanceof Lion) {
            return LION;
        }
        else
        {
            return FRIEND;
        }
    }

    private View inflateView(ViewGroup parent, int resource) {
        return LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
    }
}
