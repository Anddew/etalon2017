package com.netcracker.project.converter;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.convert.support.ConversionServiceFactory;
import org.springframework.core.convert.support.GenericConversionService;

import java.util.Set;

public class CustomConvertersRegister implements InitializingBean {

    private GenericConversionService conversionService;

    private Set<?> converters;

    public CustomConvertersRegister() {
    }

    public void setConverters(Set<?> converters) {
        this.converters = converters;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ConversionServiceFactory.registerConverters(this.converters, this.conversionService);
    }
}