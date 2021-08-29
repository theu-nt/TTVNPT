package DAO;

import android.content.Context;

public class DataLocalManager {
    private static final String FirstInstall="FirstInstall";
    private static DataLocalManager instance;
    private MySharedPreference mySharedPreference;

    public static void init(Context context){
        instance=new DataLocalManager();
        instance.mySharedPreference=new MySharedPreference(context);
    }
    public static DataLocalManager getInstance(){
        if(instance==null){
            instance=new DataLocalManager();
        }
        return instance;
    }

    public static void setFirstInstall(String isFirst){
        DataLocalManager.getInstance().mySharedPreference.putStringData(FirstInstall,isFirst);
    }
    public static String getFirstInstall(){
        return DataLocalManager.getInstance().mySharedPreference.getStringData(FirstInstall);

    }
}
