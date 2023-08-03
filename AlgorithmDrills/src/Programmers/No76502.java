package Programmers;
import java.util.Stack;
public class No76502 {
    private boolean isCorrect(char[] str, int offset) {    //괄호들의 짝이 맞는지 확인하는 메서드
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length; i++) {
            char c = str[(offset + i) % str.length];    //offset은 시작 인덱스. 문자열 s에서 어느 위치부터 시작해서 괄호를 확인할지를 결정.
            switch (c) {
                case '(' -> stack.push(')');    // 여는 괄호를 만났을 때 닫는 괄호를 넣어준다.
                case '{' -> stack.push('}');
                case '[' -> stack.push(']');
                case ')', '}', ']' -> {    // 닫는 괄호를 만났을 때 스택의 가장 위에 있는 원소가 짝이 될 수 있는지 검사
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != c) return false;    // 스택 가장 위의 요소를 pop, 검사
                }
            }
        }
        return stack.isEmpty();    // 문자열 순회 후 모든 괄호의 짝이 맞으면 스택은 비어있을 것
    }
    public int solution(String s) {
        char[] str = s.toCharArray();
        int count = 0;
        for (int offset = 0; offset < str.length; offset++) {    //
            if (isCorrect(str, offset)) {
                count++;
            }
        }
        return count;
    }
}
