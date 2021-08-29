package model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class website implements Parcelable {
    public String title,link,hinhanh,pdate,description,chanel;

    protected website(Parcel in) {
        title = in.readString();
        link = in.readString();
        hinhanh = in.readString();
        pdate = in.readString();
        description = in.readString();
    }

    public website(String title, String link, String hinhanh, String pdate, String description, String chanel) {
        this.title = title;
        this.link = link;
        this.hinhanh = hinhanh;
        this.pdate = pdate;
        this.description = description;
        this.chanel = chanel;
    }

    public String getChanel() {
        return chanel;
    }

    public void setChanel(String chanel) {
        this.chanel = chanel;
    }

    public static final Creator<website> CREATOR = new Creator<website>() {
        @Override
        public website createFromParcel(Parcel in) {
            return new website(in);
        }

        @Override
        public website[] newArray(int size) {
            return new website[size];
        }
    };

    public String getPdate() {
        return pdate;
    }
public website(){}
    public website(String title, String link, String hinhanh) {
        this.title = title;
        this.link = link;
        this.hinhanh = hinhanh;

    }

    public website(String title, String link, String hinhanh, String pdate, String description) {
        this.title = title;
        this.link = link;
        this.hinhanh = hinhanh;
        this.pdate = pdate;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(link);
        dest.writeString(hinhanh);
        dest.writeString(pdate);
        dest.writeString(description);
    }
}
