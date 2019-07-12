package com.kb.csrm;

import com.kb.csrm.imoocCrawler.crawler.Crawler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Configuration//配置控制
/**
 * 系统启动类
 *
 * @author yiwang
 * @version 1.0
 * @date Created on 2019/06/25
 */
public class CsrmApplication {

    /**
     * 系统启动方法
     *
     * @param args 系统参数
     */
    public static void main(String[] args) {
        SpringApplication.run(CsrmApplication.class, args);
    }

    /**
     * session时长设置
     * @return
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8080);
            }
        };
    }

}
