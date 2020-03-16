package com.example.palettefragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class PalletteFragment extends AppCompatActivity{

    CanvasFragment fragment;
    TextView View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pallette_fragment);

        fragment = new CanvasFragment();
        Resources res = getResources();
        final String topic = getResources().getString(R.string.app_name);
        final String[] color = res.getStringArray(R.array.color);
        Spinner spinner = findViewById(R.id.spinner);
        final ColorAdapter adapter = new ColorAdapter(color, this);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if (position != 0) {
                    Bundle b = new Bundle();
                    b.putInt("position", position);
                    fragment.setArguments(b);
                    transaction.replace(R.id.pallette_fragment, fragment).addToBackStack(null).commit();
                }else{
                    //View.setBackgroundColor(Color.parseColor("WHITE"));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
class ColorAdapter extends BaseAdapter {

    private String list[];
    private Activity activity;

    public ColorAdapter(String list[], Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public Object getItem(int position) {
        return list[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = new TextView(activity.getApplicationContext());
        view.setId(position);
        view.setText(list[position]);
        String color[] = {"WHITE", "BLUE", "GREEN", "RED"};
        if (position != 0) {
            for (int i = 0; i < position; i++) {
                view.setBackgroundColor(Color.parseColor(color[position]));
            }
        }
        return view;
    }

    }
}