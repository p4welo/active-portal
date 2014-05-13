package co.radomski.setenta.server.security.token.key;

import co.radomski.setenta.server.security.token.CryptoConstants;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Component(KeyService.BEAN_NAME)
public class KeyService extends AbstractKeyService implements ApplicationContextAware
{
   public static final String BEAN_NAME = "keyService";

   private Map<Byte, Key> keys = new HashMap<Byte, Key>();

   private Map<Byte, String> rawkeys = new HashMap<Byte, String>();

   public Key getKey(byte index)
   {
      return keys.get(index);
   }

   public int getSize()
   {
      return keys.size();
   }

   @Override
   public void afterPropertiesSet() throws Exception
   {
      super.afterPropertiesSet();
      for (Byte key : rawkeys.keySet())
      {
         byte[] decoded = Base64.decode(rawkeys.get(key).getBytes());
         byte[] output = doFinal(decoded);
         keys.put(key, new SecretKeySpec(output, CryptoConstants.KEY_ALGORITHM));
      }
   }

   @Override
   protected int getCipherMode()
   {
      return Cipher.DECRYPT_MODE;
   }

   @Override
   public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
   {
      Map<String, Properties> propertiesBeans = applicationContext.getBeansOfType(Properties.class);
      for (String k : propertiesBeans.keySet())
      {
         Properties properties = propertiesBeans.get(k);
         for (String key : properties.stringPropertyNames())
         {
            if (key.startsWith("crypto.key"))
            {
               byte index = (byte) Integer.parseInt(key.substring(11));
               rawkeys.put(index, properties.getProperty(key));
            }
         }
      }
   }
}
