package irfan.module.androidcomplete.SampleSQLite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import irfan.module.androidcomplete.R;

public class MainSQLite extends AppCompatActivity {

    SimpleCursorAdapter aa ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_sql_lite);
        ListView lv = findViewById(R.id.lv);
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);


        SampleBookHelper bookHelper = new SampleBookHelper(this);
        SQLiteDatabase db = bookHelper.getWritableDatabase();

        String[] projection = {"id", "title"};
        Cursor c = db.query("book_entries", projection,
                null, null, null, null, null);

        ArrayList<String> data = new ArrayList<>();
        c.moveToFirst();
        while (!c.isAfterLast()){
            String title = c.getString(c.getColumnIndex("title"));
            data.add(title);
            c.moveToNext();
        }

        if(data.isEmpty()){
            data.add("No book Entries, please add");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        lv.setAdapter(adapter);

//        aa = new SimpleCursorAdapter(android.R.layout.simple_list_item_2, c, new String[]{"title", "author"},
//                new int[]
//                );

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainSQLite.this, SaveToMain.class));
            }
        });

        registerForContextMenu(lv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.content_ubah, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if(item.getItemId() == R.id.del){
            Toast.makeText(getApplicationContext(), "Hai yo", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

}
