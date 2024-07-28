package Services;

public class Student {
    private String id;
    private String classroom;

    public Student(String id, String classroom) {
        this.id = id;
        this.classroom = classroom;
    }

    public String getId() {
        return id;
    }

    public String getClassroom() {
        return classroom;
    }
}
