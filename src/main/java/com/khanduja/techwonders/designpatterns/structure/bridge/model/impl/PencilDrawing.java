package com.khanduja.techwonders.designpatterns.structure.bridge.model.impl;

import com.khanduja.techwonders.designpatterns.structure.bridge.model.DrawingAPI;

// Concrete implementors
public class PencilDrawing implements DrawingAPI {

    @Override
    public void drawCircle() {
        System.out.println("Pencil: Drawing Circle");
    }
}
