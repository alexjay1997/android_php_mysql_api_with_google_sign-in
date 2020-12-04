package com.al.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class Layout2 extends AppCompatActivity {



    EditText fullname,username,password;
    TextView tokenTextView;
    Button ButtonInsert ,ButtonShow;
    Button signOut;
    RequestQueue requestQueue;


    GoogleSignInClient mGoogleSignInClient;

    String insertUrl= "http://192.168.50.146/android_crud_mysql/functions/create.php?";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout2);

        String TokenData = getIntent().getStringExtra("Keytoken");

        tokenTextView = findViewById(R.id.get_token_TextView);
        tokenTextView.setText(TokenData);

        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.server_client_Id))
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        signOut = (Button) findViewById(R.id.button_sign_out);

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    // ...
                    case R.id.button_sign_out:
                       signOut();
                        break;
                    // ...
                }
            }



        });








        ButtonShow = (Button)findViewById(R.id.button_show);

        //show button start
        ButtonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Layout2.this,Layout3.class);
                startActivity(intent);
            }
        });
     //show button end

        fullname = (EditText)findViewById(R.id.input_name);
        username= (EditText)findViewById(R.id.input_username);
        password = (EditText)findViewById(R.id.input_password);

        ButtonInsert = (Button) findViewById(R.id.btn_insert);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        ButtonInsert.setOnClickListener(new View.OnClickListener(){

            @Override
           public void onClick(View view) {
                StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //System.out.println(response.toString());

                        System.out.println("successfully added new member");

                        // error message from json response  start

                        try {
                            JSONObject jsonObject =new JSONObject(response);
                            Toast.makeText(getApplicationContext(),jsonObject.getString("message"),Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            System.out.println("error");
                        }


                        // error message from json response end

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(getApplicationContext(),"Failed to add new record! Please enter different username!!", Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<String, String>();

                        parameters.put("fullname", fullname.getText().toString());
                        parameters.put("username", username.getText().toString());
                        parameters.put("password", password.getText().toString());

                        parameters.put("access_token",  tokenTextView.getText().toString() );//App.getToken()
                        return parameters;

                    }










                };

                requestQueue.add(request);
           }
        });





    }



    private void signOut(){
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getApplicationContext(),"Sign-Out",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
    }

}

