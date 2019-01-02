package com.example.easymean.android_study;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AddActivity extends AppCompatActivity {

    public static final int REQ_CODE_REGISTER =1;
    private EditText editText;
    private CustomAdapter adapter;
    private List<Memo> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_menu);
        adapter = new CustomAdapter(itemList);
        editText = (EditText) findViewById(R.id.add_edit);
    }

    public void onSubmitButtonClick(View v){
        Memo item = new Memo(editText.getText().toString());

        String text = editText.getText().toString();
        editText.setText("");

        if(text.length() ==0){
            Toast.makeText(this, "메뉴를 입력해주세요", Toast.LENGTH_LONG).show();
            return;
        }
//
//        itemList.add(item);
//        editText.setText("");
//        adapter.notifyDataSetChanged();

        Toast.makeText(this, "추가됐습니다!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("item", item);
        setResult(RESULT_OK, intent);
        finish();
    }


}
