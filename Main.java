package Services;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ClassroomService classroomService = new ClassroomService();
        ClassScheduleService scheduleService = new ClassScheduleService(classroomService);
        StudentService studentService = new StudentService();
        AttendanceService attendanceService = new AttendanceService();
        AssignmentService assignmentService = new AssignmentService();
        SubmissionService submissionService = new SubmissionService();

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        System.out.println("Welcome to the Virtual Classroom Manager!");

        while (true) {
            System.out.println("Type your command (type 'help' for command list):");
            String[] input = scanner.nextLine().split(" ", 2);
            String command = input[0];

            switch (command) {
                case "help":
                    System.out.println("Available commands:");
                    System.out.println("add_classroom <class_name>");
                    System.out.println("add_student <student_id> <class_name>");
                    System.out.println("schedule_class <class_name> <start_time> <end_time> (format: yyyy-MM-dd HH:mm)");
                    System.out.println("mark_attendance <student_id> <class_name> <date_time> (format: yyyy-MM-dd HH:mm)");
                    System.out.println("schedule_assignment <class_name> <assignment_details>");
                    System.out.println("submit_assignment <student_id> <class_name> <assignment_number>");
                    System.out.println("list_classrooms");
                    System.out.println("list_students [<class_name>]");
                    System.out.println("list_schedules");
                    System.out.println("list_assignments");
                    System.out.println("list_submissions");
                    System.out.println("list_attendances");
                    System.out.println("exit");
                    break;

                case "add_classroom":
                    if (input.length < 2) {
                        System.out.println("Error: Missing classroom name.");
                    } else {
                        classroomService.addClassroom(input[1]);
                        System.out.println("Classroom " + input[1] + " has been added.");
                    }
                    break;

                case "add_student":
                    String[] studentData = input[1].split(" ");
                    if (studentData.length < 2) {
                        System.out.println("Error: Missing student ID or class name.");
                    } else if (!classroomService.isClassroomExists(studentData[1])) {
                        System.out.println("Error: Class " + studentData[1] + " does not exist.");
                    } else {
                        studentService.addStudent(studentData[0], studentData[1], scheduleService);
                    }
                    break;

                case "schedule_class":
                    String[] scheduleData = input[1].split(" ");
                    if (scheduleData.length < 5) {
                        System.out.println("Error: Missing class name, start time, or end time.");
                    } else {
                        try {
                            LocalDateTime startTime = LocalDateTime.parse(scheduleData[1] + " " + scheduleData[2], formatter);
                            LocalDateTime endTime = LocalDateTime.parse(scheduleData[3] + " " + scheduleData[4], formatter);
                            scheduleService.scheduleClass(scheduleData[0], startTime, endTime);
                        } catch (Exception e) {
                            System.out.println("Error: Invalid date time format.");
                        }
                    }
                    break;

                case "mark_attendance":
                    String[] attendanceData = input[1].split(" ");
                    if (attendanceData.length < 4) {
                        System.out.println("Error: Missing student ID, class name, or date time.");
                    } else {
                        try {
                            LocalDateTime dateTime = LocalDateTime.parse(attendanceData[2] + " " + attendanceData[3], formatter);
                            attendanceService.markAttendance(attendanceData[0], attendanceData[1], dateTime, scheduleService, studentService);
                        } catch (Exception e) {
                            System.out.println("Error: Invalid date time format.");
                        }
                    }
                    break;

                case "schedule_assignment":
                    String[] assignmentData = input[1].split(" ", 2);
                    if (assignmentData.length < 2) {
                        System.out.println("Error: Missing class name or assignment details.");
                    } else {
                        int assignmentNumber = assignmentService.scheduleAssignment(assignmentData[0], assignmentData[1]);
                        System.out.println("Assignment " + assignmentNumber + " for " + assignmentData[0] + " has been scheduled.");
                    }
                    break;

                case "submit_assignment":
                    String[] submissionData = input[1].split(" ");
                    if (submissionData.length < 3) {
                        System.out.println("Error: Missing student ID, class name, or assignment number.");
                    } else {
                        try {
                            int assignmentNumber = Integer.parseInt(submissionData[2]);
                            submissionService.submitAssignment(submissionData[0], submissionData[1], assignmentNumber, assignmentService);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Invalid assignment number.");
                        }
                    }
                    break;

                case "list_classrooms":
                    classroomService.listClassrooms();
                    break;

                case "list_students":
                    if (input.length == 2) {
                        studentService.listStudents(input[1]);
                    } else {
                        studentService.listStudents();
                    }
                    break;

                case "list_schedules":
                    scheduleService.listSchedules();
                    break;

                case "list_assignments":
                    assignmentService.listAssignments();
                    break;

                case "list_submissions":
                    submissionService.listSubmissions();
                    break;

                case "list_attendances":
                    attendanceService.listAttendances();
                    break;

                case "exit":
                    System.out.println("Exiting the Virtual Classroom Manager. Goodbye!");
                    return;

                default:
                    System.out.println("Unknown command.");
            }
        }
    }
}
