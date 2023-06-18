package com.khanduja.techwonders.concepts.concurrency;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class HashMapService {
    ConcurrentHashMap<String, Object> cache = new ConcurrentHashMap<>();

    public void addCache(String key, Object value) {
        cache.put(key, value);
    }

    public Object getCacheValue(String key) {
        return cache.get(key);
    }
}
