package com.example.sravanreddy.constraintlayoutdemo;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    public static String TAG=MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editText);
        if(savedInstanceState!=null)
            editText.setText(savedInstanceState.getString(Constants.savedKey));
        Log.i(TAG, getString(R.string.log_onCreate));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, getString(R.string.log_onStart));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, getString(R.string.log_onResume));

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, getString(R.string.log_onPause));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, getString(R.string.log_onStop));
    }

    public void clickHandler(View view) {
        switch(view.getId()){
            case R.id.button:
                Button backButton=(Button)findViewById(R.id.button);
                String buttonName=backButton.getText().toString();
//                EditText  editText=(EditText)findViewById(R.id.editText);
//                editText.setText(buttonName, TextView.BufferType.NORMAL);
//                Toast.makeText(getApplicationContext(), buttonName, Toast.LENGTH_SHORT).show();
                Intent hintent=new Intent(MainActivity.this, HomeActivity.class);
                hintent.putExtra(Constants.key1, buttonName);
                 startActivityForResult(hintent, 007);
                break;
            case R.id.button2:
//                Button nextButton=(Button)findViewById(R.id.button2);
//                String buttonName2=nextButton.getText().toString();
//                Toast.makeText(getApplicationContext(), buttonName2, Toast.LENGTH_SHORT).show();
//                final String CALCULATOR_PACKAGE ="com.android.calculator2";
//                final String CALCULATOR_CLASS ="com.android.calculator2.Calculator";
//                Intent intent = new Intent();
//
//                intent.setAction(Intent.ACTION_MAIN);
//                intent.addCategory(Intent.CATEGORY_LAUNCHER);
//                intent.setComponent(new ComponentName(
//                        CALCULATOR_PACKAGE,
//                        CALCULATOR_CLASS));

                Intent dIntent=new Intent(Intent.ACTION_DIAL);
                startActivity(dIntent);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String receivedData=data.getStringExtra(Constants.key2);
        EditText  editText=(EditText)findViewById(R.id.editText);
        editText.setText(receivedData, TextView.BufferType.NORMAL);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.getString(Constants.savedKey, editText.getText().toString());
    }
}
