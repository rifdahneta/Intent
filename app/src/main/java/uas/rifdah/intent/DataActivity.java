package uas.rifdah.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

       TextView namaData=findViewById(R.id.nama);
      TextView  alamatData = findViewById(R.id.alamat);
        TextView umurData = findViewById(R.id.umur);

        namaData.setText(getIntent().getStringExtra("nama"));
        alamatData.setText(getIntent().getStringExtra("alamat"));
        umurData.setText(getIntent().getStringExtra("umur"));
    }
}
