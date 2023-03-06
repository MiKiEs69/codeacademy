import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class TaskDao {

    private final ObjectMapper mapper = new ObjectMapper();
    private List<Task> tasks;

    public TaskDao() { // throws IOException {
//        this.mapper.enable(SerializationFeature.INDENT_OUTPUT);
//
//        this.tasks = mapper.readValue(
//            new File("tasks.json"),
//            new TypeReference<List<Task>>(){}
//        );
    }

    public List<Task> fetchTasks(){
        return tasks;
    }

    public void add(Task task) {
        // validate
        tasks.add(task);
    }

    public void remove(Task task) {
        // validate
        tasks.remove(task);
        tasks = tasks.stream()
                .filter(t -> !t.equals(task))
                .peek(System.out::println)
                .collect(Collectors.toList());
        save(tasks);
    }

    private void save(List<Task> tasks) {
        try {
            mapper.writeValue(new File("tasks.json"), tasks);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(Task oldTask, Task newTask) {
        if (tasks.contains(oldTask)) {
            tasks.remove(oldTask);
            tasks.add(newTask);
            return true;
        } else
            return false;
    }

    public void removeAll(List<Task> tasks) {
        tasks.removeAll(tasks);
    }
}
