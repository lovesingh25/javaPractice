package trialjava;

public class minimumEdits {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        char[] s1 = {'s', 'a', 't', 'u', 'r', 'd', 'a', 'y'};
        char[] s2 = {'a', 'b', 'c'};
        int dif = 0;
        int edit = 0;
        int j = 0;
        dif = s1.length - s2.length;
        for (int i = 0; i < s1.length; i++) {
            for (; j < s2.length; j++) {
                System.out.println(s1[i] + " " + s2[j] + " " + edit);
                if (s1[i] == s2[j]) {
                    j++;
                    break;
                } else {
                    if (dif != 0) {
                        edit++;
                        if (dif < 0) {
                            dif++;
                        } else {
                            dif--;
                        }
                    } else {
                        edit++;
                        j++;
                        break;
                    }
                }

            }
            //System.out.println(edit);
        }
        //System.out.println(edit);
    }
}
