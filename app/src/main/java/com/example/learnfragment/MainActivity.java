package com.example.learnfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.learnfragment.fragments.FragmentA;
import com.example.learnfragment.fragments.FragmentB;
import com.example.learnfragment.fragments.FragmentC;

public class MainActivity extends AppCompatActivity {

    Button btn, btnAddA, btnPopA, btnAddB, btnAddC;
    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);

        btnAddA = findViewById(R.id.btnAddA);
        btnPopA = findViewById(R.id.btnPopA);
        btnAddB = findViewById(R.id.btnAddB);
        btnAddC = findViewById(R.id.btnAddC);


        manager=getSupportFragmentManager();


        btnAddA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentA fragment=new FragmentA();
                add(fragment,
                        "fraga"
                        ,"fa");
            }
        });

        btnPopA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment;
                fragment=manager.findFragmentByTag("fraga");
                remove(fragment,"fraga");
            }
        });

        btnAddB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentB fragment=new FragmentB();
                add(fragment,
                        "fragb"
                        ,"fb");
            }
        });

        btnAddC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentC fragment=new FragmentC();
                add(fragment,
                        "fragc"
                        ,"fc");
            }
        });





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.add(R.id.fmLayout, new FragmentB());
                transaction.commit();
            }
        });
    }
    private void add(Fragment fragment, String tag, String name){
        transaction=manager.beginTransaction();
        transaction.add(R.id.fmLayout,fragment,tag);
        transaction.addToBackStack(name);
        transaction.commit();
    }

    private void remove(Fragment fragment,String tag){
        transaction=manager.beginTransaction();
        fragment=manager.findFragmentByTag(tag);
        transaction.remove(fragment);
        transaction.commit();
    }
    public void addA(View v){
        FragmentA fragment=new FragmentA();
        add(fragment,
                "fraga"
                ,"fa");
    }
    public void onBackPressed() {
        if(manager.getBackStackEntryCount()>0)
            manager.popBackStack();
        else
            super.onBackPressed();
    }
    public void popA(View v){
        manager.popBackStack("fa",0);
    }





}