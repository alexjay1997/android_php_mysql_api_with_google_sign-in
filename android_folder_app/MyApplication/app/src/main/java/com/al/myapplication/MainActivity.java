package com.al.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;


public class MainActivity extends AppCompatActivity {


    // Set the dimensions of the sign-in button.
    private static final String TAG ="MainActivity";
    private static final int RC_GET_TOKEN =9002;

    String appID = "vampire_of_dead";

    SignInButton signInButton ;
    private GoogleSignInClient mGoogleSignInClient;
    private TextView IdToken_TextView;
    int RC_SIGN_IN =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      signInButton  = findViewById(R.id.sign_in_button);
     signInButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             switch (view.getId()) {
                 case R.id.sign_in_button:
                     signInButton();
                     break;
                 // ...
             }

         }


     });

        IdToken_TextView = findViewById(R.id.IdToken_textView);



        // Configure sign-in to request the user's ID, email address



        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.server_client_Id))
                .requestEmail()
                .build();


        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }

    private void signInButton() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();

        startActivityForResult(signInIntent, RC_GET_TOKEN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_GET_TOKEN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            String idToken = account.getIdToken().toString();

            // Signed in successfully, show authenticated UI.
            // updateUI(account);
            Intent intent =new Intent(this,Layout2.class);
            //Intent intent = new Intent(getBaseContext(), SignoutActivity.class);
            intent.putExtra("Keytoken", idToken );
            startActivity(intent);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("error", "signInResult:failed code=" + e.getStatusCode());
           // updateUI(null);
        }
    }


}
