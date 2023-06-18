package com.khanduja.techwonders.designpatterns.structure.controller;

import com.khanduja.techwonders.designpatterns.structure.adaptar.model.AudioType;
import com.khanduja.techwonders.designpatterns.structure.adaptar.service.MediaPlayer;
import com.khanduja.techwonders.designpatterns.structure.adaptar.service.impl.MediaAdapter;
import com.khanduja.techwonders.designpatterns.structure.bridge.model.DrawingMedium;
import com.khanduja.techwonders.designpatterns.structure.bridge.service.BridgeServiceBean;
import com.khanduja.techwonders.designpatterns.structure.composite.service.CompositeServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/structure/")
public class StructureDPController {

    @Autowired
    BridgeServiceBean bridgeServiceBean;

    @Autowired
    CompositeServiceBean compositeServiceBean;

    @GetMapping("adaptor")
    public void playMusic(@RequestParam("audioType") AudioType audioType) {
        MediaPlayer mediaPlayer = new MediaAdapter(audioType);
        mediaPlayer.play(audioType, "song.mp4");
    }

    @GetMapping("bridge")
    public void bridge(@RequestParam("drawingMedium") DrawingMedium drawingMedium) {
        bridgeServiceBean.drawCircleByDrawingMedium(drawingMedium);
    }

    @GetMapping("composite")
    public void listOrganizationHierarchy() {
        compositeServiceBean.printOrganizationHierarchy();
    }
}
