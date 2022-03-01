package com.droid.code.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.droid.code.R;

public class MainActivity extends AppCompatActivity {

    //public MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DependencyComponent.inject(this);

        //TextView tvData = findViewById(R.id.tvData);
       // tvData.setText(viewModel.getSomeData());
    }
}
