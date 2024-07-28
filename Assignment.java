package Services;


public class Assignment {
    private int assignmentNumber;
    private String details;

    public Assignment(int assignmentNumber, String details) {
        this.assignmentNumber = assignmentNumber;
        this.details = details;
    }

    public int getAssignmentNumber() {
        return assignmentNumber;
    }

    @Override
    public String toString() {
        return "Assignment #" + assignmentNumber + ": " + details;
    }
}

