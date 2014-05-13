package co.radomski.setenta.server.security.token.key;

import co.radomski.setenta.server.security.token.CryptoConstants;
import org.springframework.security.crypto.codec.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class KeyGenerator extends AbstractKeyService
{
   @Override
   protected int getCipherMode()
   {
      return Cipher.ENCRYPT_MODE;
   }

   public void generate(int count) throws Exception
   {
      javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance(CryptoConstants.KEY_ALGORITHM);
      keyGenerator.init(128);
      for (int i = 0; i < count; i++)
      {
         SecretKey secretKey = keyGenerator.generateKey();
         byte[] encoded = secretKey.getEncoded();
         byte[] encryptedBytes = doFinal(encoded);
         byte[] base64edEncryptedBytes = Base64.encode(encryptedBytes);
         print(base64edEncryptedBytes, encoded);
      }
   }

   private void print(byte[] base64edEncryptedBytes, byte[] encryptedBytes)
   {
      StringBuffer sb = new StringBuffer();
      sb.append(new String(base64edEncryptedBytes));
      sb.append(" [");
      for (byte b : encryptedBytes)
      {
         sb.append(b).append(", ");
      }
      sb.delete(sb.length() - 2, sb.length());
      sb.append("]");
      System.out.println(sb.toString());
   }

   public static void main(String[] args) throws Exception
   {
      KeyGenerator generator = new KeyGenerator();
      generator.afterPropertiesSet();
      generator.generate(getCountParam(args));
   }

   private static int getCountParam(String[] args)
   {
      try
      {
         return args.length > 0 ? Integer.parseInt(args[0]) : 1;
      }
      catch (NumberFormatException e)
      {
         return 1;
      }
   }
}
