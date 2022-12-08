package hu.home.varosok;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import hu.home.varosok.databinding.ActivityListBinding;

public class ListActivity extends AppCompatActivity {

    public class CityAdapter extends ArrayAdapter<City>{

        private List<City> cityLogs;

        public CityAdapter(@NonNull Context context, int resource, @NonNull List<City> objects) {
            super(ListActivity.this, R.layout.city_list_item, objects);
            cityLogs = objects;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.city_list_item, parent);
            City city = cityLogs.get(position);
            TextView display = view.findViewById(R.id.dataDisplayTextView);
            TextView modify = view.findViewById(R.id.modifyButton);
            TextView delete = view.findViewById(R.id.deleteButton);

            display.setText(city.toString());
            modify.setOnClickListener(v -> {
                //TODO: update form
            });
            delete.setOnClickListener(v -> {
                //TODO: delete item
            });

            return view;
        }
    }


    public static ActivityListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RequestTask task = new RequestTask(MainActivity.BASE_URL);
        task.execute();

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}