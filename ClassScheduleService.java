package Services;

import java.time.LocalDateTime;
import java.util.*;

public class ClassScheduleService {
    private Map<String, List<Schedule>> classSchedules = new HashMap<>();
    private ClassroomService classroomService;

    public ClassScheduleService(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    public void scheduleClass(String className, LocalDateTime startTime, LocalDateTime endTime) {
        if (!classroomService.isClassroomExists(className)) {
            System.out.println("Error: Class " + className + " does not exist.");
            return;
        }

        if (!classSchedules.containsKey(className)) {
            classSchedules.put(className, new ArrayList<>());
        }

        for (List<Schedule> schedules : classSchedules.values()) {
            for (Schedule schedule : schedules) {
                if (schedule.isOverlapping(startTime, endTime)) {
                    System.out.println("Error: Time conflict with another class.");
                    return;
                }
            }
        }

        Schedule schedule = new Schedule(className, startTime, endTime);
        classSchedules.get(className).add(schedule);
        System.out.println("Class scheduled for " + className + " from " + startTime + " to " + endTime + ".");
    }

    public List<Schedule> getClassSchedules(String className) {
        return classSchedules.getOrDefault(className, Collections.emptyList());
    }

    public void listSchedules() {
        System.out.println("Class Schedules:");
        for (List<Schedule> schedules : classSchedules.values()) {
            for (Schedule schedule : schedules) {
                System.out.println(schedule);
            }
        }
    }

    public boolean isClassScheduled(String className, LocalDateTime dateTime) {
        return classSchedules.containsKey(className) &&
               classSchedules.get(className).stream().anyMatch(schedule -> schedule.isWithin(dateTime));
    }

    public static class Schedule {
        private String className;
        private LocalDateTime startTime;
        private LocalDateTime endTime;

        public Schedule(String className, LocalDateTime startTime, LocalDateTime endTime) {
            this.className = className;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public LocalDateTime getStartTime() {
            return startTime;
        }

        public LocalDateTime getEndTime() {
            return endTime;
        }

        public boolean isWithin(LocalDateTime dateTime) {
            return !dateTime.isBefore(startTime) && !dateTime.isAfter(endTime);
        }

        public boolean isOverlapping(LocalDateTime startTime, LocalDateTime endTime) {
            return (startTime.isBefore(this.endTime) && endTime.isAfter(this.startTime));
        }

        @Override
        public String toString() {
            return "Class: " + className + ", Start Time: " + startTime + ", End Time: " + endTime;
        }
    }
}
