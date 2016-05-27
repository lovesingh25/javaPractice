package trialjava;

import java.util.*;

public class PangramCheck {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int i = 0;
        HashMap<String, Integer> H = new HashMap<String, Integer>();
        createAphaset(H);
        Scanner s = new Scanner(System.in);
        String ch;
        ch = s.nextLine();
        ch = ch.toLowerCase();
        i = ch.length();
        char[] charArray = ch.toCharArray();
        //System.out.println(i);
        while (--i >= 0) {
            if (H.containsKey(String.valueOf(charArray[i]))) {
                H.put(String.valueOf(charArray[i]), 1);
            }
        }
        if (H.containsValue(0)) {
            System.out.println("not pangram");
        } else {
            System.out.println("pangram");
        }
    }

    private static HashMap createAphaset(HashMap<String, Integer> h) {
        for (int i = 97; i <= 122; i++) {
            h.put(String.valueOf(Character.toChars(i)), 0);
        }
        return h;
        // TODO Auto-generated method stub
    }

}
