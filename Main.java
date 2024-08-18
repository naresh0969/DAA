import java.util.Scanner;

class Main {

    public static void getAns(int i, int n, String str) {
        if (i >= n) {
            System.out.println(str);
            return;
        }

        for (int k = 0; k <= 1; k++) {
            str += Integer.toString(k);
            getAns(i + 1, n, str);

            if (str.length() > 0)
                str = str.substring(0, str.length() - 1);
        }
    }

    public static boolean isSafe(char ch, String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch)
                return false;
        }
        return true;
    }

    public static void permute(int i, int n, String s, String str) {
        if (i >= n) {
            System.out.println(str);
            return;
        }

        for (int k = 0; k < n; k++) {
            if (isSafe(s.charAt(k), str)) {
                str += s.charAt(k);
                permute(i + 1, n, s, str);
                str = str.substring(0, str.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = scanner.nextInt();

        getAns(0, n, "");

        System.out.print("Enter string: ");
        String s = scanner.next();

        permute(0, s.length(), s, "");
    }
}
