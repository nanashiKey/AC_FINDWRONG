package irfan.module.androidcomplete.AllData;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefsManager {
    SharedPreferences prefs;
    Context context;

    private static PrefsManager instance;

    public static PrefsManager sharedInstance(Context context){
        if(instance == null){
            instance = new PrefsManager(context);
        }
        return instance;
    }

    private PrefsManager(Context context){
        this.context = context;
        this.prefs = context.getSharedPreferences("LATIHAN", Context.MODE_PRIVATE);
    }

    public void setStatus(boolean status){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("LOGINSTAT", status);
        editor.apply();
    }

    public boolean getStatus(){
        return prefs.getBoolean("LOGINSTAT", false);
    }
}
