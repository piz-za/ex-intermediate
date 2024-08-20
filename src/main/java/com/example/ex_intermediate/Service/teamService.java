package com.example.ex_intermediate.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.ex_intermediate.Domain.Team;
import com.example.ex_intermediate.Repository.teamRepository;

/**
 * 野球チームのサービスクラス
 */
@Service
@Transactional
public class teamService {
    @Autowired
    private teamRepository teamrepository;

    /**
     * 野球チームリストを作成するメソッド
     * @return 呼び出し元にリストを返す
     */
    public List<Team> showList(){
        return teamrepository.findAll();
    }

    /**
     * 野球チームの一件検索
     * @param id 野球チームのid
     * @return 野球チームの詳細情報
     */
    public Team findId(Integer id){
        return teamrepository.load(id);
    }
}
