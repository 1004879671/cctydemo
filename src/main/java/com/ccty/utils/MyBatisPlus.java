package com.ccty.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Collections;

/**
 * @author 张峰
 * @create 2022/2/21 20:37
 */
public class MyBatisPlus {
    public static void main(String[] args) {
        String url="jdbc:mysql://192.168.175.120:3306/e_commerce?serverTimezone=GMT%2b8";
        String username="root";
        String password="root";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("张峰") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir() //禁止打开输出目录
                            .outputDir("D:\\mutianyu\\cctydemo\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.ccty") // 设置父包名
                            .moduleName(null) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\mutianyu\\cctydemo\\src\\main\\resources\\mapper\\")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder().enableLombok(); //启动lombok
                    builder.mapperBuilder().enableMapperAnnotation().build(); //启用@mapper注释
                    builder.controllerBuilder().enableHyphenStyle().enableRestStyle(); //启用驼峰转连字符样式
                    builder.addInclude("t_user"); // 设置需要生成的表名
                })
                .execute();
    }
}
