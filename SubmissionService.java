package Services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubmissionService {
    private Map<String, Set<Submission>> studentSubmissions = new HashMap<>();

    public void submitAssignment(String studentId, String className, int assignmentNumber, AssignmentService assignmentService) {
        Assignment assignment = assignmentService.getAssignment(className, assignmentNumber);
        if (assignment == null) {
            System.out.println("Error: Assignment not found.");
            return;
        }
        Submission submission = new Submission(studentId, className, assignmentNumber);
        studentSubmissions.putIfAbsent(studentId, new HashSet<>());
        studentSubmissions.get(studentId).add(submission);
        System.out.println("Assignment submitted: " + submission);
    }

    public void listSubmissions() {
        System.out.println("Submissions:");
        for (Set<Submission> submissions : studentSubmissions.values()) {
            for (Submission submission : submissions) {
                System.out.println(submission);
            }
        }
    }

    private class Submission {
        private String studentId;
        private String className;
        private int assignmentNumber;

        public Submission(String studentId, String className, int assignmentNumber) {
            this.studentId = studentId;
            this.className = className;
            this.assignmentNumber = assignmentNumber;
        }

        @Override
        public String toString() {
            return "Student ID: " + studentId + ", Class: " + className + ", Assignment: " + assignmentNumber;
        }
    }
}
