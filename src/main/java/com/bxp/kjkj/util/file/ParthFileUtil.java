package com.bxp.kjkj.util.file;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ParthFileUtil {
    public static final Integer TYPE_1024 = 1;
    public static final Integer TYPE_848 = 2;
    public static String line1024 = "通道8中直传数据第46874行不连续：当前计数=53910，下一帧计数=53912";
    public static String line848 = "在第0帧错误，  正确校验码为：  1f 15,  计算后校验码为：  88 82";
    public static List<String[]> parthFileToList(File file, Integer type) throws IOException {
        List<String[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file)));
        String line = null;
        if (type == TYPE_1024){
            while ((line = reader.readLine()) != null){
                list.add(parth1024(line));
            }
        }else if (type == TYPE_848){
            while ((line = reader.readLine()) != null){
                list.add(parth848(line));
            }
        }
        return list;
    }

    public static String[] parth1024(String line){
        return line.split("通道|中|第|行|：当前计数=|，下一帧计数=");
    }

    public static String[] parth848(String line){
        return line.split("在第|帧错误，|正确校验码为：|,|计算后校验码为：");
    }
    @Test
    public void testParth(){
        int i = 0;
        System.out.println("1024:");
        for(String s : parth1024(line1024)){
            System.out.println(i + "  :  " + s);
            i++;
        }

        System.out.println("848:");
        i = 0;
        for(String s : parth848(line848)){
            System.out.println(i + "  :  " + s.trim());
            i++;
        }
    }

    @Test
    public void testParthFileToList() throws IOException {
        for(String[] sArry : parthFileToList(new File("/home/bxp/Documents/doc/kjkjTest/data/1024.txt"
        ), TYPE_1024)){
            for(String s : sArry){
                System.out.print(s + "   ");
            }
            System.out.println();
        }

        for(String[] sArry : parthFileToList(new File("/home/bxp/Documents/doc/kjkjTest/data/848.txt"
        ), TYPE_848)){
            for(String s : sArry){
                System.out.print(s + "   ");
            }
            System.out.println();
        }
    }
}
