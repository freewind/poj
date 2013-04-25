package problems;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * User: Administrator
 * Date: 13-4-25
 * Time: 上午10:12
 */
public class _Template {

    public static void main(String[] args) {
        shouldEqual("", run(""));
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
        // TODO
    }

}
