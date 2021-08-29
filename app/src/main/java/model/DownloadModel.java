package model;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "downloadnewstb")
public class DownloadModel {
    @NonNull
    @PrimaryKey
    String idDownload;
    @Embedded
    Article articleDownload;

//    @Embedded
//    public Source source;
    String timeDownload;

    public DownloadModel(String idDownload, Article articleDownload, String timeDownload) {
        this.idDownload = idDownload;
        this.articleDownload = articleDownload;
        this.timeDownload = timeDownload;
    }

    public String getIdDownload() {
        return idDownload;
    }

    public void setIdDownload(String idDownload) {
        this.idDownload = idDownload;
    }

    public Article getArticleDownload() {
        return articleDownload;
    }

    public void setArticleDownload(Article articleDownload) {
        this.articleDownload = articleDownload;
    }

    public String getTimeDownload() {
        return timeDownload;
    }

    public void setTimeDownload(String timeDownload) {
        this.timeDownload = timeDownload;
    }
}
