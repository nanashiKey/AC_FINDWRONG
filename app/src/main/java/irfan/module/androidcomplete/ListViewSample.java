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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import irfan.module.androidcomplete.AllData.PrefsManager;

public class ListViewSample extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_list);
        ListView lv = findViewById(R.id.datalist);
        List<String> data = new ArrayList<>();
        data.add("data ke 1");
        data.add("data ke 2");
        data.add("data ke 3");
        data.add("data ke 4");
        data.add("data ke 5");
        data.add("data ke 6");
        data.add("data ke 7");
        data.add("data ke 8");
        data.add("data ke 9");
        data.add("data ke 10");
        ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        lv.setAdapter(aa);

        registerForContextMenu(lv);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "posisi ke - "+ (i+1), Toast.LENGTH_SHORT).show();
                if(i == 5){
                    Intent a = new Intent(ListViewSample.this, Tombol.class);
                    startActivity(a);
                }else if(i == 0){
                    Intent a = new Intent(ListViewSample.this, OnlyPopMenu.class);
                    startActivity(a);
                }
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.latihan_menu2, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setting_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:{
                PrefsManager.sharedInstance(getApplicationContext()).setStatus(false);
                startActivity(new Intent(ListViewSample.this, FindTheWrong.class));
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
