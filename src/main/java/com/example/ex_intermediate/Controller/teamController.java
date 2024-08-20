package com.example.ex_intermediate.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ex_intermediate.Domain.Team;
import com.example.ex_intermediate.Service.teamService;

/**
 * 野球チームのコントローラクラス
 */
@Controller
@RequestMapping("/team")
public class teamController {
    @Autowired
    private teamService teamservice;

    /**
     * 野球チームの一覧を表示する
     * @param model 
     * @return list.html
     */
    @GetMapping("/showList")
    public String showList(Model model){
        model.addAttribute("teamList", teamservice.showList());
        return "list";
    }

    /**
     * 
     * 
     */
    @GetMapping("/showDetail")
    public String showDetail(Integer id,Model model){
        Team team = teamservice.findId(id);
        model.addAttribute("team", team);
        return "detail";
    }


}
