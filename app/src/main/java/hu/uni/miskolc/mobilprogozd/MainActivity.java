package hu.uni.miskolc.mobilprogozd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {
    public static final String tag = "Kiscica";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.wtf(tag,"Hello");
        FloatingActionButton cimhozzadas = findViewById(R.id.CimHozzaadasGomb);
        cimhozzadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CimFelviletActivity.class);
                startActivity(intent);
            }
        });
    }
}