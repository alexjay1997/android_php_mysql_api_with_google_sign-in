package com.al.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;




public class Layout3 extends AppCompatActivity {


    TextView result_data_id, result_data_fullname, result_data_username,result_data_password;
    ListView listview;
    //ArrayList<String> arrayList = new ArrayList<>();

    ArrayAdapter<String> arrayAdapter;
    TableLayout table_data;
    RequestQueue requestQueue;

    UsersArrayAdapter usersArrayAdapter;

   private static String showUrl= "http://192.168.50.146/android_crud_mysql/includes/android_data.php";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout3);
        listview =findViewById(R.id.listview);
        listview.setAdapter(usersArrayAdapter);
        usersArrayAdapter = new UsersArrayAdapter(this,R.layout.list_users);


        final  ListView listview  =(ListView) findViewById(R.id.listview);


        ArrayList<Users>  usersArrayList = new ArrayList<>();
        UsersArrayAdapter usersArrayAdapter = new UsersArrayAdapter(this,R.layout.list_users);

        listview.setAdapter(usersArrayAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {


               //****** Start Selecting users from custom listview and getting the select users id *********

                TextView textview_id  = (TextView) view.findViewById(R.id.textView_user_id);
                 Toast.makeText(getApplicationContext(),"Selected User:  "+textview_id.getText().toString(),Toast.LENGTH_LONG).show();

                //************+****************************END*****************************************
                TextView textView_userId = (TextView) view.findViewById(R.id.textView_user_id);
                TextView textView_userfullname = (TextView) view.findViewById(R.id.textView_user_fullname);
                TextView textView_username = (TextView) view.findViewById(R.id.textView_user_username);
                TextView textView_password = (TextView) view.findViewById(R.id.textView_user_password);

                //****PASS THE SELECTED DATA OR USER INTO THE NEXT ACTIVITY***
                Intent intent = new Intent(Layout3.this, View_Layout.class);

                    intent.putExtra("user_id", textview_id.getText().toString());
                    intent.putExtra("user_fullname", textView_userfullname.getText().toString());
                    intent.putExtra("user_name", textView_username.getText().toString());
                    intent.putExtra("user_password", textView_password.getText().toString());

                    startActivity(intent);
                //************+****************************END*****************************************

                //***************** Only works with simple arrayAdapter  *****************
              // ListView list = (ListView) view.findViewById(R.id.listview);
                //String text = (String) listview.getItemAtPosition(position);
               // Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();

            // *****************************************************************************
            }
        });


        //*****get request using volley library
        requestQueue = Volley.newRequestQueue(getApplicationContext());



        System.out.println("fecthing datas from api.. ");
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                showUrl, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response.toString());
                Toast.makeText(getApplicationContext(), "Fetching datas..", Toast.LENGTH_SHORT).show();

                try {
                    String user_id,fullname,username,password;
                    JSONArray usersdata = response.getJSONArray("users");
                    for (int i = 0; i < usersdata.length(); i++) {
                        JSONObject user = usersdata.getJSONObject(i);
                        //Users users = new Users();

                     // Users userlist =new Users(user.getString("id"),
                      //         user.getString("fullname"),
                      //         user.getString("username"),
                       //        user.getString("password"));

                       // Users userlist =new Users ());
                       // Users.setUsername(user.getString("username"));
                       // Users.setPassword(user.getString("password"));

                        user_id =  user.getString("id");
                         fullname =  user.getString("fullname");
                       username =  user.getString("username");
                        password = user.getString("password");

                        Users users =new Users(user_id,fullname,username,password);

                        usersArrayAdapter.add(users);

                        //result_data.append("User id: " + id + "\n" + "Name: " + fullname + "\n" + "User Name: " + username + "\n" + "Password: " + password + " \n\n " );

                      //  usersArrayList.add(user_id);
                     //  usersArrayList.add(fullname);
                    //  usersArrayList.add(username);
                      //  usersArrayList.add(password);








                    }

                    //result_data.append("============================\n");
                   // arrayAdapter.add(response.toString());


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //********to display array list to list view initiating adapter******** start**********
               // ArrayAdapter arrayAdapter = new ArrayAdapter<Users>(getApplicationContext(), android.R.layout.simple_list_item_1,usersArrayList);

                //    ******************* end initiating adapter funciton *****************


            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.append(error.getMessage());

            }
        });

        requestQueue.add(jsonObjectRequest);

    }
}
// });




//}