package problems;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * User: Administrator
 * Date: 13-4-25
 * Time: 上午10:20
 */
public class T1001 {

    public static void main(String[] args) {
        shouldEqual("548815620517731830194541.899025343415715973535967221869852721\n"
                    + ".00000005148554641076956121994511276767154838481760200726351203835429763013462401\n"
                    + "43992025569.928573701266488041146654993318703707511666295476720493953024\n"
                    + "29448126.764121021618164430206909037173276672\n"
                    + "90429072743629540498.107596019456651774561044010001\n"
                    + "1.126825030131969720661201",
                run("95.123 12\n"
                    + "0.4321 20\n"
                    + "5.1234 15\n"
                    + "6.7592  9\n"
                    + "98.999 10\n"
                    + "1.0100 12"));
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
        Scanner scanner = new Scanner(in);
        while (scanner.hasNext()) {
            BigDecimal r = scanner.nextBigDecimal();
            int n = scanner.nextInt();
            BigDecimal result = new BigDecimal(1);
            for (int i = 0; i < n; i++) {
                result = result.multiply(r);
            }
            out.println(fix(result));

        }
    }

    private static String fix(BigDecimal d) {
        String s = d.toPlainString();
        while (s.startsWith("0")) {
            s = s.substring(1);
        }
        while (s.endsWith("0")) {
            s = s.substring(0, s.length() - 1);
        }
        if (s.endsWith(".")) {
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }

}
