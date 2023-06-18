package com.khanduja.techwonders.designpatterns.structure.adaptar.service.impl;

import com.khanduja.techwonders.designpatterns.structure.adaptar.service.AdvancedMediaPlayer;

// Adaptee Implementation
public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        // Do Nothing
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }
}
