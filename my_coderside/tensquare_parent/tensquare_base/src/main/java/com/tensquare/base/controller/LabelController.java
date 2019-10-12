package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelSercice;
import com.tensquare.common.entity.Result;
import com.tensquare.common.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author root
 */
@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelSercice labelSercice;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",labelSercice.findAll());
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.GET )
    public Result findById(@PathVariable String labelId){
        return new Result(true, StatusCode.OK,"查询成功",labelSercice.findById(labelId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label){
        labelSercice.save(label);
        return new Result(true, StatusCode.OK,"添加成功");
    }

    @RequestMapping(value = "/{labelId}" ,method = RequestMethod.PUT)
    public Result update(@PathVariable String labelId , @RequestBody Label label){
        label.setId(labelId);
        labelSercice.update(label);
        return new Result(true, StatusCode.OK,"更新成功");
    }

    @RequestMapping(value = "/{labelId}" , method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String labelId){
        labelSercice.deleteById(labelId);
        return new Result(true, StatusCode.OK,"删除成功");
    }
}
