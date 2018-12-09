package irfan.module.androidcomplete.SampleSQLite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import irfan.module.androidcomplete.R;

public class SaveToMain extends AppCompatActivity implements View.OnClickListener {

    EditText et_title, et_author;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_data_sqlite);
        et_title = findViewById(R.id.et_title);
        et_author = findViewById(R.id.et_author);
        Button save = findViewById(R.id.btnsave);
        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        SampleBookHelper bookHelper = new SampleBookHelper(this);
        SQLiteDatabase db = bookHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("title", et_title.getText().toString().trim());
        cv.put("author", et_author.getText().toString().trim());
        long newid = db.insert("book_entries", null, cv);

        Intent i = new Intent(SaveToMain.this, MainSQLite.class);
        startActivity(i);
    }
}
