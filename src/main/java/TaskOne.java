
public class TaskOne {

    public static void main(String[] args) {
        int numBaseOne = 123456;
        System.out.println("Start number: " + numBaseOne + " RESULT: " + solution(numBaseOne));
        int numBaseTwo = 130;
        System.out.println("Start number: " + numBaseTwo + " RESULT: " + solution(numBaseTwo));
    }

    private static int solution(int A) {
        int[] ints = separateDigits(A);
        convertArray(ints);
        return printArray(ints);
    }

    private static void convertArray(int[] ints) {
        int lengthInt = (ints.length - 1);
        for (int i = 1; i < lengthInt; i = i + 2) {
            int tmp = ints[i];
            int last = ints[lengthInt];

            copyPartArray(ints, i);

            ints[i] = last;
            ints[i + 1] = tmp;
        }
    }

    private static Integer printArray(int[] result) {
        String stringResult = "";
        for (int num : result) {
            stringResult += num;
        }
        return Integer.valueOf(stringResult);
    }

    private static void copyPartArray(int[] ints, int i) {
        for (int j = (ints.length - 1); j > (i + 1); j--) {
            ints[j] = ints[j - 1];
        }
    }

    private static int[] separateDigits(final int num) {
        return String.valueOf(num).chars().map(Character::getNumericValue).toArray();
    }

}
