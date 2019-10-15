package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelSercice;
import com.tensquare.common.entity.PageResult;
import com.tensquare.common.entity.Result;
import com.tensquare.common.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author root
 */
@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelSercice labelService;

    /**
     * 查询全部列表
     * @return
     */

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",labelService.findAll());
    }

    /**
     * 根据id查询标签
     * @param labelId
     * @return
     */
    @RequestMapping(value = "/{labelId}", method = RequestMethod.GET )
    public Result findById(@PathVariable String labelId){
        return new Result(true, StatusCode.OK,"查询成功",labelService.findById(labelId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label){
        labelService.save(label);
        return new Result(true, StatusCode.OK,"添加成功");
    }

    @RequestMapping(value = "/{labelId}" ,method = RequestMethod.PUT)
    public Result update(@PathVariable String labelId , @RequestBody Label label){
        label.setId(labelId);
        labelService.update(label);
        return new Result(true, StatusCode.OK,"更新成功");
    }

    @RequestMapping(value = "/{labelId}" , method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String labelId){
        labelService.deleteById(labelId);
        return new Result(true, StatusCode.OK,"删除成功");
    }

    /**
     * 根据条件查询
     * @param label
     * @return
     */
    @PostMapping("/search")
    public Result findSearch(@RequestBody Label label){
        List<Label> list = labelService.findSearch(label);
        return new Result(true,StatusCode.OK,"查询成功", list);
    }

    /**
     * 条件+分页查询
     * @param label
     * @param page
     * @param size
     * @return
     */
    @PostMapping("/search/{page}/{size}")
    public Result pageQuery(@RequestBody Label label ,@PathVariable int page,
                             @PathVariable int size){
        Page result = labelService.pageQuery(label,page,size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<>(
                result.getTotalElements(),result.getContent()));
    }

}
