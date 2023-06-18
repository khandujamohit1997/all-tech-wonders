package com.khanduja.techwonders.designpatterns.structure.bridge.model.impl;

import com.khanduja.techwonders.designpatterns.structure.bridge.model.DrawingAPI;
import com.khanduja.techwonders.designpatterns.structure.bridge.model.Shape;

// Refined Abstraction
public class CircleShape implements Shape {
    private final DrawingAPI drawingAPI;

    public CircleShape(DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    @Override
    public void draw() {
        drawingAPI.drawCircle();
    }
}
