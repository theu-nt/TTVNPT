package model;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "historynewstb")
public class HistoryModel {
    @NonNull
    @PrimaryKey
    public String idHistory;
    @Embedded
    public Article articleHistory;
//    @Embedded
//    public Source source;
    public String timeHistory;

    public HistoryModel(String idHistory, Article articleHistory, String timeHistory) {
        this.idHistory = idHistory;
        this.articleHistory = articleHistory;
        this.timeHistory = timeHistory;
    }

    public String getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(String idHistory) {
        this.idHistory = idHistory;
    }

    public Article getArticleHistory() {
        return articleHistory;
    }

    public void setArticleHistory(Article articleHistory) {
        this.articleHistory = articleHistory;
    }

    public String getTimeHistory() {
        return timeHistory;
    }

    public void setTimeHistory(String timeHistory) {
        this.timeHistory = timeHistory;
    }
}
