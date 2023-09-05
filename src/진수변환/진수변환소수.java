package 진수변환;
/**
 * 실수를 이진수로 변환 하는 클래스
 */
public class 진수변환소수 {

  /*
   * 1. 정수부 : 32 => 100000(2) 2. 소수부 : 0.625 -> 0.625 x 2 = 1.25(정수부는 버린다) -> 0.25 x 2 = 0.5 -> 0.5
   * x 2 = 1.0
   * 
   * 위에서부터 차례로 가져온다면 100000.101
   */

  public static void main(final String[] args) {
    double[] input = {0.90625, 19.6875};
    String[] output = {"0.11101", "10011.1011"};

    System.out.printf("Out of %d Cases, %1.0f were correct", input.length, test(input, output));
  }

  private static double test(final double[] input, final String[] output) {
    double score = 0;

    for (int i = 0; i < input.length; i++) {
      System.out.printf("Case %d %n", i);

      String correct = output[i];
      System.out.printf("Input : %f \t -> Expected : %s %n", input[i], output[i]);

      String str = solution(input[i]);
      System.out.printf("Your Answer : %s %n", str);

      if (str.equals(correct)) {
        score++;
      }
    }

    return score;
  }

  /**
   * 실수 받아서 이진수로 변환
   * @param num
   * @return 
   */
  private static String solution(final double num) {
    int 정수부분 = (int) num;
    double 소수부분 = num - 정수부분;
    String 정수이진문자열 = "";
    String 소수이진문자열 = "";

    do {
      정수이진문자열 = 정수부분 % 2 + 정수이진문자열;
      정수부분 /= 2;
    } while (정수부분 != 0);

    while (소수부분 != 0) {
      소수이진문자열 += ((int) (소수부분 * 2)); // 소수에 2를 곱하고 1 또는 0을 문자열에 추가
      소수부분 = (소수부분 * 2) - ((int) (소수부분 * 2)); // 소수부분의 2를 곱한뒤 정수부분 뺴서 다시 소수부분만 남기기

    }


    return 정수이진문자열 + "." + 소수이진문자열;
  }
}
