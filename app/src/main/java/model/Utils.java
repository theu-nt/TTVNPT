package model;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.example.ttvnpt.R;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Utils {

    //public static ArrayList<cataModel> arr=new ArrayList<>();

    public static ArrayList<cataModel> getListDM() {
        ArrayList<cataModel> arr=new ArrayList<>();
        arr.add(new cataModel("Xu hướng",R.drawable.danhmuc));
        arr.add(new cataModel("Xã hội",R.drawable.danhmuc));
        arr.add(new cataModel("Sức Khỏe",R.drawable.danhmuc));
        arr.add(new cataModel("Văn hóa",R.drawable.danhmuc));
        arr.add(new cataModel("Giải trí",R.drawable.danhmuc));
        arr.add(new cataModel("Giáo dục",R.drawable.danhmuc));
        arr.add(new cataModel("Thể thao",R.drawable.danhmuc));
        arr.add(new cataModel("Tâm sự",R.drawable.danhmuc));
        arr.add(new cataModel("Truyện đọc",R.drawable.danhmuc));
        arr.add(new cataModel("Bảng tin",R.drawable.danhmuc));
        arr.add(new cataModel("Bảng tin",R.drawable.danhmuc));
        arr.add(new cataModel("Bảng tin",R.drawable.danhmuc));
        arr.add(new cataModel("Bảng tin",R.drawable.danhmuc));
        return arr;
        //this.arr = arr;
    }


    public static ColorDrawable[] vibrantLightColorList =
            {
                    new ColorDrawable(Color.parseColor("#ffeead")),
                    new ColorDrawable(Color.parseColor("#93cfb3")),
                    new ColorDrawable(Color.parseColor("#fd7a7a")),
                    new ColorDrawable(Color.parseColor("#faca5f")),
                    new ColorDrawable(Color.parseColor("#1ba798")),
                    new ColorDrawable(Color.parseColor("#6aa9ae")),
                    new ColorDrawable(Color.parseColor("#ffbf27")),
                    new ColorDrawable(Color.parseColor("#d93947"))
            };

    public static ColorDrawable getRandomDrawbleColor() {
        int idx = new Random().nextInt(vibrantLightColorList.length);
        return vibrantLightColorList[idx];
    }
public static String currentDate(){
    Calendar calendar=Calendar.getInstance();
    SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy", Locale.CHINA);
    return dateFormat.format(calendar.getTime());

}

    public static String Yesterday(){
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy", Locale.CHINA);

        calendar.setTime(Calendar.getInstance().getTime());
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        String yesterday=dateFormat.format(calendar.getTime());
        return yesterday;

    }
    public static String DateToTimeFormat(String oldstringDate){
        PrettyTime p = new PrettyTime(new Locale(getCountry()));
        String isTime = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'",
                    Locale.ENGLISH);
            Date date = sdf.parse(oldstringDate);
            isTime = p.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return isTime;
    }

    public static String DateFormat(String oldstringDate){
        String newDate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("E, d MMM yyyy", new Locale(getCountry()));
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(oldstringDate);
            newDate = dateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            newDate = oldstringDate;
        }

        return newDate;
    }
    public static String getYear(String oldstringDate){
        String newDate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("E, d MMM yyyy", new Locale(getCountry()));
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(oldstringDate);
            newDate = dateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            newDate = oldstringDate;
        }

        return newDate;
    }

    public static String getCountry(){
        Locale locale = Locale.getDefault();
        String country = String.valueOf(locale.getCountry());
        return country.toLowerCase();
    }


}
