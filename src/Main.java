import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLOutput;
import java.util.HashMap;

public class Main
{
    public static void main(String args[]) throws NoSuchAlgorithmException
    {
        String test_string="abcd ";
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        MessageDigest md2 = MessageDigest.getInstance("MD2");
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        System.out.println("Original text: \"" + test_string+"\"");
        System.out.println("(MessageDigest) MD2 : " + bytesToString(md2.digest(test_string.getBytes())));
        System.out.println("(MessageDigest) MD5 : " + bytesToString(md5.digest(test_string.getBytes())));
        System.out.println("(MessageDigest) SHA-1 : " + bytesToString(sha1.digest(test_string.getBytes())));
        byte[] rand_text=new byte[15];
        for(int i=0; i<3; i++)
        {
            SecureRandom rand = new SecureRandom();
            rand.nextBytes(rand_text);
            System.out.println("\nGenerating new random...");
            System.out.println("(SecureRandom) MD2 : " + bytesToString(md2.digest(rand_text)));
            System.out.println("(SecureRandom) MD5 : " + bytesToString(md5.digest(rand_text)));
            System.out.println("(SecureRandom) SHA-1 : " + bytesToString(sha1.digest(rand_text)));
        }

        //CatCorrect example
        System.out.println("\n\nTesting hashmap with correct class:");
        HashMap<CatCorrect, String> cats_ids_cor=new HashMap<>();
        CatCorrect def=new CatCorrect();
        cats_ids_cor.put(def, "id1");
        cats_ids_cor.put(def, "id2");
        System.out.println("Testing overwriting: "+cats_ids_cor.get(new CatCorrect()));
        CatCorrect def1=new CatCorrect("Flufy", 5, "Ivan");
        CatCorrect def2=new CatCorrect("Flufy", 5, "Ivan");
        cats_ids_cor.put(def2, "id7");
        cats_ids_cor.put(def1, "id3");
        cats_ids_cor.put(new CatCorrect("flufy", 5, "Ivan"), "id4");
        cats_ids_cor.put(new CatCorrect("gray", 1, "Ivan"), "id5");
        for (CatCorrect key : cats_ids_cor.keySet())
        {
            System.out.print(cats_ids_cor.get(key)+"  "+key.hashCode()+"\n");
        }

        //CatIncorrect example
        System.out.println("\n\nTesting hashmap with correct class:");
        HashMap<CatIncorrect, String> cats_ids_inc=new HashMap<>();
        CatIncorrect idef=new CatIncorrect();
        cats_ids_inc.put(idef, "id1");
        cats_ids_inc.put(idef, "id2");
        System.out.println("Testing overwriting: "+cats_ids_cor.get(new CatCorrect()));
        CatIncorrect idef1=new CatIncorrect("Flufy", 5, "Ivan");
        CatIncorrect idef2=new CatIncorrect("Flufy", 5, "Ivan");
        cats_ids_inc.put(idef2, "id7");
        cats_ids_inc.put(idef1, "id3");
        cats_ids_inc.put(new CatIncorrect("flufy", 5, "Ivan"), "id4");
        cats_ids_inc.put(new CatIncorrect("gray", 1, "Ivan"), "id5");
        for (CatIncorrect key : cats_ids_inc.keySet())
        {
            System.out.print(cats_ids_inc.get(key)+"  "+key.hashCode()+"\n");
        }


    }

    private static String bytesToString(byte[] hex)
    {
        String res="";
        for(int i=0; i<hex.length; i++)
        {
            res+=Integer.toHexString(0xFF & hex[i]);
        }
        return res;
    }

}