package uas.rifdah.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ObjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);

        TextView tvObject = findViewById(R.id.namaObject);
        DataPerson data = getIntent().getParcelableExtra("data");
        tvObject.setText(" nama : " + data.getNama() +
                "\n umur : " + data.getUmur() +
                "\n alamat : " + data.getAlamat());
    }
}
