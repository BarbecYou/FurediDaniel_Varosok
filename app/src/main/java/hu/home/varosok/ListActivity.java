package hu.home.varosok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;

import java.io.IOException;

import hu.home.varosok.databinding.ActivityListBinding;

public class ListActivity extends AppCompatActivity {

    public static ActivityListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RequestTask task = new RequestTask(MainActivity.BASE_URL);
        task.execute();

        binding.listDataTextView.setMovementMethod(new ScrollingMovementMethod());
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}