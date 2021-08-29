package model;

import java.util.List;

public class diaphuong {
    List<tinhModel> LtsItem;
    int TotalDoanhNghiep;

    public diaphuong(List<tinhModel> ltsItem, int totalDoanhNghiep) {
        LtsItem = ltsItem;
        TotalDoanhNghiep = totalDoanhNghiep;
    }

    public List<tinhModel> getLtsItem() {
        return LtsItem;
    }

    public void setLtsItem(List<tinhModel> ltsItem) {
        LtsItem = ltsItem;
    }

    public int getTotalDoanhNghiep() {
        return TotalDoanhNghiep;
    }

    public void setTotalDoanhNghiep(int totalDoanhNghiep) {
        TotalDoanhNghiep = totalDoanhNghiep;
    }
}
