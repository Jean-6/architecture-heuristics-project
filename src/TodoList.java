import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor

public class TodoList {

    private List<Task> tasks;

    public TodoList(){
        this.tasks = new ArrayList<>();
    }

    public void addTask(String desciption){
        tasks.add(new Task(desciption, LocalDate.now(),State.TODO));
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Task index out of range.");
        }
    }
    public void displayTasks(){
        if (tasks.size() == 0) System.out.println("TodoList is empty");
        for(int i=0;i<tasks.size();i++){
            System.out.println((i + 1) + ". "+tasks.get(i));
        }
    }

    public void exportTaskToFile(String filePath){
        File file = new File(filePath);

        try{
            FileWriter outputfile = new FileWriter(filePath);
        }catch (IOException e){
            System.out.println("");
        }
    }

    // => Separation des préoccupations

    public void markTaskAsPending(int index){
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsPending();
        } else {
            System.out.println("Task index out of range.");
        }
    }
    public void markTaskAsProgress(int index){
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsProgress();
        } else {
            System.out.println("Task index out of range.");
        }
    }
    public void markTaskAsDone(int index){
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsDone();
        } else {
            System.out.println("Task index out of range.");
        }
    }
}
