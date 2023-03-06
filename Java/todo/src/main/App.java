import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
        TaskManager manager = new TaskManager(new TaskDao());



        // add some tasks
//        Task t1 = new Task.Builder("Call Brother")
//                .build();
//        Task t2 = new Task.Builder("Order Pizza 🍕")
//                .build();
//        Task t3 = new Task.Builder("Call Mother")
//                .priority(4)
//                .build();
//
//        manager.remove(t1);
    }

    private static void print(List<Task> tasks, String printCategory) {
        System.out.printf("---- %s tasks readout ----%n", printCategory);
        for (Task task : tasks)
            System.out.println(task);
        System.out.printf("---- End of %s tasks readout ----%n%n", printCategory);

    }
}


