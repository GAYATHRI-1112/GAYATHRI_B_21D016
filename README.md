**Virtual Classroom Manager**

**GAYATHRI B BE ECE**
**REG NO:21D016**

**Overview**
The Virtual Classroom Manager is a terminal-based application designed to manage various aspects of a virtual classroom environment. This includes classroom management, student enrollment, class scheduling, assignment management, and attendance tracking.

**Key Features**

**1)Classroom Management:**

Add new classrooms.
List all available classrooms.
Remove classrooms.

**2)Student Management:**

Enroll students into classrooms.
List all students.
List students in a specific classroom.
Check for time conflicts when enrolling students in multiple classes.

**3)Class Scheduling:**

Schedule classes for specific times and dates.
Avoid overlapping schedules for classrooms to prevent time conflicts.
List all scheduled classes.

**4)Assignment Management:**

Schedule assignments for classrooms.
Allow students to submit assignments.
List all assignments and submissions.

**5)Attendance Tracking:**

Mark attendance for scheduled classes.
List attendance records.
Prevent marking attendance for unscheduled classes or during conflicting times.

**6)Error Handling:**

Comprehensive error messages for invalid operations.
Checks for overlapping schedules during class scheduling and student enrollment.
Validation for correct date and time formats.

**Usage**
Once the application is running, you can interact with it using the following commands:

help: Display the list of available commands.

add_classroom <class_name>: Add a new classroom.

remove_classroom <class_name>: Remove an existing classroom.

add_student <student_id> <class_name>: Enroll a student in a classroom.

schedule_class <class_name> <start_time> <end_time>: Schedule a class. Time format: yyyy-MM-dd HH:mm.

mark_attendance <student_id> <class_name> <date_time>: Mark attendance for a student. Time format: yyyy-MM-dd HH:mm.

schedule_assignment <class_name> <assignment_details>: Schedule an assignment for a classroom.

submit_assignment <student_id> <class_name> <assignment_number>: Submit an assignment for a class.

list_classrooms: List all classrooms.

list_students [<class_name>]: List all students or students in a specific classroom.

list_schedules: List all class schedules.

list_assignments: List all assignments.

list_submissions: List all assignment submissions.

list_attendances: List all attendance records.

exit: Exit the application.

**Code Structure**

**service.ClassroomService**
Manages the creation, listing, and removal of classrooms.
**service.StudentService**
Manages student enrollment and listing.
Checks for time conflicts when enrolling students in classes.
**service.ClassScheduleService**
Manages class scheduling.
Prevents overlapping class schedules.
Lists scheduled classes.
**service.AttendanceService**
Manages attendance marking and listing.
Ensures attendance is marked for scheduled classes only.
**service.AssignmentService**
Manages assignment scheduling and listing.
**service.SubmissionService**
Manages assignment submissions and listing.
**Main**
The main entry point of the application.
Handles user inputs and interacts with services.
