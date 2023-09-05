package 대소문자;

public class 대소문자바꾸기 {
    private static double correctCount = 0;
    private static final String[][] TESTCASES = new String[][] {
        { "MANGO", "mango" }, 
        { "peach", "PEACH" },
        { "Apple", "aPPLE" }, 
        { "baNANa", "BAnanA" }, 
        { "Believe In YourSelF", "bELIEVE iN yOURsELf" }, 
        { "THiS is how LIFE is!!", "thIs IS HOW life IS!!" }, 
        { "Li^^ve  p$osi&TIVE*", "lI^^VE  P$OSI&tive*" }, 
        { "%tiMe~~~~ iS>.< gggggolD ?:)", "%TImE~~~~ Is>.< GGGGGOLd ?:)" }
    };

    public static void main(String[] args) {
        for (int i = 0; i < TESTCASES.length; i++) 
            System.out.println("Testcase " + i + " = " + test(TESTCASES[i][0], TESTCASES[i][1]));

        System.out.println("정답률 = " + (int)(correctCount / 8 * 100) + "%");
    }

    private static boolean test(String input, String answer) {
        boolean res = solution(input).equals(answer);
        if (res)
            correctCount++;
        return res;
    }


        public static String solution(String input) {
        
        char[] chArr = input.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < chArr.length ; i++ ){
            char ch = chArr[i];

            if(ch >= 'a' && ch <= 'z'){
                ch -= 32;
            }else if(ch >= 'A' && ch <= 'Z'){
                ch += 32;
            }
            sb.append((char)ch);
        }
      
        return sb.toString();
    }

    //     public static String solution(String input) {

    //     String s = "";
    //     for(int d : input.getBytes()){
            
    //         s += (char)(d ^ 32);
    //     }
      
    //     return s;
    // }
}