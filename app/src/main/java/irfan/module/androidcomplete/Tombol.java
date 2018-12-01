package irfan.module.androidcomplete;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Tombol extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_methode);
        View.OnClickListener kelik = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "terklik", Toast.LENGTH_SHORT).show();

            }
        };

        //inisialisasi variable button
        Button tbl3 = findViewById(R.id.tbl3);
        tbl3.setOnClickListener(kelik);

        Button tbl4 = findViewById(R.id.tbl4);
        Button tbl5 = findViewById(R.id.tbl5);

        tbl4.setOnClickListener(this);
        tbl5.setOnClickListener(this);
    }
        public void pencetin(View v){
        Toast.makeText(this, "terpencet", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
            switch (view.getId()){
        case R.id.tbl4:
            Toast.makeText(this, "terpencet tbl 4", Toast.LENGTH_SHORT).show();
            break;
        case R.id.tbl5:
            Toast.makeText(this, "terpencet tbl 5", Toast.LENGTH_SHORT).show();
            break;
    }
    }
}
