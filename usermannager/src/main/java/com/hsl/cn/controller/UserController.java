package com.hsl.cn.controller;

import com.google.gson.Gson;
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
    private Gson gson=new Gson();
    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "login接口",httpMethod = "POST")
    public String login(HttpServletResponse response,@RequestBody User user){

        List<User> users=userDao.findByNameAndPwd(user.getName(),user.getPwd());
        Map<String,Object> result=new HashMap<String,Object>();
        if(users.size()==1){
            Cookie cookie = new Cookie("login","true");
            response.addCookie(cookie);

            result.put("msg","成功");
        }else {
            result.put("msg","用户名或密码不对");
        }
        return gson.toJson(result);
    }



    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    @ApiOperation(value = "添加/修改用户接口",notes="传入需要添加/修改的用户信息",httpMethod = "POST")
    public String  addUser(HttpServletRequest request,@RequestBody User user){
        Boolean x = verifyCookies(request);

        Map<String,Object> result=new HashMap<String,Object>();

        if(x!=null){
            try {
                userDao.save(user);
                result.put("msg","成功");
                result.put("data",user);
            }catch (Exception e){
                result.put("msg","数据异常,添加/修改失败");
            }
        }else{
            result.put("msg","用户未登陆");
        }
        return  gson.toJson(result);
    }



    @RequestMapping(value = "getUserDetail",method = RequestMethod.GET)
    @ApiOperation(value = "用户详情接口",notes = "通过id查询用户的详细信息",httpMethod = "GET")
    public String getUserDetail(HttpServletRequest request, @RequestParam(value="user_id",required = true) Integer id){

        Boolean x = verifyCookies(request);
        Map<String,Object> result=new HashMap <>();

        if(x==null){
            User user =userDao.getOne(id);
            result.put("msg","成功");
            result.put("data",user);
        }else{
            result.put("msg","用户未登陆");
        }
        return gson.toJson(result);
    }


    @RequestMapping(value = "getUserListByName",method = RequestMethod.GET)
    @ApiOperation(value = "查询用户",notes="通过用户的name来查询用户",httpMethod = "GET")
    public String getUserListByName(HttpServletRequest request, @RequestBody User user){

        Boolean x = verifyCookies(request);
        Map<String,Object> result=new HashMap <>();

        if(x==null){
            List <User> users =new ArrayList <>();
            users=userDao.findByName(user.getName());
            result.put("msg","成功");
            result.put("data",users);
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