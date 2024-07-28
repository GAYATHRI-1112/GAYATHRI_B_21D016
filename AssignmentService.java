package Services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AssignmentService {
    private Map<String, Set<Assignment>> classAssignments = new HashMap<>();
    private int assignmentCounter = 0;

    public int scheduleAssignment(String className, String assignmentDetails) {
        Assignment assignment = new Assignment(++assignmentCounter, assignmentDetails);
        classAssignments.putIfAbsent(className, new HashSet<>());
        classAssignments.get(className).add(assignment);
        System.out.println("Assignment scheduled: " + assignment);
        return assignment.getAssignmentNumber();
    }

    public void listAssignments() {
        System.out.println("Assignments:");
        for (Map.Entry<String, Set<Assignment>> entry : classAssignments.entrySet()) {
            String className = entry.getKey();
            Set<Assignment> assignments = entry.getValue();
            System.out.println("Class: " + className);
            assignments.forEach(System.out::println);
        }
    }

    public Assignment getAssignment(String className, int assignmentNumber) {
        if (classAssignments.containsKey(className)) {
            for (Assignment assignment : classAssignments.get(className)) {
                if (assignment.getAssignmentNumber() == assignmentNumber) {
                    return assignment;
                }
            }
        }
        return null;
    }
}
