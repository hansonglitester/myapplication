package com.hsl.cn.controller;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class test {
    static String  path="1.txt";

    public static void main(String[] args) throws IOException {

        List<String> list=FileUtils.readLines(new File("D:/cxyapi.txt"),"utf-8");

        for(String s:list){
            System.out.println(s);
        }



        FileUtils.writeLines(new File(path),list,true);

        //FileUtils.writeStringToFile(new File("D:/a/b/cxyapi.txt"), "作者：cxy", "UTF-8",true);
    }
}
