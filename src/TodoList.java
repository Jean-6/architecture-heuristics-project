import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Getter
@Setter
@AllArgsConstructor
@Log4j2

public class TodoList {

    private int id;
    Task[] tasks;

   public void exportTaskToFile(){

   }
}
