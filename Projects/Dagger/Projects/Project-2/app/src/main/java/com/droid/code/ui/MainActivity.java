package com.droid.code.ui;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.droid.code.MyApplication;
import com.droid.code.R;
import com.droid.code.di.components.DaggerApplicationActivityComponent;
import com.droid.code.di.modules.ActivityModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    public MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerApplicationActivityComponent
                .builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MyApplication)getApplication()).applicationComponent)
                .build().inject(this);

        Toast.makeText(this,viewModel.getSomeData(),Toast.LENGTH_LONG).show();
    }
}
