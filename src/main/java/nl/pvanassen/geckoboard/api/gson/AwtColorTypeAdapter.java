package nl.pvanassen.geckoboard.api.gson;

import java.awt.Color;
import java.io.IOException;
import java.util.Locale;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Type adapter to convert awt to json
 *
 * @author Paul van Assen
 */
class AwtColorTypeAdapter extends TypeAdapter<Color> {

    @Override
    public Color read(JsonReader in) throws IOException {
        // We only do writing atm
        return null;
    }

    @Override
    public void write(JsonWriter out, Color color) throws IOException {
        if (color == null) {
            out.nullValue();
            return;
        }
        String colorStr;
        if (color.getAlpha() == 255) {
            colorStr = String.format("%06X", 0xFFFFFF & color.getRGB());
        }
        else {
            colorStr = String.format(Locale.ENGLISH,"rgba(%d,%d,%d,%.2f)", color.getRed(), color.getGreen(), color.getBlue(), (float)color.getAlpha()/255);
        }
        out.value(colorStr);
    }
}