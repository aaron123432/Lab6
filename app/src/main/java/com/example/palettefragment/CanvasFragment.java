package com.example.palettefragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class CanvasFragment extends Fragment{
    private static final String Key = "position";
    View layout;
    int position;
    String colors[] = {"WHITE", "BLUE", "GREEN", "RED"};
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        layout = inflater.inflate(R.layout.canvas_fragment, container, false);
        Bundle b = getArguments();
        position = b.getInt(Key);
        for(int i = 0; i < colors.length; i++){
            if(position == i) {
                layout.setBackgroundColor(Color.parseColor(colors[i]));
            }
        }

        return layout;
    }



}
