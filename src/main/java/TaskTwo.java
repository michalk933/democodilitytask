import java.util.stream.IntStream;

public class TaskTwo {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {

        System.out.println(solution(3, 2, new int[]{2, 1, 1, 0, 1}));

        System.out.println(solution(2, 2, new int[]{2, 0, 2, 0}));

        System.out.println(solution(2, 3, new int[]{0, 0, 1, 1, 2}));

        System.out.println(solution(2, 3, new int[]{0, 0, 1, 1, 3}));

    }

    private static String solution(int U, int L, int[] C) {
        if (isImpossible(U, L, C) || !validC(C)) {
            return IMPOSSIBLE;
        } else {
            return calculateResult(U, L, C);
        }
    }

    private static String calculateResult(int U, int L, int[] C) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (int aC : C) {
            if (aC == 2) {
                s1.append(1);
                s2.append(1);
                U--;
                L--;
            } else if (aC == 0) {
                s1.append(0);
                s2.append(0);
            } else if (aC == 1) {
                if (U != 0) {
                    s1.append(1);
                    s2.append(0);
                    U--;
                } else {
                    s1.append(0);
                    s2.append(1);
                    L--;
                }
            }

        }

        return formatResult(s1.toString(), s2.toString());
    }

    private static boolean validC(int[] C) {
        for (int aC : C) {
            if (0 > aC || aC > 2) {
                return false;
            }
        }
        return true;
    }

    private static String formatResult(String resultOne, String resultTwo) {
        return String.format("%1$s,%2$s", resultOne, resultTwo);
    }

    private static boolean isImpossible(int U, int L, int[] C) {
        return (U + L) != IntStream.of(C).sum();
    }

}
