import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor

public class TodoList {

    private List<Task> tasks;

    public void addTask(String desciption){
        tasks.add(new Task(desciption, LocalDate.now(),false));
    }

    public void removeTask(int index){
        try{
            tasks.remove(index);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error: Task index is out of bounds");
        }
    }

    public void displayTasks(){
        for(int i=0;i<tasks.size();i++){
            System.out.println((i + 1) + ". "+tasks.get(i));
        }
    }

    public void exportTaskToFile(String filePath){
        File file = new File(filePath);
    }

    public void markTask(int index ){
        try{
            tasks.get(index).markAsDone();
        }catch (ArrayIndexOutOfBoundsException e ){
            System.out.println("Error : Task index is out if bounds");
        }
    }

}
