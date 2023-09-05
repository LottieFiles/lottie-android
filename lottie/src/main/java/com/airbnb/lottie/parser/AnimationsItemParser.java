package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.AnimationsItem;
import com.airbnb.lottie.parser.moshi.JsonReader;

import java.io.IOException;

public class AnimationsItemParser {

  private static final JsonReader.Options NAMES = JsonReader.Options.of(
      "loop",
      "themeColor",
      "speed",
      "id"
  );

  private AnimationsItemParser() {

  }

  static AnimationsItem parse(JsonReader reader) throws IOException {
    boolean loop = false;
    String themeColor = null;
    String id = null;
    float speed = 0f;

    reader.beginObject();
    while (reader.hasNext()) {
      switch (reader.selectName(NAMES)) {
        case 0:
          loop = reader.nextBoolean();
          break;
        case 1:
          themeColor = reader.nextString();
          break;
        case 2:
          speed = (float) reader.nextDouble();
          break;
        case 3:
          id = reader.nextString();
          break;
        default:
          reader.skipName();
          reader.skipValue();
      }
    }
    reader.endObject();
    return new AnimationsItem(themeColor,loop,id,speed);
  }

}
