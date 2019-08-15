package com.hsl.cn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
public class Kuaidi100HuiDiaoParamContoller {

    @RequestMapping(value = "/kuaidi",method = RequestMethod.GET)
    public Map<String, Object> kuaidi(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map <String ,Object> param=new HashMap<String,Object>();
        param.put("status","polling");
        param.put("message","");
        param.put("billstatus","got");
        param.put("autoCheck","0");
        param.put("comOld","");
        param.put("comNew","");
        //lastResult
        Map <String ,Object> lastResult=new HashMap<String,Object>();
        //lastResult 下的data
        List<Map<String,Object>> dataList=new ArrayList<Map<String, Object>>();
        for(int i=0;i<3;i++){
            if(i==0){
                Map <String ,Object> datarecord=new HashMap<String,Object>();
                datarecord.put("context","上海分拨中心/装件入车扫描");
                datarecord.put("time","2012-08-28 16:33:19");
                datarecord.put("ftime","2012-08-28 16:33:19");
                dataList.add(datarecord);
            }else{
                Map <String ,Object> datarecord=new HashMap<String,Object>();
                datarecord.put("context","【辽宁省大连市公司】 已发出 下一站 【辽宁省大连市大连开发区一部公司"+new Random() .nextInt(1000));
                datarecord.put("time","2012-08-28 16:33:19");
                datarecord.put("ftime","2012-08-28 16:33:19");
                dataList.add(datarecord);
            }

        }
        lastResult.put("message","ok");
        lastResult.put("state","3");
        lastResult.put("status",200);
        lastResult.put("condition","F00");
        lastResult.put("ischeck","0");
        lastResult.put("com",request.getParameter("com"));
        lastResult.put("nu",request.getParameter("num"));
        lastResult.put("data",dataList);
        param.put("lastResult",lastResult);
        return param ;
    }
}

