package com.komangkrisnanda.friendfinders.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.komangkrisnanda.friendfinders.R;
import com.komangkrisnanda.friendfinders.models.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by root on 18/11/17.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private Context mContext;
    private List<User> userList;
    private UserClickListener mUserClickListener;

    public UserAdapter(Context mContext, List<User> userList) {
        this.mContext = mContext;
        this.userList = userList;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.item_users, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, final int position) {
        User user = userList.get(position);
        holder.tvUserName.setText(user.getName());
        Glide.with(mContext)
                .load(user.getImageUrl())
                .into(holder.ivUserAvatar);

        holder.btnDetails.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(mUserClickListener != null){
                    mUserClickListener.onUserItemClicked(userList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void setUsers(List<User> users){
        userList.addAll(users);
        notifyDataSetChanged();
    }

    public void setItemClickListener(UserClickListener clickListener){
        if(clickListener != null){
            mUserClickListener = clickListener;
        }
    }
    public static class UserViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.ivUserAvatar) ImageView ivUserAvatar;
        @BindView(R.id.tvUserName) TextView tvUserName;
        @BindView(R.id.btnDetails) Button btnDetails;

        public UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
