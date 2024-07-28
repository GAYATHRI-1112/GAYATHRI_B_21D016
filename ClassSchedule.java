package Services;

import java.time.LocalDateTime;

public class ClassSchedule {
    private String className;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public ClassSchedule(String className, LocalDateTime startTime, LocalDateTime endTime) {
        this.className = className;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getClassName() {
        return className;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Class: " + className + ", Start Time: " + startTime + ", End Time: " + endTime;
    }
}
