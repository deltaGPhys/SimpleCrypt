import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {

    private int shift;

    ROT13(Character cs, Character cf) {
        shift = cf-cs;
    }

    ROT13() {
        shift = 0;
    }


    public String crypt(String text) throws UnsupportedOperationException {
        return decrypt(encrypt(text));
    }

    public String encrypt(String text) {
        return rotate(text,(char) (97+shift));
    }

    public String decrypt(String text) {
        return rotate(text,(char) (97+26-shift));
    }

    //a: 97 z: 122 A: 65 Z: 90

    public static String rotate(String s, Character c) {
        int shift;
        if (c >= 97 && c<=122) {
            shift = c-97;
        } else {
            shift = c-65;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
             if (chars[i] >= 97 && chars[i]<=122) {
                 chars[i] = (char) (97+(chars[i]+shift-97)%26);
             } else if (chars[i] >= 65 && chars[i]<= 90) {
                 chars[i] = (char) (65+(chars[i]+shift-65)%26);
             }
        }
        return String.valueOf(chars);
    }

}
