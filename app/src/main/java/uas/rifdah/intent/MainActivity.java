package uas.rifdah.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btnMoveActivity)
    Button btnMoveActivity;
    @BindView(R.id.btnDataActivity)
    Button btnDataActivity;
    @BindView(R.id.btnObjectActivity)
    Button btnObjectActivity;
    @BindView(R.id.btnResultActivity)
    Button btnResultActivity;
    @BindView(R.id.btnWebtActivity)
    Button btnWebtActivity;
    @BindView(R.id.btnDialActivity)
    Button btnDialActivity;

    public static Integer REQUEST_CODE = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.btnMoveActivity, R.id.btnDataActivity, R.id.btnObjectActivity, R.id.btnResultActivity, R.id.btnWebtActivity, R.id.btnDialActivity})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnMoveActivity:
                moveActivity();
                break;
            case R.id.btnDataActivity:
                moveData();
                break;
            case R.id.btnObjectActivity:
                moveObject();
                break;
            case R.id.btnResultActivity:
                moveCallback();
                break;
            case R.id.btnWebtActivity:
                moveWeb();
                break;
            case R.id.btnDialActivity:
                moveDial();
                break;
        }
    }

    private void moveWeb() {
        String url = "http://www.google.com";
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

    private void moveDial() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0123456789"));
        startActivity(intent);
    }

    private void moveObject() {
        DataPerson data = new DataPerson("Rifdah", 20, "Jakarta");
        Intent intent = new Intent(this, ObjectActivity.class);
        intent.putExtra("data", data);
        startActivity(intent);

    }

    private void moveActivity() {
        Intent intent = new Intent(this, MoveActivity.class);
        startActivity(intent);
    }

    private void moveData() {
        Intent intent = new Intent(this, DataActivity.class);
        intent.putExtra("nama", "Rifdah");
        intent.putExtra("alamat", "Jakarta");
        intent.putExtra("umur", "20 tahun");
        startActivity(intent);

    }

    private void moveCallback() {

        Intent intent = new Intent(this, CallbackActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, data.getStringExtra("RESULT"), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
