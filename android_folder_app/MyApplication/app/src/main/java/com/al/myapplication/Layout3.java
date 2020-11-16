package com.al.myapplication;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.al.myapplication.R.id.listview;
import static com.al.myapplication.R.id.textView_show_fullname;


public class Layout3 extends AppCompatActivity {


    TextView result_data_id, result_data_fullname, result_data_username,result_data_password;
    ListView listview;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    TableLayout table_data;
    RequestQueue requestQueue;

String showUrl= "http://192.168.50.4/android_crud_mysql/includes/android_data.php";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout3);

        result_data_id = (TextView) findViewById(R.id.textView_show_id);
        result_data_fullname = (TextView) findViewById(R.id.textView_show_fullname);
        result_data_username = (TextView) findViewById(R.id.textView_show_username);
        result_data_password = (TextView) findViewById(R.id.textView_show_password);

        //result_data.setMovementMethod(new ScrollingMovementMethod()); //scrollable Textview
//result_data_id.getText().toString(),result_data_fullname.getText().toString(),result_data_username.getText().toString(),result_data_password.getText().toString()

      final  ListView listview  =(ListView) findViewById(R.id.listview);
       // arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);



        requestQueue = Volley.newRequestQueue(getApplicationContext());



            System.out.println("fecthing datas from api.. ");
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                    showUrl, new Response.Listener<JSONObject>() {


                @Override
                public void onResponse(JSONObject response) {
                    System.out.println(response.toString());
                    Toast.makeText(getApplicationContext(), "Fetching datas..", Toast.LENGTH_SHORT).show();

                    try {
                        JSONArray users = response.getJSONArray("users");
                        for (int i = 0; i < users.length(); i++) {
                            JSONObject user = users.getJSONObject(i);
                            int id = user.getInt("id");
                            String fullname = user.getString("fullname");
                            String username = user.getString("username");
                            String password = user.getString("password");

                            //result_data.append("User id: " + id + "\n" + "Name: " + fullname + "\n" + "User Name: " + username + "\n" + "Password: " + password + " \n\n " );

                            arrayList.add(" UserId: "+id+" \n\n"+"Name: "+fullname+"\n \n"+"Username: "+username+"\n \n"+"password: "+password+"\n \n");








                        }

                        //result_data.append("============================\n");
                        //arrayAdapter.add(response.toString());

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    //********to display array list to list view initiating adapter******** start**********
                    ArrayAdapter arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);

                    listview.setAdapter(arrayAdapter);
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
