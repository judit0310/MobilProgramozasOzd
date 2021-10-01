package hu.uni.miskolc.mobilprogozd;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CimMegjelenites extends AppCompatActivity {

    int CAMERA_IMAGE_REQUEST = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cim_megjelenites);
        Intent intent = getIntent();
        Cim cim = (Cim) intent.getSerializableExtra("cim");
        String nev = intent.getStringExtra("nev");
        TextView nevkiirMezo = findViewById(R.id.nevkiirMezo);
        nevkiirMezo.setText(nev);
        TextView cimkiirMezo = findViewById(R.id.cimkiirMezo);
        cimkiirMezo.setText(cim.getIranyitoszam()+" "+cim.getVaros()+", "
                +cim.getUtca()+" "+cim.getHazszam());
        Button kameraGomb = findViewById(R.id.kameraGomb);
        kameraGomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_IMAGE_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== CAMERA_IMAGE_REQUEST){
            if (resultCode == RESULT_OK){
                Bitmap img = (Bitmap) data.getExtras().get("data");
                findViewById(R.id.layout).setBackground(new BitmapDrawable(getResources(),img));
            }
        }
    }
}