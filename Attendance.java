package Services;
import java.time.LocalDateTime;
public class Attendance {
    private String studentId;
    private String classroom;
    private LocalDateTime dateTime;

    public Attendance(String studentId, String classroom, LocalDateTime dateTime) {
        this.studentId = studentId;
        this.classroom = classroom;
        this.dateTime = dateTime;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getClassroom() {
        return classroom;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
