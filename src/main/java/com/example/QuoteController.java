package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by markheckler on 10/12/16.
 */
@RestController
public class QuoteController {
    private RedisTemplate<String, Quote> redisTemplate;

    @Autowired
    public QuoteController(RedisTemplate<String, Quote> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @RequestMapping("/random")
    public Quote getRandomQuote() {
        Quote quote = this.redisTemplate.opsForSet().randomMember("quotes");
        return quote;
    }
}
