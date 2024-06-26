import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Terminal {

    private Task task;
    private TodoList todoList;

    void run(){
        while(true){
            Scanner scanner = new Scanner (System.in);
            System.out.print(System.getProperty("user.dir") + " $ ");
            String command = scanner.nextLine();
            String[] commandParts = command.split(" ");
            String baseCommand = commandParts[0];

            switch (baseCommand){
                case "add":
                    break;
                case "mark":
                    break;
                case "delete":
                    break;
                case "list":
                    break;
                case "exit":
                    System.out.println("Exiting terminal ...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("command not recognized");
            }

        }
    }
}
