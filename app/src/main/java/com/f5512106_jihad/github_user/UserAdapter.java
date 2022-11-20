package com.f5512106_jihad.github_user;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<User> users;
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public UserAdapter(Context context) {
        this.context = context;
        users = new ArrayList<>();
    }
    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_user, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        User user = (User) getItem(i);
        viewHolder.bind(user);
        return view;
    }
    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_type);
            imgPhoto = view.findViewById(R.id.img_photo);
        }
        public void bind(User user) {
            txtName.setText(user.getName());
            txtDescription.setText(user.getType());
            Glide.with(context)
                    .load(user.getPhoto())
                    .into(imgPhoto);
        }
    }
}

