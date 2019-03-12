import java.util.List;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static Predicate<Integer> isPrime(){
        return p -> !IntStream.range(2, p / 2)
                .filter(divisor -> (p % divisor == 0))
                .findFirst()
                .isPresent();
    }

    public static void main(String[] args) {
        IntStream rangeToCheck = IntStream.range(2, 100);
        List<Integer> primes = rangeToCheck
                .boxed()
                .filter(isPrime())
                .collect(Collectors.toList());

        primes.forEach(System.out::println);
    }

}
