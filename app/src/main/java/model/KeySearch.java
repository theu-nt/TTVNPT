package model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName ="keysearchtb")
public class KeySearch {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    int id;

    String key;
    long timeSearch;

    public long getTimeSearch() {
        return timeSearch;
    }

    public void setTimeSearch(long timeSearch) {
        this.timeSearch = timeSearch;
    }
@Ignore
    public KeySearch( String key, long timeSearch) {
        //this.id = id;
        this.key = key;
        this.timeSearch = timeSearch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public KeySearch(int id, String key) {
        this.id = id;
        this.key = key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
