package irfan.module.androidcomplete;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FindTheWrong extends AppCompatActivity  implements View.OnClickListener {

    /**
     * membuat variable
     */
    EditText nama;
    EditText email;
    EditText pass;
    Button klik;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findthewrong);

        /**
         * instansiasi/inisialisasi variable dari view
         */
        nama = findViewById(R.id.ednama);
        email = findViewById(R.id.edemail);


        /**
         * inisialisasi button
         */
        klik = findViewById(R.id.btnKlik);
    }

    /**
     * methode untuk melakukan pengecekan email, nama dan password
     */
    public void cekdata(String Nama, String Email, String Pass){
        //lakukan pengecekan.
        if(Nama.equals("") || Email.equals("") || Pass.equals("") ||
                !Nama.equals("test") || !Email.equals("email@test.com") || !Pass.equals("test12345")
                ){
            //munculkan toast saat data yg ditampilkan salah
            Toast.makeText(getApplicationContext(), "nama, email atau password salah", Toast.LENGTH_SHORT).show();
        }else{
            //diarahkan ke activity lain
            Intent oke = new Intent(FindTheWrong.this, ListViewSample.class);
            startActivity(oke);
        }
    }

    /**
     * methode onClick
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnKlik:
                String inputNama = nama.getText().toString();
                String inputPass = pass.getText().toString();
                cekdata(inputNama, inputEmail, inputPass);
            break;
        }
    }
}
