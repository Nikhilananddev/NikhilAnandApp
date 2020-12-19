package com.android.nikhilanandapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.LoginManager;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.squareup.picasso.Picasso;

public class Display extends AppCompatActivity {
    private static final String TAG ="Display " ;
//    private ShareDialog shareDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
//        shareDialog = new ShareDialog(this);
        Bundle inBundle = getIntent().getExtras();
        String name = inBundle.get("name").toString();
        String surname = inBundle.get("surname").toString();
        String imageUrl = inBundle.get("imageUrl").toString();
//        ShareLinkContent content = new ShareLinkContent.Builder().build();
//        shareDialog.show(content);
        TextView nameView = (TextView)findViewById(R.id.nameAndSurname);
        nameView.setText("" + name + " " + surname);
        ImageView profileImage=findViewById(R.id.profileImage);
        Log.i(TAG, "onCreate: "+profileImage);
        Picasso.get().load(imageUrl).into(profileImage);

        Button logout = (Button)findViewById(R.id.logout);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.getInstance().logOut();
                Intent login = new Intent(Display.this, MainActivity.class);
                startActivity(login);
                finish();
            }
        });





    }
}