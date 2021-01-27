package drawingbot.utils;

import drawingbot.drawing.ObservableDrawingPen;
import drawingbot.helpers.ImageTools;

import java.util.Comparator;

public enum EnumDistributionOrder {

    DARKEST_FIRST(Comparator.comparingInt(pen -> ImageTools.getBrightness(pen.getRGBColour()))),
    LIGHTEST_FIRST(Comparator.comparingInt(pen -> -ImageTools.getBrightness(pen.getRGBColour()))),
    DISPLAYED(Comparator.comparingInt(pen -> pen.penNumber.get())),
    REVERSED(Comparator.comparingInt(pen -> -pen.penNumber.get()));

    public Comparator<ObservableDrawingPen> comparator;

    EnumDistributionOrder(Comparator<ObservableDrawingPen> comparator){
        this.comparator = comparator;
    }

    @Override
    public String toString() {
        return "Distribution Order: " + Utils.capitalize(name());
    }

}