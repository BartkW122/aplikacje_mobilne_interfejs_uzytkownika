package com.example.interfejs_uzytkownika;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button like;
    private Button delete;
    private TextView polubienia;
    private int ilosc_polubien=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        like=findViewById(R.id.like);
        delete=findViewById(R.id.delete);
        polubienia=findViewById(R.id.polubienia);

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ilosc_polubien++;
                polubienia.setText(String.valueOf(ilosc_polubien) +" polubień");
            }
        });
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ilosc_polubien--;
                polubienia.setText(String.valueOf(ilosc_polubien) +" polubień");
                if(ilosc_polubien<0){
                    ilosc_polubien=0;
                    polubienia.setText(String.valueOf(ilosc_polubien) +" polubień");
                }
            }
        });

    }
}