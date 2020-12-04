package com.al.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;

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

import java.util.HashMap;
import java.util.Map;


public class View_Layout extends AppCompatActivity {

    String deleteUrl= "http://192.168.50.146/android_crud_mysql/delete.php";// url delete

    TextView id,user_idTextView,user_fullnameTextView,user_nameTextView,user_passwordTextView;

    Button edit_button,delete_button;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_layout);


        String user_id_view = getIntent().getStringExtra("user_id");
        String user_fullname_view = getIntent().getStringExtra("user_fullname");
        String user_name_view = getIntent().getStringExtra("user_name");
        String user_password_view = getIntent().getStringExtra("user_password");

        id = (TextView) findViewById(R.id.userId_textView);
        id.setText(user_id_view);

        user_fullnameTextView = (TextView) findViewById(R.id.userfullname_textView);
        user_fullnameTextView.setText(user_fullname_view);
        user_nameTextView = (TextView) findViewById(R.id.user_username_textView);
        user_nameTextView.setText(user_name_view);
        user_passwordTextView = (TextView) findViewById(R.id.user_password_textView);
        user_passwordTextView.setText(user_password_view);


        EditText user_id_delete = findViewById(R.id.editText_userId_delete);
        user_id_delete.setText(user_id_view);//for delete id holder
        requestQueue = Volley.newRequestQueue(getApplicationContext());

        edit_button = (Button)findViewById(R.id.button_edit_user);
        delete_button =(Button)findViewById(R.id.button_delete_user);

        edit_button.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                    Intent intent = new Intent(View_Layout.this,Edit.class);

                    intent.putExtra("user_id",id.getText().toString());
                    intent.putExtra("user_fullname", user_fullnameTextView.getText().toString());
                    intent.putExtra("user_name", user_nameTextView.getText().toString());
                    intent.putExtra("user_password", user_passwordTextView.getText().toString());

                    startActivity(intent);


            }






    });

       delete_button.setOnClickListener(new View.OnClickListener() {
           @Override


        public void onClick(View view) {
            StringRequest request = new StringRequest(Request.Method.POST, deleteUrl ,new Response.Listener<String>(){


                public void onResponse(String response) {
                    System.out.println("successfully Deleted users!");
                    Toast.makeText(getApplicationContext()," Successfully Deleted record! ", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(View_Layout.this,Layout3.class);
                    startActivity(intent);
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(getApplicationContext(),"Failed to Delete record! ", Toast.LENGTH_SHORT).show();
                }

            }) {
                @Override
                protected Map<String ,String> getParams() throws AuthFailureError{


                    Map<String,String> parameters = new HashMap<String,String>();


                    parameters.put("id",user_id_delete.getText().toString());


                    // parameters.put("access_token",  tokenTextView.getText().toString() );//App.getToken()
                    return parameters;


                }

            };
            requestQueue.add(request);
        }


      });
}


}
