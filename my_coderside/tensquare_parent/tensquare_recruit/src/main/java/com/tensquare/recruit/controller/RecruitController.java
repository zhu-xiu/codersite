package com.tensquare.recruit.controller;

import com.tensquare.common.entity.Result;
import com.tensquare.common.entity.StatusCode;
import com.tensquare.recruit.pojo.entity.Recruit;
import com.tensquare.recruit.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author root
 */
@RestController
@CrossOrigin
@RequestMapping("/recruit")
public class RecruitController {

    @Autowired
    private RecruitService recruitService;

    @GetMapping("/search/recommend")
    public Result recomment(){
        List<Recruit> list = recruitService.findTop4ByStateOrderByCreatetimeDesc("2");
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    @GetMapping("/search/newlist")
    public Result newList(){
        List<Recruit> list = recruitService.newList();
        return new Result(true,StatusCode.OK,"查询成功", list);
    }
}
