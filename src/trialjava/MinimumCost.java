package trialjava;

import java.util.*;

public class MinimumCost {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int t = 0;
        Scanner s = new Scanner(System.in);
        t = Integer.valueOf(s.next());

        while (t > 0) {
            int a = 0, b = 0, c = 0, cwithoutR = 0, cwithR = 0;
            String u, x;
            x = s.next();
            u = s.next();

            a = s.nextInt();
            b = s.nextInt();
            c = s.nextInt();

            HashMap<String, Integer> mapx = new HashMap<String, Integer>();
            HashMap<String, Integer> mapu = new HashMap<String, Integer>();
            HashMap<String, Integer> differenceMap = new HashMap<String, Integer>();

            mapx = populateHash(mapx, x);
            mapu = populateHash(mapu, u);
            differenceMap = calculatedifference(mapx, mapu);
            cwithoutR = calCostwithoutReplace(differenceMap, a, b);
            if (x.length() > u.length()) {
                cwithR = (x.length() - u.length()) * a;
                cwithR = cwithR + calCostwithR(differenceMap, c, 0);
            } else {
                cwithR = (u.length() - x.length()) * b;
                cwithR = cwithR + calCostwithR(differenceMap, c, u.length() - x.length());
            }
            if (cwithoutR < cwithR) {
                System.out.println(cwithoutR);
            } else {
                System.out.println(cwithR);
            }
            t--;
        }
    }

    private static int calCostwithR(HashMap<String, Integer> differenceMap, int c, int z) {
        // TODO Auto-generated method stub
        int cost = 0;
        for (Integer i : differenceMap.values()) {
            if (i > 0) {
                cost = cost + i;
            }
        }

        cost = (cost - z) * c;
        if (cost > 0) {

            return cost;
        } else
            return 0;
    }

    private static int calCostwithoutReplace(HashMap<String, Integer> differenceMap, int a, int b) {
        // TODO Auto-generated method stub
        int cost = 0;
        for (Integer i : differenceMap.values()) {
            if (i > 0) {
                cost = cost + Math.abs(i * b);
            } else {
                cost = cost + Math.abs(i * a);
            }
        }
        return cost;
    }

    private static HashMap calculatedifference(HashMap<String, Integer> mapx, HashMap<String, Integer> mapu) {
        HashMap<String, Integer> differenceMap = new HashMap<String, Integer>();
        for (String s : mapu.keySet()) {
            int tempx = 0;
            if (mapx.containsKey(s)) {
                tempx = mapx.get(s);
            }
            int tempu = mapu.get(s);
            differenceMap.put(s, tempu - tempx);
        }
        for (String s : mapx.keySet()) {
            if (!differenceMap.containsKey(s)) {
                int tempx = mapx.get(s);
                differenceMap.put(s, 0 - tempx);
            }
        }
        return differenceMap;
    }

    private static HashMap populateHash(HashMap<String, Integer> mapx, String x) {
        int temp;
        char[] ch = x.toCharArray();
        for (int i = 0; i < x.length(); i++) {
            if (mapx.containsKey(Character.toString(ch[i]))) {
                temp = mapx.get(Character.toString(ch[i]));
                mapx.put(Character.toString(ch[i]), temp + 1);
            } else {
                mapx.put(Character.toString(ch[i]), 1);
            }
        }
        return mapx;
        // TODO Auto-generated method stub

    }

}
