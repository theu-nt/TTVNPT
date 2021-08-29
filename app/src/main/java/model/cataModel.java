package model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;


@Entity(tableName = "loaiDMtb")
public class cataModel implements Serializable {
    @PrimaryKey
    @NonNull
    String tenDMuc;
    int anhDMuc;
    //String url;

//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }

    public cataModel(String tenDMuc, int anhDMuc) {
        this.tenDMuc = tenDMuc;
        this.anhDMuc = anhDMuc;
       // this.url = url;
    }



    public String getTenDMuc() {
        return tenDMuc;
    }

    public void setTenDMuc(String tenDMuc) {
        this.tenDMuc = tenDMuc;
    }

    public int getAnhDMuc() {
        return anhDMuc;
    }

    public void setAnhDMuc(int anhDMuc) {
        this.anhDMuc = anhDMuc;
    }
}
