package Services;

import java.time.LocalDateTime;
import java.util.*;

public class AttendanceService {
    private Map<String, List<Attendance>> studentAttendance = new HashMap<>();

    public void markAttendance(String studentId, String className, LocalDateTime dateTime, ClassScheduleService scheduleService, StudentService studentService) {
        // Check if the class is scheduled at the given dateTime
        if (!scheduleService.isClassScheduled(className, dateTime)) {
            System.out.println("Error: Class " + className + " is not scheduled at " + dateTime + ".");
            return;
        }

        // Check if the student is enrolled in the class
        if (!studentService.getStudentClasses(studentId).contains(className)) {
            System.out.println("Error: Student " + studentId + " is not enrolled in class " + className + ".");
            return;
        }

        // Mark attendance
        studentAttendance.putIfAbsent(studentId, new ArrayList<>());
        studentAttendance.get(studentId).add(new Attendance(className, dateTime));
        System.out.println("Attendance marked for Student " + studentId + " in " + className + " on " + dateTime + ".");
    }

    public void listAttendances() {
        System.out.println("All Attendances:");
        for (Map.Entry<String, List<Attendance>> entry : studentAttendance.entrySet()) {
            System.out.println("Student ID: " + entry.getKey());
            for (Attendance attendance : entry.getValue()) {
                System.out.println("  " + attendance);
            }
        }
    }

    public static class Attendance {
        private String className;
        private LocalDateTime dateTime;

        public Attendance(String className, LocalDateTime dateTime) {
            this.className = className;
            this.dateTime = dateTime;
        }

        @Override
        public String toString() {
            return "Class: " + className + ", DateTime: " + dateTime;
        }
    }
}
