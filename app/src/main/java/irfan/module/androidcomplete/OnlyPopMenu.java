package irfan.module.androidcomplete;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;

public class OnlyPopMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.for_popup_in);
        final Button btn = findViewById(R.id.popupin);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu pop = new PopupMenu(OnlyPopMenu.this, btn);
                pop.getMenuInflater().inflate(R.menu.pop_up_in, pop.getMenu());
                pop.show();
            }
        });

    }
}
