package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class QuoteServiceApplication {
	@Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Quote> redisTemplate(RedisConnectionFactory rcf) {
        RedisTemplate<String, Quote> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(rcf);
        return redisTemplate;
    }

    @Bean
    @Autowired
    CommandLineRunner commandLineRunner(RedisTemplate<String, Quote> rt) {
        return args -> {
//            rt.opsForSet().add("quotes", new Quote("The unexamined life is not worth living.", "Socrates"));
//            rt.opsForSet().add("quotes", new Quote("What you do makes a difference, and you have to decide what kind of difference you want to make.", "Jane Goodall"));
//            rt.opsForSet().add("quotes", new Quote("Do you want to know who you are? Don't ask. Act! Action will delineate and define you.", "Thomas Jefferson"));
//            rt.opsForSet().add("quotes", new Quote("Love is the absence of judgment.", "Dalai Lama XIV"));
//            rt.opsForSet().add("quotes", new Quote("You have power over your mind - not outside events. Realize this, and you will find strength.", "Marcus Aurelius, Meditations"));
//            rt.opsForSet().add("quotes", new Quote("It's hard to beat a person who never gives up.", "Babe Ruth"));
//            rt.opsForSet().add("quotes", new Quote("Imagination is the highest form of research.", "Albert Einstein"));

            rt.opsForSet().members("quotes").forEach(System.out::println);
        };
    }

	public static void main(String[] args) {
		SpringApplication.run(QuoteServiceApplication.class, args);
	}
}
