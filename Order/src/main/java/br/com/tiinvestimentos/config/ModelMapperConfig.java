package br.com.tiinvestimentos.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.tiinvestimentos.util.Mapper;

@Configuration
public class ModelMapperConfig {

    @Bean
    public Mapper mapper() {
        final ModelMapper modelMapper = new ModelMapper();
        return new Mapper() {
            @Override
            public <D> D map(Object source, Class<D> destinationType) {
                return modelMapper.map(source, destinationType);
            }

            @Override
            public void map(Object source, Object destination) {
                modelMapper.map(source, destination);
            }
        };
    }
}
