package com.komangkrisnanda.friendfinders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.komangkrisnanda.friendfinders.adapter.UserAdapter;
import com.komangkrisnanda.friendfinders.adapter.UserClickListener;
import com.komangkrisnanda.friendfinders.models.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements UserClickListener{

    @BindView(R.id.rv_users) RecyclerView mRecyclerView;



    private UserAdapter mUserAdapter;
    private List<User> mUserList;
//    @BindView(R.id.tvUserData) TextView mUserTextView;
//    private TextView mUserTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mUserList = new ArrayList<>();
        mUserAdapter = new UserAdapter(this,mUserList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this,2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mUserAdapter);

        mUserAdapter.setItemClickListener(this);
        seedUsers();

    }

    private void seedUsers(){
        List<User> tempUserList = new ArrayList<>();
        for(int i=0;i<8;i++){
            User user = new User("User " + (i + 1),
                    "https://randomuser.me/api/portraits/men/" + i +".jpg");
            tempUserList.add(user);
        }
        mUserAdapter.setUsers(tempUserList);
    }

    @Override
    public void onUserItemClicked(User user) {
        DetailActivity.start(this,user.toJson());
    }
}
