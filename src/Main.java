import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

public class Main
{
    public static void main(String args[]) throws NoSuchAlgorithmException
    {
        String test_string="abcd ";
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        MessageDigest md2 = MessageDigest.getInstance("MD2");
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        System.out.println("Original text: \"" + test_string+"\"");
        System.out.println("(MessageDigest) MD2 : " + hexToString(md2.digest(test_string.getBytes())));
        System.out.println("(MessageDigest) MD5 : " + hexToString(md5.digest(test_string.getBytes())));
        System.out.println("(MessageDigest) SHA-1 : " + hexToString(sha1.digest(test_string.getBytes())));
        byte[] rand_text=new byte[15];
        SecureRandom rand = new SecureRandom();
        rand.nextBytes(rand_text);
        for(int i=0; i<3; i++)
        {
            System.out.println("\nGenerating new random...");
            System.out.println("(SecureRandom) MD2 : " + hexToString(md2.digest(rand_text)));
            System.out.println("(SecureRandom) MD5 : " + hexToString(md5.digest(rand_text)));
            System.out.println("(SecureRandom) SHA-1 : " + hexToString(sha1.digest(rand_text)));
        }


    }

    private static String hexToString(byte[] hex)
    {
        String res="";
        for(int i=0; i<hex.length; i++)
        {
            res+=Integer.toHexString(0xFF & hex[i]);
        }
        return res;
    }

}