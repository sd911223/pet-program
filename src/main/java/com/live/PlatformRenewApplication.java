package com.live;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shitou
 */
@SpringBootApplication
@MapperScan("com.live.dao")
public class PlatformRenewApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformRenewApplication.class, args);
    }

}
