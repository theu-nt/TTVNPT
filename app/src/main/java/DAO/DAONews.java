package DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import model.DownloadModel;
import model.FavoritesModel;
import model.HistoryModel;
import model.KeySearch;
import model.SaveModel;
import model.cataModel;

@Dao
public interface DAONews {
    @Insert
    void insertHistory(HistoryModel historyModel);

    @Query("SELECT * FROM historynewstb")
    List<HistoryModel> getListHistory();

    @Query("SELECT * FROM historynewstb WHERE timeHistory= :time")
    List<HistoryModel> getListHistoryTime(String time);

    @Query("SELECT DISTINCT timeHistory FROM historynewstb")
    List<String> getTimehis();

    @Query("delete from historynewstb where timeHistory= :time")
    void deleteAllHis(String time);

    @Query("delete from historynewstb where timeHistory= :timexem and idHistory= :id")
    void deletelsxem(String timexem,String id);
///////////////////
    @Insert
    void insertFavorite(FavoritesModel favoritesModel);

    @Query("SELECT * FROM favoritenewstb")
    List<FavoritesModel> getListFavorite();

    @Query("SELECT DISTINCT timeFavorite FROM favoritenewstb")
    List<String> getTimeFav();

    @Query("SELECT * FROM favoritenewstb WHERE timeFavorite= :time")
    List<FavoritesModel> getListFavoriteTime(String time);

    @Query("delete from favoritenewstb where timeFavorite= :timethich and idFavorite= :id")
    void deletelsthich(String timethich,String id);


    @Query("delete from favoritenewstb where timeFavorite= :time")
    void deleteAllFav(String time);
    //////////////////

    @Insert
    void insertDownload(DownloadModel downloadModel);

    @Query("SELECT * FROM downloadnewstb")
    List<DownloadModel> getListDownload();

    @Query("SELECT DISTINCT timeDownload FROM downloadnewstb")
    List<String> getTimeDown();

    @Query("SELECT * FROM downloadnewstb WHERE timeDownload= :time")
    List<DownloadModel> getListDownloadTime(String time);

    @Query("delete from downloadnewstb where timeDownload= :time")
    void deleteAllDown(String time);

    @Query("delete from downloadnewstb where timeDownload= :timetai and idDownload= :id")
    void deletelstai(String timetai,String id);
/////////////
    @Insert
    void insertSave(SaveModel saveModel);

    @Query("SELECT * FROM savenewstb")
    List<SaveModel> getListSave();

    @Query("SELECT DISTINCT timeSave FROM savenewstb")
    List<String> getTimeSave();

    @Query("SELECT * FROM savenewstb WHERE timeSave= :time")
    List<SaveModel> getListSaveTime(String time);

    @Query("delete from savenewstb where timeSave= :time")
    void deleteAllSave(String time);

    @Query("delete from savenewstb where timeSave= :timeluu and idSave= :id")
    void deletelsluu(String timeluu,String id);
    ////////////////////////
    @Insert
    void insertKeySearch(KeySearch keySearch);



    @Query("SELECT * FROM keysearchtb ORDER BY timeSearch DESC LIMIT 12")
    List<KeySearch> getListKeySearch();

    @Query("SELECT * FROM keysearchtb where `key`= :keyword")
    List<KeySearch> checkKeySearch(String keyword);


    @Query("DELETE FROM keysearchtb where `key`= :keySearch")
    void deleteKeySearch(String keySearch);

    @Delete
    void deleteKeySearch(KeySearch keySearch);
////////////////////////////////////////////
    @Insert
    void insertDM(cataModel cataModel);

    @Query("SELECT * FROM loaiDMtb")
    List<cataModel> getListDM();

    @Delete
    void deleteDM(cataModel cataModel);
//'%' || :tendm || '%'"
    @Query("SELECT * FROM loaiDMtb WHERE tenDMuc LIKE :tendm")
    List<cataModel> searchDM(String tendm);

    @Query("SELECT * FROM loaiDMtb where tenDMuc= :tendanhmuc")
    List<cataModel> checkDM(String tendanhmuc);





}
