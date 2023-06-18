package com.khanduja.techwonders.designpatterns.structure.adaptar.service;

import com.khanduja.techwonders.designpatterns.structure.adaptar.model.AudioType;

// Target Interface
public interface MediaPlayer {
    void play(AudioType mediaType, String fileName);
}
