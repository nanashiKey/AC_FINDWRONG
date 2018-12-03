package irfan.module.androidcomplete;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

        //ini dihilangkan
        pass = findViewById(R.id.edpasss);


        /**
         * inisialisasi button
         */
        klik = findViewById(R.id.btnKlik);

        //ini dihilangkan
        klik.setOnClickListener(this);
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
                //ini dihilangkan
                String inputEmail = email.getText().toString();
                String inputPass = pass.getText().toString();
                cekdata(inputNama, inputEmail, inputPass);
            break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.latihan_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.pilihan1:
                Toast.makeText(getApplicationContext(), " anda memilih pilihan 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pilihan2:
                Toast.makeText(getApplicationContext(), " anda memilih pilihan 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pilihan3:
                Toast.makeText(getApplicationContext(), " anda memilih pilihan 3", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(getApplicationContext(), " anda tidak memilih pilihan 1-3", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}
