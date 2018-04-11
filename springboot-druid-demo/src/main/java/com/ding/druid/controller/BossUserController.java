package com.ding.druid.controller;

import com.ding.druid.base.ResultBean;
import com.ding.druid.model.entity.BossUser;
import com.ding.druid.service.BossUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by ding on 2018/1/3.
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class BossUserController {
	@Resource
	private BossUserService bossUserService;

	//获取用户详情
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public ResultBean detail(@PathVariable Integer id) {
		ResultBean response = new ResultBean();

		BossUser result = bossUserService.selectByPrimaryKey(id);

		return response.success(result);
	}

}
