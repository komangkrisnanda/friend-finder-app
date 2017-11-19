package com.komangkrisnanda.friendfinders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.komangkrisnanda.friendfinders.models.User;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    private static final String KEY_EXTRA_USERS = "users";
    private static final String TAG = DetailActivity.class.getSimpleName();

    @BindView(R.id.ivUserCircle) ImageView ivUserCircle;
    @BindView(R.id.tvUserUsername) TextView tvUserUsername;
    @BindView(R.id.tvUserFullName) TextView tvUserFullName;
    @BindView(R.id.tvUserEmail) TextView tvUserEmail;
    @BindView(R.id.tvUserDateBirth) TextView tvUserDateBirth;
    @BindView(R.id.tvUserPhone) TextView tvUserPhone;


    User mUser;

    public static void start(Context context, String userJson){
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(KEY_EXTRA_USERS,userJson);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);
        String userJson = getIntent().getStringExtra(KEY_EXTRA_USERS);
        mUser = new User().fromJson(userJson);
        Log.d(TAG,"url image : " + mUser.getImageUrl());
        setupUser();

    }

    private void setupUser(){
        tvUserUsername.setText(mUser.getName());
        Glide.with(this)
                .load(mUser.getImageUrl())
                .into(ivUserCircle);
    }
}
