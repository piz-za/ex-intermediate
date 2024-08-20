package com.example.ex_intermediate.Repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.ex_intermediate.Domain.Hotel;

/**
 * ホテルのリポジトリクラス
 */
@Repository
public class HotelRepository {
    
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Hotel> HOTEL_ROW_MAPPER
    = (rs,i) ->{
        Hotel hotel =new Hotel();
        hotel.setHotel_name(rs.getString("hotel_name"));
        hotel.setNearest_station(rs.getString("nearest_station"));
        hotel.setPrice(rs.getInt("price"));
        return hotel;
    };


    /**
     * ホテルの検索メソッド
     * @param price 入力金額
     * @return ホテル情報が格納されたリスト
     */
    public List<Hotel> findHotels(Integer price,String sql){
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("price", price);
        
        List<Hotel> hotels = template.query(sql, param, HOTEL_ROW_MAPPER);
        return hotels;   
    }
}
