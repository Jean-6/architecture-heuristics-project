import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Task {

    private String description;
    private LocalDate date;
    private boolean isCompleted;

    @Override
    public String toString() {
        return "Task{" +
                ", description='" + description + '\'' +
                ", date=" + date.toString() +
                ", isCompleted"+
                '}';
    }

    public void markAsDone(){
        this.isCompleted = true;
    }
}
