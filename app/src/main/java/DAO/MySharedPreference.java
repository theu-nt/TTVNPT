package DAO;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreference {
    private static final String mSharedPreference="mSharedPreference";

    private Context context;

    public MySharedPreference(Context context) {
        this.context = context;
    }

    public void putStringData(String key,String tinh){
        SharedPreferences sharedPreferences=context.getSharedPreferences(mSharedPreference,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(key,tinh);
        editor.apply();
    }
    public String getStringData(String key){
        SharedPreferences sharedPreferences=context.getSharedPreferences(mSharedPreference,Context.MODE_PRIVATE);
        return sharedPreferences.getString(key,null);

    }
}
