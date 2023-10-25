import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println(Palindrome("A man, a plan, a canal: Panama"));
        System.out.println(Palindrome("Amy, must I jujitsu my ma"));
        System.out.println(countAscendingNumbers(5000,10000));
        System.out.println(pigLatin("I love starcraft"));
        timeTable(10);
    }

    public static boolean Palindrome(String str) {
        String nonLetters = ",.:;()[]{}!?@#$%^&* ";
        String noletter = "";
        for (int i = 0; i < str.length(); i++) {
            if (!nonLetters.contains(str.substring(i, i + 1))) {
                noletter += str.substring(i, i + 1).toLowerCase();
            }
        }
        int left = 0, right = noletter.length() - 1;
        while (left < right) {
            if (noletter.charAt(left) != noletter.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static int countAscendingNumbers(int a, int b){
        int result = 0;
        for(int i = a; i<=b; i++) {
            String numberStr = Integer.toString(i);
            boolean check = true;
            for (int j = 0; j < numberStr.length()-1; j++) {
                int a1 = i / (int) Math.pow(10, j + 1) % 10;
                int b1 = i / (int) Math.pow(10, j) % 10;
                if (b1<=a1) {
                    check = false;
                    break;
                }
            }
            if(check){
                result++;
            }
        }
        return result;
    }

    public static String pigLatin(String str){
        int a = 0;
        ArrayList<String> strseperate = new ArrayList<>();
        for(int j = 0; j< str.length(); j++){
            if(str.charAt(j) ==' ') {
                strseperate.add(str.substring(a, j));
                a = j + 1;
            }
        }
        strseperate.add(str.substring(a));
        String answer = "";
        for(int i = 0; i<strseperate.size(); i++){
            String result = "";
            if(strseperate.get(i).length()>=3){
                result = strseperate.get(i).substring(1) + strseperate.get(i).substring(0,1);
                result += "ay";
                answer += result + " ";
            } else {
                answer += strseperate.get(i) + " ";
            }
        }

        return answer;
    }

    public static void timeTable(int num){
        Integer grid = num*num;
        String a = grid.toString();
        int lengthof = a.length();
        for(int i = 1; i<=num; i++){
            for(int j =1; j<=num; j++){
                Integer result = i*j;
                String lengthofresult = result.toString();
                System.out.print(i*j);
                for(int p = 1; p<= lengthof-lengthofresult.length()+1; p++){
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }
}
