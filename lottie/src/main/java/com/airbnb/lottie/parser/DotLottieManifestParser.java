package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.AnimationsItem;
import com.airbnb.lottie.model.DotLottieManifest;
import com.airbnb.lottie.parser.moshi.JsonReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DotLottieManifestParser {

  private static final JsonReader.Options NAMES = JsonReader.Options.of(
      "author",
      "generator",
      "version",
      "animations"
  );

  private DotLottieManifestParser() {

  }

  public static DotLottieManifest parse(JsonReader reader) throws IOException {
    String author = null;
    String generator = null;
    String version = null;
    List<AnimationsItem> animations = new ArrayList<>();

    reader.beginObject();
    while (reader.hasNext()) {
      switch (reader.selectName(NAMES)) {
        case 0:
          author = reader.nextString();
          break;
        case 1:
          generator = reader.nextString();
          break;
        case 2:
          version = reader.nextString();
          break;
        case 3:
          reader.beginArray();
          while (reader.hasNext()) {
            animations.add(AnimationsItemParser.parse(reader));
          }
          reader.endArray();
          break;
        default:
          reader.skipName();
          reader.skipValue();
      }
    }
    reader.endObject();
    return new DotLottieManifest(author,animations,version,generator);
  }

}
