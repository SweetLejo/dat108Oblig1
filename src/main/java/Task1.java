import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class Task1 {
    public static void main(String[] args) {

        //oppgave 1a
        //The soluction does not handle exceptions
        List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");

        listen.sort((s1, s2) -> Integer.parseInt(s1) - Integer.parseInt(s2));

        System.out.println(listen);


        //oppgave 1b call

        //addition
        //BiFunction<Integer, Integer, Integer> plus = (a, b) -> a + b;
        //BiFunction<Integer, Integer, Integer> plus = Integer::sum;
        System.out.println(beregn(12,13, Integer::sum));

        //return greatest number
        //BiFunction<Integer, Integer, Integer> biggest = (a, b) -> a > b? a : b;
        System.out.println(beregn(-5, 3, (a, b) -> a > b? a : b));

        //distance
        System.out.println(beregn(54, 45, (a, b) -> Math.abs(b-a)));



    }


    //oppgave 1b
    public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> utregning){
        return utregning.apply(a, b);
    }
}