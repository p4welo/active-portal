package co.radomski.setenta.server.security.token;

public interface CryptoConstants
{

   public static final String NOPAD_ENCRYPTION_ALGORITHM = "AES/CBC/NoPadding";

   public static final String PADDED_ENCRYPTION_ALGORITHM = "AES/CBC/PKCS5Padding";

   public static final String KEY_ALGORITHM = "AES";

   public static final String MAC_ALGORITHM = "HmacSHA1";

}
