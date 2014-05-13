package co.radomski.setenta.server.security;

/**
 * User: Wojciech Szubryt
 * Date: 11.10.13
 * Time: 10:09
 */
public class MasterKey
{

   private MasterKey()
   {
   }

   public static final byte[] MASTER_SECRET = new byte[]{
           -35, -109, 55, -6, -19, -1, 120, 127, 26, -46, -27, -113, 24, 24, 56, 12};

}
