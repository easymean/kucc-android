package com.example.easymean.android_study;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ResultActivity extends AppCompatActivity {

    public static final int REQ_CODE_REGISTER =1;

    private TextView textView;
    private List<Memo> itemList = new ArrayList<>();
    private CustomAdapter adapter = new CustomAdapter(itemList);

    Random rnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        Intent intent = getIntent();

        int data = intent.getIntExtra("itemCount",1);
//
//        int data = adapter.getItemCount();

        if(data == 0){
            Toast.makeText(this, "메뉴가 한개 이상 필요합니다", Toast.LENGTH_LONG).show();
            return;
        }
        rnd = new Random();
        int num = rnd.nextInt(data);

        textView = (TextView) this.findViewById(R.id.selectedText);
        String selectedText = itemList.get(num).toString();
        textView.setText(selectedText);

    }

    public void onMainButtonClick(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent, REQ_CODE_REGISTER);
    }
}
