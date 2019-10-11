package com.edm.base.controller;

import com.edm.base.pojo.Label;
import com.edm.base.service.LabelService;
import com.edm.common.entity.Result;
import com.edm.common.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChinHeng-Chu
 * @Description
 * @create 2019-10-10 14:39
 */
@CrossOrigin
@RestController
@RequestMapping("/label")
public class LabelController {

	@Autowired
	private LabelService labelService;

	/**
	 * 查询全部列表
	 * @return
	 */
	@GetMapping
	public Result findAll(){
		return new Result(true, StatusCode.OK,"查询成功",
				labelService.findAll());
	}

	/**
	 * 根据ID查询标签
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Result findById(@PathVariable String id){
		return new Result(true,StatusCode.OK,"查询成功",
				labelService.findById(id));
	}

	/**
	 * 增加标签
	 * @param label
	 * @return
	 */
	@PostMapping
	public Result add(@RequestBody Label label){
		labelService.add(label);
		return new Result(true,StatusCode.OK,"增加成功");
	}

	/**
	 * 修改标签
	 * @param label
	 * @param id
	 * @return
	 */
	@PutMapping("/{id}")
	public Result update(@RequestBody Label label,@PathVariable String id){
		label.setId(id);
		labelService.update(label);
		return new Result(true,StatusCode.OK,"修改成功");
	}

	/**
	 * 删除标签
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public Result deleteById(@PathVariable String id){
		labelService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}


}

