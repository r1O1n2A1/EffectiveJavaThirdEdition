package java8.streams;

import java.io.InputStream;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainDemo {

    public static final List<Person> persons
            = Arrays.asList(
            new Person("Max", 18),
            new Person("Peter", 23),
            new Person("Pamela", 23),
            new Person("David", 12));

    public static List<Foo> foos = new ArrayList<>();

    public static void main(String[] args) {
        Stream.of("b1", "a1", "c2", "b3")
                .map(s -> {
                    System.out.println(s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println(s);
                    return s.startsWith("a");
                })
                .forEach(s -> System.out.println(s));

        System.out.println("! The order of the intermediate functions is important !");

        Stream.of("b1", "a1", "c2", "b3")
                .filter(s -> {
                    System.out.println(s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println(s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println(s));

        System.out.println("Java 8 streams can not be reused, " +
                "as soon as you call any terminal operation the stream is dead");

        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("b2", "c2", "d4", "a5")
                        .filter(s -> s.startsWith("a"));
        System.out.println(streamSupplier.get().noneMatch(s -> true));
        System.out.println(streamSupplier.get().anyMatch(s -> true));

        Map<Integer, List<Person>> personsByAge =
                persons.stream()
                        .collect(Collectors.groupingBy(p -> p.age));
        personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

        IntSummaryStatistics ageSummary =
                persons.stream()
                        .collect(Collectors.summarizingInt(p -> p.age));

        System.out.println(ageSummary);
        // IntSummaryStatistics{count=4, sum=76, min=12, average=19.000000, max=23}

        System.out.println(persons.stream().collect(collectPersonName()));
        //MAX|PETER|PAMELA|DAVID

        createFoosAndBars();
        foos.stream().flatMap(f -> f.bars.stream()).forEach(f -> System.out.println(f.name));
    }

    public static Collector<Person, StringJoiner, String> collectPersonName() {
        return Collector.of(
                () -> new StringJoiner("|"),
                (j,p) -> j.add(p.name.toUpperCase()),
                (j1, j2) -> j1.merge(j2),
                StringJoiner::toString
        );
    }

    public static void createFoosAndBars() {
       IntStream.range(1,4)
                .forEach(i -> foos.add(new Foo("foo" + i)));
       foos.forEach(f ->
           IntStream.range(1,4)
                   .forEach(i -> f.bars.add(new Bar("Bar" + i + "<-" + f.name)))
       );
    }
}
