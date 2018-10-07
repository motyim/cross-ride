package com.crossover.techtrial.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 10/7/2018
 */
@Configuration
public class DozerConfig {

    @Bean
    public DozerBeanMapper getMapper(){
        return new DozerBeanMapper();
    }

}
