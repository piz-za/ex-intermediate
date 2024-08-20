package com.example.ex_intermediate.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.ex_intermediate.Domain.Hotel;
import com.example.ex_intermediate.Repository.HotelRepository;

/**
 * ホテルのサービスクラス
 */
@Service
@Transactional
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    /**
     * ホテルの検索メソッド
     * @param price 入力金額
     * @return ホテル情報が格納されたリスト
     */
    public List<Hotel> hotelSerch(Integer price){

        return hotelRepository.findHotels(price,buildlQuery(price));
    }

    /**
     * ホテルの検索クエリ構築
     * @param price 入力金額
     * @return 検索クエリ
     */
    public String buildlQuery(Integer price) {
        StringBuilder sql = new StringBuilder("SELECT hotel_name, nearest_station, price FROM hotels WHERE 1=1");

        if (price != null) {
            sql.append(" AND price <= :price");
        }

        sql.append(" ORDER BY price DESC");
        return sql.toString();
    }
}
