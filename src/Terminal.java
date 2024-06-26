import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Scanner;

@Getter
@Setter


public class Terminal {

    private TodoList todoList;
    Terminal(){
        this.todoList = new TodoList(new ArrayList<Task>());
    }

    void run(){
        while(true){
            Scanner scanner = new Scanner (System.in);
            System.out.print(System.getProperty("user.dir") + " $ ");
            String command = scanner.nextLine();
            String[] commandParts = command.split(" ");
            String baseCommand = commandParts[0];

            switch (baseCommand){
                /*state*/
                case "progress":
                    if(commandParts.length >= 2 && commandParts.length <= 2){
                        todoList.markTaskAsProgress(Integer.parseInt(commandParts[1] ) -1);
                    }else System.out.println("Invalid command ,try : progress taskNumber ");
                    break;
                    case "pending":
                        if(commandParts.length >= 2 && commandParts.length <= 2){
                            todoList.markTaskAsPending(Integer.parseInt(commandParts[1] ) -1);
                        }else System.out.println("Invalid command ,try : pending taskNumber ");
                    break;
                case "done":
                    if(commandParts.length >= 2 && commandParts.length <= 2){
                        todoList.markTaskAsDone(Integer.parseInt(commandParts[1] ) -1);
                    }else System.out.println("Invalid command ,try -> done taskNumber ");
                    break;
                /*cmd*/
                case "add":
                    if(commandParts.length >= 2 && commandParts.length <= 2){
                        todoList.addTask(commandParts[1]);
                    }else System.out.println("Invalid command ,try : add taskName ");
                    break;
                case "remove":
                    if (commandParts.length >=2  && commandParts.length <= 2) {
                        todoList.removeTask(Integer.parseInt(commandParts[1]) - 1);
                    } else System.out.println("No task index provided.");
                    break;
                case "list":
                    todoList.displayTasks();
                    break;
                case "export":
                    System.out.println("you entered cmd : export ");
                    break;
                case "exit":
                    System.out.println("Exiting terminal ...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Command not recognized");
            }

        }
    }
}
