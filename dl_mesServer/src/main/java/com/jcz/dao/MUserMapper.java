package com.jcz.dao;

import com.jcz.entity.Item;
import com.jcz.entity.MUser;

public interface MUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(MUser record);

    int insertSelective(MUser record);

    MUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MUser record);

    int updateByPrimaryKey(MUser record);

    int selectShipper(String name);
    int insertShipper(String name);

    int insertItems( Item item);
     int checkItem(Item item);
     String getUnitByName(String name);
}