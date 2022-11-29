package hu.home.varosok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

import hu.home.varosok.databinding.ActivityInsertBinding;

public class InsertActivity extends AppCompatActivity {

    ActivityInsertBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.visszaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InsertActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String varosNev = binding.varosNevInput.getText().toString().trim();
                String orszag = binding.orszagInput.getText().toString().trim();
                String lakossag = binding.lakossagInput.getText().toString().trim();

                if (varosNev.isEmpty() || orszag.isEmpty() || lakossag.isEmpty()){
                    Toast.makeText(InsertActivity.this, "Minden mező kitöltése kötelező!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String json = String.format("{\"nev\": \"%s\", \"orszag\": \"%s\", \"lakossag\": \"%s\"}",
                        varosNev, orszag, lakossag);
                RequestTask task = new RequestTask(MainActivity.BASE_URL, "POST", json);
                task.execute();
            }
        });
    }
}