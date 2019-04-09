package com.example.skeleton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        LiveData<Response> liveData = viewModel.getLiveData();

        liveData.observe(this, response -> textView.setText("name: " + response.getName() + "id: " + response.getId()));

        viewModel.makeNetworkCall();
    }
}
