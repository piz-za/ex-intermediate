package com.example.ex_intermediate.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.ex_intermediate.Domain.Hotel;
import com.example.ex_intermediate.Service.HotelService;

/**
 * ホテルのコントローラクラス
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {
    
    @Autowired
    private HotelService hotelService;

    /**
     * ホテル検索画面の表示
     * @return hotel-serch.html
     */
    @RequestMapping("")
    public String index(){
        return "hotel-serch";
    }

    /**
     * ホテル検索結果を表示
     * @return hotel-serch.html
     */
    @PostMapping("")
    public String show(Integer price,Model model){
        List<Hotel> hotels=hotelService.hotelSerch(price);
        model.addAttribute("hotels", hotels);
        model.addAttribute("price", price);
        return "hotel-serch";
    } 
}

