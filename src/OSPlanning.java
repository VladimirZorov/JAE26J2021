import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        ArrayDeque<Integer> threads = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).forEach(tasks::push);

        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).forEach(threads::offer);

        int tasktToKill = Integer.parseInt(scanner.nextLine());

        boolean isKilled = false;

        int tempTasks = 0;
        int tempThreads = 0;

        while (!isKilled) {
            tempTasks = tasks.peek();
            tempThreads = threads.peek();

            if (tempTasks == tasktToKill) {
                isKilled = true;
                break;
            }

            if (tempThreads>= tempTasks) {
                tasks.poll();
                threads.pop();
            }else {
                threads.pop();
            }

        }



        System.out.printf("Thread with value %d killed task %d%n", tempThreads, tempTasks);

        threads.forEach(s -> {
            System.out.print(s);
            System.out.print(" ");
        });


    }
}
