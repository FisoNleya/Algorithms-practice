package dynamic;

import java.util.LinkedList;
import java.util.Queue;


public class ValidSubSequence {

    public static void main(String[] args) {

        System.out.println(validSubSequence("ace", "abcde"));
        System.out.println(validSubSequence("aec", "abcde"));
    }

    public static boolean validSubSequence(String sub, String a) {

        Queue<Character> que = new LinkedList<>();
        for (int i = 0; i < sub.length(); i++) {
            que.add(sub.charAt(i));
        }

        for (int i = 0; i < a.length(); i++) {

            if(!que.isEmpty() && que.element() == a.charAt(i)) {
                que.remove();
            }

        }

        if (que.isEmpty())
            return true;
        return false;

    }

}
