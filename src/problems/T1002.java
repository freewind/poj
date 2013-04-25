package problems;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * User: Administrator
 * Date: 13-4-25
 * Time: 上午10:33
 */
public class T1002 {

    public static void main(String[] args) {
        shouldEqual("310-1010 2\n"
                    + "487-3279 4\n"
                    + "888-4567 3",
                run("12\n"
                    + "4873279\n"
                    + "ITS-EASY\n"
                    + "888-4567\n"
                    + "3-10-10-10\n"
                    + "888-GLOP\n"
                    + "TUT-GLOP\n"
                    + "967-11-11\n"
                    + "310-GINO\n"
                    + "F101010\n"
                    + "888-1200\n"
                    + "-4-8-7-3-2-7-9-\n"
                    + "487-3279"));
    }

    private static void shouldEqual(String expect, String actual) {
        expect = expect.trim().replace("\r\n", "\n");
        actual = actual.trim().replace("\r\n", "\n");
        if (expect.equals(actual)) {
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!!!");
            System.out.println("Expect: ");
            System.out.println(expect);
            System.out.println("Get:");
            System.out.println(actual);
        }
    }

    private static String run(String inputStr) {
        ByteArrayInputStream in = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        go(in, new PrintStream(out));
        return out.toString();
    }

    public static void main2(String[] args) {
        go(System.in, System.out);
    }

    private static void go(InputStream in, PrintStream out) {
        final Map<String, Integer> map = new HashMap<String, Integer>();
        Scanner scanner = new Scanner(in);
        int total = scanner.nextInt();
        for (int i = 0; i < total; i++) {
            String next = scanner.next();
            String line = fix(next);
            Integer count = map.get(line);
            if (count == null) {
                map.put(line, 1);
            } else {
                map.put(line, count + 1);
            }
        }


        removeSingle(map);

        if (map.isEmpty()) {
            System.out.println("No duplicates.");
        } else {
            TreeMap<String, Integer> resultMap = new TreeMap();
            resultMap.putAll(map);
            for (String key : resultMap.keySet()) {
                out.print(key.substring(0, 3) + "-" + key.substring(3) + " ");
                int count = resultMap.get(key);
                out.println(count);
            }
        }

    }

    private static void removeSingle(Map<String, Integer> map) {
        List<String> keys = new ArrayList(map.keySet());
        for (String key : keys) {
            int count = map.get(key);
            if (count == 1) {
                map.remove(key);
            }
        }
    }

    private static String fix(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            //            A, B, and C map to 2
            //            D, E, and F map to 3
            //            G, H, and I map to 4
            //            J, K, and L map to 5
            //            M, N, and O map to 6
            //            P, R, and S map to 7
            //            T, U, and V map to 8
            //            W, X, and Y map to 9
            switch (c) {
                case '-':
                    break;
                case 'A':
                case 'B':
                case 'C':
                    sb.append(2);
                    break;
                case 'D':
                case 'E':
                case 'F':
                    sb.append(3);
                    break;
                case 'G':
                case 'H':
                case 'I':
                    sb.append(4);
                    break;
                case 'J':
                case 'K':
                case 'L':
                    sb.append(5);
                    break;
                case 'M':
                case 'N':
                case 'O':
                    sb.append(6);
                    break;
                case 'P':
                case 'R':
                case 'S':
                    sb.append(7);
                    break;
                case 'T':
                case 'U':
                case 'V':
                    sb.append(8);
                    break;
                case 'W':
                case 'X':
                case 'Y':
                    sb.append(9);
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }

}
