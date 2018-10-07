package com.marketplaces.www.config;

import com.marketplaces.www.dto.SMSRequestDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@ComponentScan("com.marketplaces.www")
public class RedisConfig {

  @Bean
  JedisConnectionFactory jedisConnectionFactory() {
    JedisConnectionFactory factory = new JedisConnectionFactory();
    return factory;
  }

  @Bean
  public RedisTemplate<String, SMSRequestDTO> redisTemplate() {
    RedisTemplate<String, SMSRequestDTO> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(jedisConnectionFactory());
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<SMSRequestDTO>(SMSRequestDTO.class));
    return redisTemplate;
  }
}
