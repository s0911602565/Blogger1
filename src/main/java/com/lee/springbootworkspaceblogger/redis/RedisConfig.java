package com.lee.springbootworkspaceblogger.redis;



import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
public class RedisConfig {
    @Bean
    public JedisConnectionFactory conFactory() {
        RedisStandaloneConfiguration c = new RedisStandaloneConfiguration();
        c.setHostName("localhost");
        c.setPort(6379);
        //c.setDatabase(0);
        return new JedisConnectionFactory(c);

    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> r = new RedisTemplate<String, Object>();
        r.setConnectionFactory(conFactory());
        r.setKeySerializer(new StringRedisSerializer());
        r.setHashKeySerializer(new StringRedisSerializer());
        r.setHashKeySerializer(new JdkSerializationRedisSerializer());
        r.setValueSerializer(new JdkSerializationRedisSerializer());
        r.setEnableTransactionSupport(true);
        r.afterPropertiesSet();
        return r;
    }

}
