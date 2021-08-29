 package DAO;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Embedded;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import model.Article;
import model.DownloadModel;
import model.FavoritesModel;
import model.HistoryModel;
import model.KeySearch;
import model.SaveModel;
import model.cataModel;

 @Database(version = 1,entities = {HistoryModel.class,FavoritesModel.class,DownloadModel.class, SaveModel.class, KeySearch.class, cataModel.class})
public abstract class DatabaseNews extends RoomDatabase {
    private static final String databaseName="news.db";
    private static DatabaseNews instance;
    public static synchronized DatabaseNews getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),DatabaseNews.class,databaseName)
                    .allowMainThreadQueries().build();
        }
        return instance;
    }
    //addMigrations(MIGRATION_1_2,MIGRATION_2_3)
//    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
//        @Override
//        public void migrate(SupportSQLiteDatabase database) {
//
//
//           // String author, String title, String description, String url, String urlToImage, String ,String conten
////            database.execSQL("CREATE TABLE IF NOT EXISTS `savenewstb` (`idSave` TEXT NOT NULL, `author` TEXT, `title` TEXT, `description` TEXT , `url` TEXT, `urlToImage` " +
////                    "TEXT, `publishedAt` TEXT, `content` TEXT, PRIMARY KEY(`idSave`))");
//                  //  + "`key` TEXT, `timeSave` TEXT, PRIMARY KEY(`id`))");
//            database.execSQL("CREATE TABLE IF NOT EXISTS `keysearchtb` (`id` INTEGER NOT NULL , "
//                    + "`key` TEXT, `timeSearch` TEXT, PRIMARY KEY(`id`))");
//            // Since we didn't alter the table, there's nothing else to do here.
//        }
//    };

//    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
//        @Override
//        public void migrate(SupportSQLiteDatabase database) {
//
//
//            // String author, String title, String description, String url, String urlToImage, String ,String conten
//            database.execSQL("CREATE TABLE IF NOT EXISTS `savenewstb` (`idSave` TEXT NOT NULL, `author` TEXT, `title` TEXT, `description` TEXT , `url` TEXT, `urlToImage` " +
//                    "TEXT, `publishedAt` TEXT, `content` TEXT, PRIMARY KEY(`idSave`))");
//            //  + "`key` TEXT, `timeSave` TEXT, PRIMARY KEY(`id`))");
////            database.execSQL("CREATE TABLE IF NOT EXISTS `keysearchtb` (`id` INTEGER NOT NULL , "
////                    + "`key` TEXT, `timeSearch` TEXT, PRIMARY KEY(`id`))");
//            // Since we didn't alter the table, there's nothing else to do here.
//        }
//    };
    public abstract DAONews daoNews();

}
