import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Task {

    private String description;
    private LocalDate date;
    private State state;

    @Override
    public String toString() {
        return "Task{" +
                ", description='" + description + '\'' +
                ", date=" + date.toString() +
                ", status='" + state +
                '}';
    }

    public void markAsProgress(){
        this.state=State.PROGRESS;
    }
    public void markAsPending(){
        this.state=State.PENDING;
    }
    public void markAsDone(){
        this.state=State.DONE;
    }


}
