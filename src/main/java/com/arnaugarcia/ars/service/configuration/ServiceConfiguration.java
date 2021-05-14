package com.arnaugarcia.ars.service.configuration;

import com.arnaugarcia.ars.service.mapper.DeviceMapper;
import com.arnaugarcia.ars.service.mapper.DeviceMapperImpl;
import com.arnaugarcia.ars.service.service.DeviceService;
import com.arnaugarcia.ars.service.service.impl.DeviceServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public DeviceService deviceService(DeviceMapper deviceMapper) {
        return new DeviceServiceImpl(deviceMapper);
    }

    @Bean
    @ConditionalOnMissingBean
    public DeviceMapper deviceMapper() {
        return new DeviceMapperImpl();
    }
}
