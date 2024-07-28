## GAYATHRI B BE ECE
**REG NO:21D016**
# EXERCISE 2
# Virtual Classroom Manager

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

# EXERCISE 1
 # Design Patterns Examples
   # Behavioral Design Patterns
   
**1. Observer Pattern**

Use Case: Stock Price Notifications
Description: When a stock price changes, all registered investors are notified.

**2. Strategy Pattern**

Use Case: Payment Processing
Description: Allows users to choose different payment methods (credit card, PayPal) at runtime.

  # Creational Design Patterns

**1. Singleton Pattern**

Use Case: Logger
Description: Ensures that only one instance of the Logger class exists and provides a global point of access to it.

**2. Factory Pattern**

Use Case: Shape Creation
Description: Provides an interface for creating different shapes (circle, square) without specifying the exact class of the object that will be created.

  # Structural Design Patterns

 **1. Adapter Pattern**
 
Use Case: Plug Adapter
Description: Allows an American plug to be used with a European socket by converting the interface of the plug to the socket's interface.

**2. Decorator Pattern**

Use Case: Coffee Customization
Description: Allows adding extra features (milk, sugar) to a basic coffee dynamically.
