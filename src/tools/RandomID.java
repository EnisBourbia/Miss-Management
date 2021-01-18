package tools;

import java.util.UUID;

public class RandomID {
    public static String getRandomID(){
      return UUID.randomUUID().toString();
    }
}
