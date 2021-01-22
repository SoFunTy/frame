package com.cn.frame.api.crons;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Create By SoFunTy
 * 2020/11/18  11:29
 */
@Slf4j
@Component
@Order(value=1)
public class AppInitStartupRunner implements CommandLineRunner {

    @Override
    public void run(String... args){
        log.info("---------------------------------Init Start---------------------------------");
        log.info("----------------------------------Init  End----------------------------------");
    }
}
