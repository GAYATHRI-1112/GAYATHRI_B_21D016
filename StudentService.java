package Services;

import java.util.*;

public class StudentService {
    private Map<String, Set<String>> studentClasses = new HashMap<>();

    public void addStudent(String studentId, String className, ClassScheduleService scheduleService) {
        if (!canEnrollInClass(studentId, className, scheduleService)) {
            System.out.println("Error: Time conflict with another class.");
            return;
        }

        studentClasses.putIfAbsent(studentId, new HashSet<>());
        studentClasses.get(studentId).add(className);
        System.out.println("Student " + studentId + " added to class " + className);
    }

    private boolean canEnrollInClass(String studentId, String newClassName, ClassScheduleService scheduleService) {
        Set<String> enrolledClasses = studentClasses.getOrDefault(studentId, Collections.emptySet());
        List<ClassScheduleService.Schedule> newClassSchedules = scheduleService.getClassSchedules(newClassName);

        for (String enrolledClass : enrolledClasses) {
            List<ClassScheduleService.Schedule> enrolledClassSchedules = scheduleService.getClassSchedules(enrolledClass);
            for (ClassScheduleService.Schedule newSchedule : newClassSchedules) {
                for (ClassScheduleService.Schedule enrolledSchedule : enrolledClassSchedules) {
                    if (newSchedule.isOverlapping(enrolledSchedule.getStartTime(), enrolledSchedule.getEndTime())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void listStudents() {
        System.out.println("All Students:");
        for (Map.Entry<String, Set<String>> entry : studentClasses.entrySet()) {
            System.out.println("Student ID: " + entry.getKey() + ", Classes: " + entry.getValue());
        }
    }

    public void listStudents(String className) {
        System.out.println("Students in " + className + ":");
        for (Map.Entry<String, Set<String>> entry : studentClasses.entrySet()) {
            if (entry.getValue().contains(className)) {
                System.out.println("  Student ID: " + entry.getKey());
            }
        }
    }

    public Set<String> getStudentClasses(String studentId) {
        return studentClasses.getOrDefault(studentId, Collections.emptySet());
    }
}
