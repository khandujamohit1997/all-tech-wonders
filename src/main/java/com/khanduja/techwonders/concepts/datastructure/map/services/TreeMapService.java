package com.khanduja.techwonders.concepts.datastructure.map.services;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.TreeMap;

@Service
public class TreeMapService {
    TreeMap<LocalDateTime, String> eventScheduling = new TreeMap<>();

    public void scheduleEvent() {
        eventScheduling.put(LocalDateTime.parse("2023-05-19T10:00"), "Event 1");
        eventScheduling.put(LocalDateTime.parse("2023-05-29T10:00"), "Event 2");
        eventScheduling.put(LocalDateTime.parse("2023-05-09T10:00"), "Event 3");
    }

    public String fetchEvent() {
        String event = eventScheduling.firstEntry().getValue();
        eventScheduling.remove(eventScheduling.firstKey());
        return event;
    }
}
