package com.voltsoft.dev.lecture;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// [주의] 왜 굳이 어렵게 뷰홀더를 쓰나 ? 이유는 'findViewById' 를 적게 호출 하기 위해서 !
// 처음 생성되는 아이템뷰에서 findViewById 로 써야할 뷰(예: 이름뷰,성별뷰,썸네일뷰)를 가져와서 멤버변수롤 붙잡아놓고 있는다
// 필요할때마다 'findViewById' 로 찾아오는 것 이 아니라 , 붙잡아놓고 있던 멤버변수를 쓴다.
// 이 내용은 한번에 이해가 안될 수 있음. 로그로 실제 동작을 찍어보면서 눈으로 보고 확인하면서
// 스크롤뷰와 이런게 다른거구나 , 아 이렇게 동작이 되는거 구나 라는 식으로 이해 해야합니다
public class FriendViewHolder extends RecyclerView.ViewHolder {

    public ImageView    animalImageView;
    public TextView     nameView;
    public TextView     genderView;

    public FriendViewHolder(@NonNull View itemView) {
        super(itemView);

        animalImageView = itemView.findViewById(R.id.imageView);
        nameView = itemView.findViewById(R.id.nameView);
        genderView = itemView.findViewById(R.id.genderView);
    }
}
