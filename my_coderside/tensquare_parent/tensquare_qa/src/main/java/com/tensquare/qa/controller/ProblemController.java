package com.tensquare.qa.controller;

import com.tensquare.common.entity.PageResult;
import com.tensquare.common.entity.Result;
import com.tensquare.common.entity.StatusCode;
import com.tensquare.qa.pojo.entity.Problem;
import com.tensquare.qa.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author root
 */
@RestController
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @GetMapping("/newlist/{labelid}/{page}/{size}")
    public Result findNewListByLabelId(@PathVariable String labelId, @PathVariable int page, @PathVariable int size){
        Page<Problem> pagelist = problemService.findNewListByLabelId(labelId,page,size);
        PageResult<Problem> pageResult = new PageResult<>(pagelist.getTotalElements(), pagelist.getContent());
        return new Result(true, StatusCode.OK,"查询成功", pageResult);
    }
}
