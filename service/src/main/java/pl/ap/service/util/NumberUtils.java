package pl.ap.service.util;

import java.util.Random;

/**
 * Created by parado on 15.04.14.
 */
public class NumberUtils
{
   public static String generate(int length)
   {
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < length; i++)
      {
         builder.append(random(0, 9));
      }
      return builder.toString();
   }

   public static int random(int min, int max)
   {
      Random random = new Random();
      return random.nextInt(max - min + 1) + min;
   }
}
