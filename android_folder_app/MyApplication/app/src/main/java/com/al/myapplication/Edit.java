package com.al.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.invoke.MethodHandleInfo;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;


public class Edit extends AppCompatActivity {

    String updateUrl= "http://192.168.50.146/android_crud_mysql/functions/update.php"; //url for update
    RequestQueue requestQueue;
    EditText id, fullname, username,password;
    Button update_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_layout);


        String user_id_view = getIntent().getStringExtra("user_id");
        String user_fullname_view = getIntent().getStringExtra("user_fullname");
        String user_name_view = getIntent().getStringExtra("user_name");
        String user_password_view = getIntent().getStringExtra("user_password");

        id = (EditText) findViewById(R.id.editText_user_id);
        id.setText(user_id_view);

        fullname = (EditText) findViewById(R.id.editText_user_fullname);
        fullname.setText(user_fullname_view);

        username = (EditText) findViewById(R.id.editText_user_name);
        username.setText(user_name_view);

        password = (EditText) findViewById(R.id.editText_user_password);
        password.setText(user_password_view);

        update_button= (Button) findViewById(R.id.button_update);

        requestQueue = Volley.newRequestQueue(getApplicationContext());



        update_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Edit.this,Layout3.class);
                startActivity(intent);
                StringRequest request = new StringRequest(Request.Method.POST, updateUrl, new Response.Listener<String>() {


                    public void onResponse(String response) {
                        System.out.println("successfully Update new users!");
                        Toast.makeText(getApplicationContext(),"User updated successfully",Toast.LENGTH_LONG).show();

                        }




                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getApplicationContext(),"Failed to Update record! Please enter different username!!", Toast.LENGTH_SHORT).show();
                    }

            }) {
            @Override
             protected Map<String ,String> getParams()  throws AuthFailureError{

                 Map<String,String> parameters = new HashMap<String,String>();


               parameters.put("id", id.getText().toString());
                parameters.put("fullname",fullname.getText().toString() );
               parameters.put("username", username.getText().toString());
               parameters.put("password", password.getText().toString());

               // parameters.put("access_token",  tokenTextView.getText().toString() );//App.getToken()
                return parameters;
            }

            };

                requestQueue.add(request);

            }
        });



        }

    }

