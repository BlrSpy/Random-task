import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String[] words = {"test", "a", "a", "test", "x", "x", "x", "a", "kk", "kk", "a"};
        Set<String> set = new HashSet<>(List.of(words));
        String[] str = set.toArray(new String[0]);
        int[] array = new int[str.length];

        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            int count = 0;
            for (String word : words) {
                if (word.equals(s)) {
                    count++;
                }
            }
            array[i] = count;
        }
        for (int i = 0; i < array.length; i++) {
            int max = array[i];
            for (int j = i+1; j < array.length; j++) {
                if (array[j] > max) {
                    max = array[j];
                    String s = str[j];
                    int a = array[j];
                    str[j] = str[i];
                    array[j] = array[i];
                    str[i] = s;
                    array[i] = a;
                }
            }
        }
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i] + ' ' + array[i]);
        }
    }
}