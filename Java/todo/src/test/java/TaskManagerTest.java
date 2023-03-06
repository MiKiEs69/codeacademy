import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaskManagerTest {

    /*
    Ištestuoti funkcionalumą:
    8. grąžinti visus tasks
    1. + grąžinti completed tasks sąrašą
    2. + grąžinti active tasks sąrašą
    3. + pridėti task
    4. + ištrinti task
    5. atnaujinti
    6. grąžinti surikiuotus ASC
    7. grąžinti surikiuotus DESC
     */
    @Mock
    private TaskDao taskDao;
    @InjectMocks
    private TaskManager manager;

    private TaskManager managerSpy;



    @BeforeAll
    void setup() {
        MockitoAnnotations.openMocks(this);
        managerSpy = Mockito.spy(new TaskManager(taskDao));
    }



    @Test
    void returnsAllTasks() {

        // given
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task.Builder("test-1").build());
        tasks.add(new Task.Builder("test-2").build());

        // when
        Mockito.when(taskDao.fetchTasks()).thenReturn(tasks);

        // then
        assertEquals(
                tasks,
                manager.tasks()
        );
    }

    @Test
    void returnsAllCompletedTasks() {
        // given
        Task t1 = new Task.Builder("test-1").completed(true).build();
        List<Task> actual = List.of(
                t1,
                new Task.Builder("test-3").build()
        );
        List<Task> expected = List.of(t1);

        // when
        Mockito.when(taskDao.fetchTasks()).thenReturn(actual);

        // then
        assertEquals(
                expected,
                manager.getCompletedTasks()
        );
    }

    @Test
    void returnsAllActiveTasks() {
        // given
        Task t1 = new Task.Builder("test-1").build();
        List<Task> actual = List.of(
                t1,
                new Task.Builder("test-3").completed(true).build()
        );
        List<Task> expected = List.of(t1);

        // when
        Mockito.when(taskDao.fetchTasks()).thenReturn(actual);

        // then
        assertEquals(
                expected,
                manager.getActiveTasks()
        );
    }

    @Test
    void returnsTasksInDSCOrder() {
        // given
        Task t1 = new Task.Builder("test-1").priority(0).build();
        Task t2 = new Task.Builder("test-1").priority(1).build();
        Task t3 = new Task.Builder("test-1").priority(3).build();
        Task t4 = new Task.Builder("test-1").priority(5).build();
        List<Task> actual = List.of(t1,t2,t3,t4);
        List<Task> expected = List.of(t4,t3,t2,t1);

        // when
        Mockito.when(taskDao.fetchTasks()).thenReturn(actual);

        // then
        assertEquals(
                expected,
                manager.sortDESC()
        );
    }

    @Test
    void returnsTasksInASCOrder() {
        // given
        Task t4 = new Task.Builder("test-1").priority(0).build();
        Task t2 = new Task.Builder("test-1").priority(1).build();
        Task t3 = new Task.Builder("test-1").priority(3).build();
        Task t1 = new Task.Builder("test-1").priority(5).build();

        List<Task> actual = List.of(t1,t2,t3,t4);
        List<Task> expected = List.of(t4,t2,t3,t1);

        // when
        Mockito.when(taskDao.fetchTasks()).thenReturn(actual);

        // then
        assertEquals(
                expected,
                manager.sortASC()
        );
    }


    //        @Spy
//        TaskDao taskDaoSpy;
    @Test
    void removeTask() {

        // given
        Task t1 = new Task.Builder("test-1").build();
//        Mockito.doNothing().when(taskDao).add(any(Task.class));
//        Mockito.doNothing().when(taskDao).remove(any(Task.class));

//        Mockito.doReturn(soutAdd()).when(taskDao).add(any(Task.class));
        managerSpy.add(t1);
        Mockito.verify(managerSpy).add(t1);
      
//        Mockito.doReturn(taskDao.remove();)
//        assertEquals(t1,managerSpy.tasks().get(0));
//        managerSpy.remove(t1);
////        Mockito.verify(taskDao, Mockito.times(1)).add(t1);
//        Mockito.verify(taskDao, Mockito.times(1)).remove(t1);

//        TaskManager managerSpy = new TaskManager(taskDaoSpy);
////        managerSpy.add(t1);
//
//        // when
//        managerSpy.remove(t1);

//         then
    }

    private String soutAdd() {
        System.out.println("Task added");
        return null;
    }

    @Test
    void addsTask() {

        // given
        Task t1 = new Task.Builder("test-1").build();
//        List<Task> actual = List.of(t1);

        // when
        manager.add(t1);
        Mockito.verify(manager).add(t1);
////        Mockito.when(taskDao.fetchTasks()).thenReturn(actual);
//        Assertions.assertEquals(1, managerSpy.tasks().size());

//         then
//        Assertions.assertEquals(manager.tasks().get(0), t1);
    }




}
