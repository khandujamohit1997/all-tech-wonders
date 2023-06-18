package com.khanduja.techwonders.designpatterns.structure.adaptar.service.impl;

import com.khanduja.techwonders.designpatterns.structure.adaptar.model.AudioType;
import com.khanduja.techwonders.designpatterns.structure.adaptar.service.AdvancedMediaPlayer;
import com.khanduja.techwonders.designpatterns.structure.adaptar.service.MediaPlayer;

// Adapter class
public class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(AudioType audioType) {
        if (AudioType.VLC.equals(audioType)) {
            advancedMediaPlayer = new VlcPlayer();
        } else if (AudioType.MP4.equals(audioType)) {
            advancedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(AudioType audioType, String fileName) {
        if (AudioType.VLC.equals(audioType)) {
            advancedMediaPlayer.playVlc(fileName);
        } else if (AudioType.MP4.equals(audioType)) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
