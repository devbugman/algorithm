import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysOf {
    
    private static List<Pair> list;
    private static int[] dir;
    static int count = 0;


    public static void main(String[] args) {
        list = Arrays.asList(
            new Pair(4),
            new Pair(4),
            new Pair(4),
            new Pair(4),
            new Pair(4),
            new Pair(4),
            new Pair(4),
            new Pair(1)
        );
        
        dir = new int[]{0,4,2,4,4,1};
        change(new int[list.size()], 0);
        System.out.println(count);
    }

    static void change(int[] output, int depth) {
        
        if(depth == list.size()) {
            figureOutSupport(output);
            return;
        }
        count ++;
        for(int i = 1; i <= dir[list.get(depth).value]; i++) {
            output[depth] = i;
            System.out.println("i=" + i + " depth =" + depth + " dir[list.get(depth).value] = " + dir[list.get(depth).value]);
            change(output, depth + 1);
        }
    }

    static void figureOutSupport(int[] output) {
        System.out.println(Arrays.toString(output));
    }

    private static class Pair {
        int value;
        Pair(int value) {
            this.value = value;
        }
    }
}
