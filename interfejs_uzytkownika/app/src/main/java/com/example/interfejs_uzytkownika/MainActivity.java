package com.example.interfejs_uzytkownika;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

    private Button zapisz;
    private Button pokaz;

    private EditText emial;
    private EditText pass;
    private EditText r_pass;
    private TextView info;
    private String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        like=findViewById(R.id.like);
        delete=findViewById(R.id.delete);
        polubienia=findViewById(R.id.polubienia);

        emial=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        r_pass=findViewById(R.id.r_pass);
        info=findViewById(R.id.info);

        zapisz=findViewById(R.id.zapisz);
        pokaz=findViewById(R.id.show_user);


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

        zapisz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String email_input=emial.getText().toString().trim();
                String pass_input=pass.getText().toString().trim();
                String r_pass_input=r_pass.getText().toString().trim();

                if(email_input.isEmpty()){
                    info.setText("pole email nie moze byc puste");
                    return;
                }
                if(pass_input.isEmpty()){
                    info.setText("pole haslo nie moze byc puste");
                    return;
                }
                if(r_pass_input.isEmpty()){
                    info.setText("pole Powtorz haslo nie moze byc puste");
                    return;
                }
//                if(!Patterns.EMAIL_ADDRESS.matcher(email_input).matches()){
//                    info.setText("nie poprawny zapis maila");
//                    return;
//                }
                if(!email_input.contains("@")){
                    info.setText("nie poprawny zapis maila");
                    return;
                }
                if(!r_pass_input.equals(pass_input)){
                    info.setText("haslo musi sie powtarzac");
                    return;
                }
                if(!email_input.isEmpty() && !pass_input.isEmpty() && !r_pass_input.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email_input).matches() && r_pass_input.equals(pass_input)){
                    user="";
                    info.setText("Zarejestrowano "+email_input);
                    user=email_input;
                }
            }
        });

        pokaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText("ostatnio zarejestrowany emial to "+user);
            }
        });

    }
}