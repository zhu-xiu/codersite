package com.tensquare.article.controller;

import com.tensquare.article.service.ArticleService;
import com.tensquare.common.entity.Result;
import com.tensquare.common.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author root
 */

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/examine/{id}")
    public Result examine(@PathVariable String id){

        articleService.examine(id);
        return new Result(true, StatusCode.OK, "审核成功");
    }
}
