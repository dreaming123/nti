package com.jcz.controller;


import com.github.pagehelper.PageHelper;
import com.jcz.dao.MUserMapper;
import com.jcz.model.Rest_M;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Test {
   // @Autowired
   // private MUserServiceI muserService;

    @Autowired
    public MUserMapper mum;


    //上传基本数据
    @RequestMapping("/upload")
    @ResponseBody
    public String test() {
        System.out.print("执行了test");
        return "1539";
    }

    @Transactional
    @RequestMapping(value="/listUser")
    @ResponseBody
    public Object listUser(HttpServletRequest request) throws Exception {
        PageHelper.startPage(1,2);
       // List<MUser> list = muserService.getAll();
        //request.setAttribute("userlist", list);
//         for(int i=4;i<=10;i++){
//            MUser us = new MUser(i+"", i+"", i+"3", i+"3");
//             mum.insertSelective(us);

           // if (1 == 1)
               // throw new IOException("抛出异常");
    //}
       ;

          return  1;
    }


  @GetMapping("/test_thymeleaf")
  @ResponseBody
     public ModelAndView  thy(){
      ModelAndView mv=new ModelAndView();
      Rest_M rest= new Rest_M<String>();
      List data=new ArrayList<String>();
       data.add("成功");
      data.add("成功");
      data.add("成功");

       rest.setData(data);

      mv.addObject("res",rest);
      mv.setViewName("addItems");

    return  mv;


     }


    @RequestMapping("/tt")
    @ResponseBody
    public String test1() {
        System.out.print("执行了test");
        return "123321";
    }


}
