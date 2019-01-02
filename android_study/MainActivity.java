package com.example.easymean.android_study;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int REQ_CODE_REGISTER = 1;

    private RecyclerView recyclerView;
    private EditText editText;
    private List<Memo> itemList = new ArrayList<>();
    private CustomAdapter adapter = new CustomAdapter(itemList);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        editText = (EditText) findViewById(R.id.add_edit);

        setRecyclerView();
    }

     private void setRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        //recycler view를 위해 customadapter를 사용
        recyclerView.setAdapter(adapter);

    }

    public void onAddButtonMainClick(View v){
        Intent intent = new Intent(this, AddActivity.class);
        startActivityForResult(intent, REQ_CODE_REGISTER);
        }

    public void onResultButtonClick(View v){
        Intent intent = new Intent (this, ResultActivity.class);
        int itemCount = itemList.size();
        intent.putExtra("itemCount", itemCount);
        startActivityForResult(intent, REQ_CODE_REGISTER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQ_CODE_REGISTER){
            if(resultCode == RESULT_OK){
                Memo item = (Memo) data.getSerializableExtra("item");
                itemList.add(item);
                adapter.increaseCount();
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
            }
        }
    }


}


