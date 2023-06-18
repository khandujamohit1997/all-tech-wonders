package com.khanduja.techwonders.designpatterns.structure.bridge.service;

import com.khanduja.techwonders.designpatterns.structure.bridge.model.DrawingMedium;
import com.khanduja.techwonders.designpatterns.structure.bridge.model.Shape;
import com.khanduja.techwonders.designpatterns.structure.bridge.model.impl.CircleShape;
import com.khanduja.techwonders.designpatterns.structure.bridge.model.impl.PenDrawing;
import com.khanduja.techwonders.designpatterns.structure.bridge.model.impl.PencilDrawing;
import org.springframework.stereotype.Service;

@Service
public class BridgeServiceBean {
    public void drawCircleByDrawingMedium(DrawingMedium drawingMedium) {
        switch (drawingMedium) {
            case Pen -> new CircleShape(new PenDrawing()).draw();
            case Pencil -> new CircleShape(new PencilDrawing()).draw();
        }

        Shape circle1 = new CircleShape(new PencilDrawing());
        Shape circle2 = new CircleShape(new PenDrawing());

        circle1.draw();
        circle2.draw();
    }
}
