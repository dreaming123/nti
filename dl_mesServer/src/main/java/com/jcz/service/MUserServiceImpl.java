package com.jcz.service;

import com.jcz.dao.MUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service//("muserService")
public class MUserServiceImpl implements MUserServiceI {
    public  void service(){

    }

    //    @Autowired
//    private MUserMapper muserMapper;
//
//    public MUserMapper getMuserMapper() {
//        return muserMapper;
//    }
//
//
//    public void setMuserMapper(MUserMapper muserMapper) {
//        this.muserMapper = muserMapper;
//    }

//    @Override
//    public List<MUser> getAll() {
//
//        return muserMapper.getAll();
//    }

//    @Override
//    public int insert(MUser muser) {
//
//        return muserMapper.insert(muser);
//    }
//
//    @Override
//    public int update(MUser muser) {
//
//        return muserMapper.updateByPrimaryKey(muser);
//    }
//
//    @Override
//    public int delete(String id) {
//
//        return muserMapper.deleteByPrimaryKey(id);
//    }
//
//    @Override
//    public MUser selectByPrimaryKey(String id) {
//
//        return muserMapper.selectByPrimaryKey(id);
//    }

}
