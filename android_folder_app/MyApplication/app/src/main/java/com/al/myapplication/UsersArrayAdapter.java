package com.al.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;


public class UsersArrayAdapter extends ArrayAdapter {

   // UserList userlist = new ArrayList();

    List list = new ArrayList();

    public UsersArrayAdapter(Context context, int resource) {
        super(context, resource);

    }


    public void add(Users object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();

    }

    @Override
    public Object getItem(int position) {

        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       View row;

       row =convertView;

        UsersHolder usersHolder;
       if(row==null){

            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row= layoutInflater.inflate(R.layout.list_users,parent,false);
                usersHolder = new UsersHolder();
                usersHolder.tvw_user_id = (TextView) row.findViewById(R.id.textView_user_id);
                usersHolder.tvw_user_fullname = (TextView) row.findViewById(R.id.textView_user_fullname);
                usersHolder.tvw_user_name = (TextView) row.findViewById(R.id.textView_user_username);
                usersHolder.tvw_user_password = (TextView) row.findViewById(R.id.textView_user_password);
                row.setTag(usersHolder);



       }
       else{

           usersHolder = (UsersHolder)row.getTag();
       }
       Users users = (Users)this.getItem(position);
       usersHolder.tvw_user_id.setText(users.getUser_id());
        usersHolder.tvw_user_fullname.setText(users.getFullname());
        usersHolder.tvw_user_name.setText(users.getUsername());
        usersHolder.tvw_user_password.setText(users.getPassword());




        return row;




    }

    static class UsersHolder{

        TextView tvw_user_id,tvw_user_fullname,tvw_user_name,tvw_user_password;


    }
}
