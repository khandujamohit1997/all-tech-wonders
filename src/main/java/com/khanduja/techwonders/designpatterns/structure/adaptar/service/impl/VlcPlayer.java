package com.khanduja.techwonders.designpatterns.structure.adaptar.service.impl;

import com.khanduja.techwonders.designpatterns.structure.adaptar.service.AdvancedMediaPlayer;

// Adaptee implementation
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // Do Nothing
    }
}
