package com.example.sravanreddy.constraintlayoutdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String dataRecieved=getIntent().getExtras().getString(Constants.key1);
        TextView resTextView=findViewById(R.id.homeTextView);
        resTextView.setText(dataRecieved, TextView.BufferType.NORMAL);
    }

    public void homeButton(View view) {
        Intent intent=new Intent();
        TextView resTextView=findViewById(R.id.homeTextView);
        String sendback=resTextView.getText().toString();
        intent.putExtra(Constants.key2,sendback);
        setResult(RESULT_OK, intent);
        finish();
    }
}
