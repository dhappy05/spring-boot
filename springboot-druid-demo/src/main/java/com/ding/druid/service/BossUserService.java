package com.ding.druid.service;

import com.ding.druid.dao.BossUserMapper;
import com.ding.druid.model.criteria.BossUserExample;
import com.ding.druid.model.entity.BossUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ding on 2018/4/10.
 */
@Service
public class BossUserService {
	@Resource
	private BossUserMapper dao;

	public int countByExample(BossUserExample example){
		return dao.countByExample(example);
	}

	public int deleteByExample(BossUserExample example){
		return dao.deleteByExample(example);
	}

	public int deleteByPrimaryKey(Integer id){
		return dao.deleteByPrimaryKey(id);
	}

	public int insert(BossUser record){
		return dao.insert(record);
	}

	public int insertSelective(BossUser record){
		dao.insertSelective(record);
		return record.getId();
	}

	public List<BossUser> selectByExample(BossUserExample example){
		return dao.selectByExample(example);
	}

	public BossUser selectByPrimaryKey(Integer id){
		return dao.selectByPrimaryKey(id);
	}

	public int updateByExampleSelective(BossUser record, BossUserExample example){
		return dao.updateByExampleSelective(record, example);
	}

	public int updateByExample(BossUser record, BossUserExample example){
		return dao.updateByExample(record, example);
	}

	public int updateByPrimaryKeySelective(BossUser record){
		return dao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(BossUser record){
		return dao.updateByPrimaryKey(record);
	}
}
