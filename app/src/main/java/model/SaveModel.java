package model;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "savenewstb")

public class SaveModel {
    @NonNull
    @PrimaryKey
    String idSave;
    @Embedded
    Article articleSave;
    String timeSave;
    //    @Embedded
//    public Source source;


    public SaveModel(String idSave, Article articleSave, String timeSave) {
        this.idSave = idSave;
        this.articleSave = articleSave;
        this.timeSave = timeSave;
    }

    @NonNull
    public String getIdSave() {
        return idSave;
    }

    public void setIdSave(@NonNull String idSave) {
        this.idSave = idSave;
    }

    public Article getArticleSave() {
        return articleSave;
    }

    public void setArticleSave(Article articleSave) {
        this.articleSave = articleSave;
    }

    public String getTimeSave() {
        return timeSave;
    }

    public void setTimeSave(String timeSave) {
        this.timeSave = timeSave;
    }
}
