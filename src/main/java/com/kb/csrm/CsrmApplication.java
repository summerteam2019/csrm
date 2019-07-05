package com.kb.csrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统启动类
 *
 * @author yiwang
 * @version 1.0
 * @date Created on 2019/06/25
 */

@SpringBootApplication
public class CsrmApplication {

    /**
     * 系统启动方法
     * @param args 系统参数
     */
    public static void main(String[] args) {
        SpringApplication.run(CsrmApplication.class, args);
    }

}
