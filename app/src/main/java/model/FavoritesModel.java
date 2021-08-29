package model;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favoritenewstb")
public class FavoritesModel {
    @NonNull
    @PrimaryKey
    String idFavorite;
    @Embedded
    Article articleFavorite;

//    @Embedded
//    public Source source;
String timeFavorite;

    public FavoritesModel(String idFavorite, Article articleFavorite, String timeFavorite) {
        this.idFavorite = idFavorite;
        this.articleFavorite = articleFavorite;
        this.timeFavorite = timeFavorite;
    }

    public String getIdFavorite() {
        return idFavorite;
    }

    public void setIdFavorite(String idFavorite) {
        this.idFavorite = idFavorite;
    }

    public Article getArticleFavorite() {
        return articleFavorite;
    }

    public void setArticleFavorite(Article articleFavorite) {
        this.articleFavorite = articleFavorite;
    }

    public String getTimeFavorite() {
        return timeFavorite;
    }

    public void setTimeFavorite(String timeFavorite) {
        this.timeFavorite = timeFavorite;
    }
}

