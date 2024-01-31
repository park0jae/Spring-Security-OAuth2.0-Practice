package com.pgms.coreinfraredis.repository;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RedisRepository {

	private final RedisTemplate redisTemplate;

	public void save(String key, Object value) {
		ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
		valueOperations.set(key, value);
		redisTemplate.expire(key, 7, TimeUnit.DAYS);
	}

	public Optional<Long> getMemberId(String key) {
		ValueOperations<String, Long> valueOperations = redisTemplate.opsForValue();
		Long memberId = valueOperations.get(key);
		return Optional.ofNullable(memberId);
	}

	public void delete(String key) {
		redisTemplate.delete(key);
	}
}
