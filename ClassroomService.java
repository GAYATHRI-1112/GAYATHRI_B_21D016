package Services;


import java.util.HashSet;
import java.util.Set;

public class ClassroomService {
    private Set<String> classrooms = new HashSet<>();

    public void addClassroom(String className) {
        classrooms.add(className);
    }

    public void removeClassroom(String className) {
        classrooms.remove(className);
    }

    public boolean isClassroomExists(String className) {
        return classrooms.contains(className);
    }

    public void listClassrooms() {
        System.out.println("Classrooms:");
        classrooms.forEach(System.out::println);
    }
}
