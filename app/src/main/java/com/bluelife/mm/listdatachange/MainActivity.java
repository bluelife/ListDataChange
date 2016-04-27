package com.bluelife.mm.listdatachange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listView);
        editText=(EditText)findViewById(R.id.editText);
        List<String> dataes=new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            Random random=new Random();

            String data=String.valueOf(random.nextInt(2000)+1000);
            dataes.add(data);
        }
        final SearchableAdapter adapter=new SearchableAdapter(this,dataes);
        listView.setAdapter(adapter);
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                adapter.getFilter().filter(s.toString());
                adapter.notifyDataSetChanged();
            }
        });
    }
}
