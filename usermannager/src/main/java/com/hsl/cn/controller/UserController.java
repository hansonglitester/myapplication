package com.hsl.cn.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hsl.cn.config.HibernateProxyTypeAdapter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hsl.cn.dao.UserDao;
import com.hsl.cn.pojo.User;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@Api(value = "用户管理",description = "实现用户的增删该查的操作")
public class UserController {
    private Logger log= LoggerFactory.getLogger(UserController.class);

    Gson gson=new GsonBuilder().registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY).create();

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "login接口",httpMethod = "POST")
    public String login(HttpServletResponse response,@RequestParam String mobile,@RequestParam String pwd){

        List<User> users=userDao.findByMobileAndPwd(mobile,pwd);
        Map<String,Object> result=new HashMap<String,Object>();
        if(users.size()>0){
            //判断用户的状态
            User user =users.get(0);
            if (user.getStatus()==0){
                Cookie cookie = new Cookie("login","true");
                response.addCookie(cookie);
                result.put("rsp_code","0000");
                result.put("rsp_msg","成功");
                result.put("user",users.get(0));
            }else{
                result.put("rsp_code","1002");
                result.put("rsp_msg","用户账号状态异常,禁止登陆");
            }

        }else {
            result.put("rsp_code","1001");
            result.put("rsp_msg","用户账号或密码不对");
        }
        String result1=gson.toJson(result);
        log.info(result1);
        return result1;
    }



    @RequestMapping(value = "saveUser",method = RequestMethod.POST)
    @ApiOperation(value = "添加/修改用户接口",notes="传入需要添加/修改的用户信息",httpMethod = "POST")
    public String  addUser(HttpServletRequest request,@RequestBody User user){
        Boolean flag = verifyCookies(request);
        Map<String,Object> result=new HashMap<String,Object>();
        try {
            //判断是否登录
            if(flag) {
                //判断注册用户的手机号是否已经注册过
                List <User> users = userDao.findByMobile(user.getMobile());
                if (users.size() > 0) {
                    userDao.save(user);
                    result.put("rsp_code", "1003");
                    result.put("rsp_msg", "用户已存在");
                }else {
                    userDao.save(user);
                    result.put("rsp_code", "0000");
                    result.put("rsp_msg", "成功");
                    result.put("data",user);
                }
            }else{
                result.put("rsp_code","1000");
                result.put("rsp_msg","用户未登陆");
            }

        }catch (Exception e){
            result.put("rsp_code","9999");
            result.put("msg","数据异常，注意检查参数");
        }

        return  gson.toJson(result);
    }



    @RequestMapping(value = "getUserDetail",method = RequestMethod.GET)
    @ApiOperation(value = "用户详情接口",notes = "通过id查询用户的详细信息",httpMethod = "GET")
    public String getUserDetail(HttpServletRequest request, @RequestParam(value="user_id",required = true) Integer id){

        Boolean flag = verifyCookies(request);
        Map<String,Object> result=new HashMap <>();

        if(flag){

            User user =userDao.getOne(id);
            result.put("rsp_code","0000");
            result.put("rsp_msg","成功");
            result.put("data",user);
        }else{
            result.put("rsp_code","1000");
            result.put("rsp_msg","用户未登陆");
        }
        return gson.toJson(result);
    }


    @RequestMapping(value = "getUserListByMobile",method = RequestMethod.POST)
    @ApiOperation(value = "查询用户",notes="通过用户的name来查询用户",httpMethod = "GET")
    public String getUserListByName(HttpServletRequest request, @RequestBody User user){

        Boolean flag = verifyCookies(request);
        Map<String,Object> result=new HashMap <>();

        if(flag){
            List <User> users =new ArrayList <>();
            users=userDao.findByMobileAndStatus(user.getMobile(),0);
            result.put("rsp_code","0000");
            result.put("rsp_msg","成功");
            result.put("data",users);
        }else{
            result.put("rsp_code","1000");
            result.put("rsp_msg","用户未登陆");
        }
        return gson.toJson(result);
    }


    private Boolean verifyCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if(Objects.isNull(cookies)){
            log.info("cookies为空");
            return  false;
        }

        for(Cookie cookie:cookies){
            if(cookie.getName().equals("login") &&
                    cookie.getValue().equals("true")){
                log.info("cookies验证通过");
                return true;
            }
        }
        return false;
    }

}