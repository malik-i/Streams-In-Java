import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException, NoSuchFileException {
        // 1. Integer Stream
        System.out.println("------Integer Stream------");
        IntStream
                .range(1,10)
                .forEach(System.out::println);
        System.out.println();

        // 2. Integer Stream with skip
        System.out.println("------Integer Stream with Skip------");
        IntStream
                .range(1,10)
                .skip(5)
                .forEach(x-> System.out.println(x));
        System.out.println();

        // 3. Integer Stream with sum
        System.out.println("------Integer Stream with sum------");
        System.out.println(
                IntStream
                    .range(1,5)
                    .sum()
        );
        System.out.println();

        // 4. Stream.of, sorted and findFirst
        System.out.println("------Stream.of, sorted and findFirst------");
        Stream.of("Jordan", "Austin", "Malik", "Alex")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
        System.out.println();

        // 5. Stream from an Array, sort, filter and print
        System.out.println("------Stream from an Array, sort, filter and print------");
        String[] names = {"Drake", "Rick Ross", "Jay Z", "Meek Mill", "Rich Homie Quan"};
        Arrays.stream(names) // can also use Stream.of(names)
                .filter(x->x.startsWith("R"))
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        // 6. Average of squares of an int array
        System.out.println("------Average of squares of an int array------");
        Arrays.stream(new int[] {2,4,6,8,10})
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);
        System.out.println();

        // 7. Stream from a List, filter and print
        System.out.println("------Stream from a List, filter and print------");
        List<String> people = Arrays.asList("Drake", "Rick Ross", "Jay Z", "Meek Mill", "Future", "Remy Ma", "Dr. Dre");
        people
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("d"))
                .forEach(System.out::println);
        System.out.println();

        // 8. Stream rows from text files, sort, filter, and print
        System.out.println("------Stream rows from text files, sort, filter, and print------");
        Stream<String> hipHopSongs = Files.lines(Paths.get("songs.txt"));
        hipHopSongs
                .sorted()
                .filter(x -> x.length() > 13)
                .forEach(System.out::println);
        hipHopSongs.close();

        // 9. Streams rows from text file and save to List
        System.out.println("------Streams rows from text file and save to List------");
        List<String> hipHopSongs2 = Files.lines(Paths.get("songs.txt"))
                .map(String::toLowerCase)
                .filter(x -> x.contains("lo"))
                .collect(Collectors.toList());
        hipHopSongs2.forEach(x-> System.out.println(x));
        System.out.println();

        // 10. Stream rows from CSV file and count
        System.out.println("------Stream rows from CSV file and count------");
        Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
        int rowCount = (int)rows1
                .map(x -> x.length() == 3)
                .count();
        System.out.println(rowCount + " rows.");
        rows1.close();
        System.out.println();

        // 11. Stream rows from CSV file, parse data from rows
        System.out.println("------Stream rows from CSV file, parse data from rows------");
        Stream<String> rows2 = Files.lines(Paths.get("data.txt"));
        rows2
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
        rows2.close();
        System.out.println();

        // 12. Stream rows from CSV file, store fields in a HashMap
        System.out.println("------Stream rows from CSV file, store fields in a HashMap------");
        Stream<String> rows3 = Files.lines(Paths.get("data.txt"));
        Map<String, Integer> map = new HashMap<>();
        map = rows3
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .collect(Collectors.toMap(
                        x -> x[0],
                        x -> Integer.parseInt(x[1])));
        rows3.close();
        for(String key : map.keySet()){
            System.out.println(key + " " + map.get(key));
        }
        System.out.println();

        // 13. Reduction - sum
        System.out.println("------Reduction - sum------");
        double total = Stream.of(7.3, 1.5, 4.8)
                .reduce(0.0, (Double a, Double b) -> a + b); // 0.0 starting value, a is our runnig total, and b is the new item
        System.out.println("Total = " + total);
        System.out.println();

        // 14. Reduction - summary statistics
        System.out.println("------Reduction - summary statistics------");

        IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
                .summaryStatistics();
        System.out.println(summary);
        System.out.println();

    }
}
