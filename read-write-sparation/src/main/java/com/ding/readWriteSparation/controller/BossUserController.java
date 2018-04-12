package com.ding.readWriteSparation.controller;

import com.ding.readWriteSparation.base.ResultBean;
import com.ding.readWriteSparation.model.entity.BossUser;
import com.ding.readWriteSparation.service.BossUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	//获取用户详情
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ResultBean update(@PathVariable Integer id) {
		ResultBean response = new ResultBean();

		BossUser user = new BossUser();
		user.setId(1);
		user.setSalt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));

		bossUserService.updateByPrimaryKeySelective(user);

		return response.success();
	}

}
