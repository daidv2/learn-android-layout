package com.example.learn_android_layout.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.widget.TextView;

import com.example.learn_android_layout.ElementsAdapter;
import com.example.learn_android_layout.R;

/**
 * CoordinatorLayout (1) xây dựng bố cục Behavior và Nested Scroll
 * https://xuanthulab.net/coordinatorlayout-1-xay-dung-bo-cuc-behavior-va-nested-scroll.html
 */
public class CoordinatorActivity extends AppCompatActivity {

    TextView txtTest;
    CoordinatorLayout.LayoutParams txtTestLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);

        txtTest = findViewById(R.id.txtTest);
        txtTestLayout = (CoordinatorLayout.LayoutParams)txtTest.getLayoutParams();
        //txtTestLayout.anchorGravity = Gravity.TOP | Gravity.CENTER;

        //Sử dụng RecyclerView
        RecyclerView listView = findViewById(R.id.mylistview);
        RecyclerView.Adapter adapter = new ElementsAdapter();
        listView.setLayoutManager(new LinearLayoutManager(this));

        listView.setAdapter(adapter);

        RecyclerView listView2 = findViewById(R.id.mylistview_2);
        RecyclerView.Adapter adapter2 = new ElementsAdapter();
        listView2.setLayoutManager(new LinearLayoutManager(this));

        listView2.setAdapter(adapter2);
    }
}



