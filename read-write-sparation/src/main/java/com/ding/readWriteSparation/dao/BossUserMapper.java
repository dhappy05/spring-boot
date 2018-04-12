package com.ding.readWriteSparation.dao;

import com.ding.readWriteSparation.model.entity.BossUser;
import com.ding.readWriteSparation.model.criteria.BossUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BossUserMapper {
    int countByExample(BossUserExample example);

    int deleteByExample(BossUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BossUser record);

    int insertSelective(BossUser record);

    List<BossUser> selectByExample(BossUserExample example);

    BossUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BossUser record, @Param("example") BossUserExample example);

    int updateByExample(@Param("record") BossUser record, @Param("example") BossUserExample example);

    int updateByPrimaryKeySelective(BossUser record);

    int updateByPrimaryKey(BossUser record);
}