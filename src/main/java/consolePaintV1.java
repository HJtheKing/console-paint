import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class consolePaintV1 {
    char[] paint = createOutline();
    public static void main(String[] args) {
        consolePaintV1 v1 = new consolePaintV1();

        int[] arr1 = v1.getInput();
        int[] arr2 = v1.getInput();

        v1.createSquare(arr1, arr2);

        v1.printPaint(v1.paint);
        System.out.println("\n프로그램을 종료합니다.");
    }

    public char[] createOutline() {
        char[] arr = new char[2400];
        Arrays.fill(arr, ' ');
        arr[0] = '+';
        arr[79] = '+';
        arr[2320] = '+';
        arr[2399] = '+';
        for (int i = 1; i < 2399; i++) {
            if (i == 79) i += 2242;
            arr[i] = '-';
        }
        for (int i = 80; i < 2320; i++) {
            arr[i] = '|';
            if (i % 80 == 0) i += 78;
        }
        return arr;
    }

    private int[] getInput() {
        int[] arr = new int[2];
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                StringTokenizer st = new StringTokenizer(sc.nextLine(), ",");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken().stripLeading());
                if ((a > 78 || a < 1) || (b > 28 || b < 1)) {
                    throw new Exception();
                }
                arr[0] = a;
                arr[1] = b;
                break;
            } catch (Exception e) {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
        return arr;
    }
    public void printPaint(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i % 80 == 79) {
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }

    public void createSquare(int[] a, int[] b) {
        int x_max = a[0] - b[0] > 0 ? a[0] : b[0];
        int x_min = a[0] - b[0] > 0 ? b[0] : a[0];
        int y_max = a[1] - b[1] > 0 ? a[1] : b[1];
        int y_min = a[1] - b[1] > 0 ? b[1] : a[1];

        for (int i = x_min + (2320 - 80 * y_max); i <= x_max + (2320 - 80 * y_min); i++) {
            paint[i] = '*';
            if(i % 80 == x_max + (2320 - 80 * y_max) % 80) i += 79 - (x_max - x_min);
        }
    }
}
