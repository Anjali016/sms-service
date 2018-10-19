package com.marketplaces.www.repo;

import com.marketplaces.www.dto.SMSRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class SmsRepositoryImpl implements SmsRepository {

    private static final String KEY = "sms";
    private RedisTemplate<String, SMSRequestDTO> redisTemplate;
    // private HashOperations<String, String, SMSRequestDTO> hashOperations;
    private ZSetOperations<String, SMSRequestDTO> zSetOperations;

    private void init() {
        zSetOperations = redisTemplate.opsForZSet();
    }

    @Autowired
    SmsRepositoryImpl(RedisTemplate<String, SMSRequestDTO> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void storeMessage(SMSRequestDTO message, String queue) {
        init();
        zSetOperations.add(queue, message, System.currentTimeMillis());
    }

    @Override
    public SMSRequestDTO getMessage(String number) {
        return null;
    }

    @Override
    public void updateMessage(SMSRequestDTO message) {
        //  storeMessage(message);
    }

    @Override
    public void deleteMessage(String queue, SMSRequestDTO value) {
        init();
        zSetOperations.remove(queue, value);
    }

    @Override
    public Set<SMSRequestDTO> dequeue(String queue, int limit) {
        init();
        Set<SMSRequestDTO> set = zSetOperations.rangeByScore(queue, 0, System.currentTimeMillis(), 0, limit);
//        set.forEach(t -> deleteMessage(queue, t));
        return set;
    }
}
