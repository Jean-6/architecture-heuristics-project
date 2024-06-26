import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Log4j2
public class Task {

    private String description;
    private LocalDateTime date;
    private boolean isCompleted;

    @Override
    public String toString() {
        return "Task{" +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", isCompleted"+
                '}';
    }

    public void markAsDone(){
        this.isCompleted = true;
    }
}
