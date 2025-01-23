package Assessment;
import java.sql.*;
import java.util.Scanner;

public class CourseManagementSystemDB {
    static final String DB_URL = "jdbc:mysql://localhost:3306/course_management";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = ""; 
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            while (true) {
                System.out.println("\nCourse Management System");
                System.out.println("1. Add Course");
                System.out.println("2. View Courses");
                System.out.println("3. Search Course");
                System.out.println("4. Edit Course");
                System.out.println("5. Delete Course");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline
                switch (choice) {
                    case 1:
                        addCourse(conn);
                        break;
                    case 2:
                        viewCourses(conn);
                        break;
                    case 3:
                        searchCourse(conn);
                        break;
                    case 4:
                        editCourse(conn);
                        break;
                    case 5:
                        deleteCourse(conn);
                        break;
                    case 6:
                        System.out.println("Exiting the program.");
                        return;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }

    private static void addCourse(Connection conn) throws SQLException {
        System.out.println("Add Course:");
        System.out.print("Course ID: ");
        String courseID = sc.nextLine();
        System.out.print("Course Name: ");
        String courseName = sc.nextLine();
        System.out.print("Course Fees: ");
        double courseFees = sc.nextDouble();
        sc.nextLine(); // Consume newline
        System.out.print("Course Duration: ");
        String courseDuration = sc.nextLine();
        System.out.print("Course Detail: ");
        String courseDetail = sc.nextLine();

        String sql = "INSERT INTO courses (courseID, courseName, courseFees, courseDuration, courseDetail) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, courseID);
            pstmt.setString(2, courseName);
            pstmt.setDouble(3, courseFees);
            pstmt.setString(4, courseDuration);
            pstmt.setString(5, courseDetail);
            pstmt.executeUpdate();
            System.out.println("Course added successfully!");
        }
    }

    private static void viewCourses(Connection conn) throws SQLException {
        String sql = "SELECT * FROM courses";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (!rs.isBeforeFirst()) {
                System.out.println("No courses available.");
                return;
            }
            System.out.println("\nCourses List:");
            while (rs.next()) {
                System.out.println("Course ID: " + rs.getString("courseID"));
                System.out.println("Course Name: " + rs.getString("courseName"));
                System.out.println("Course Fees: " + rs.getDouble("courseFees"));
                System.out.println("Course Duration: " + rs.getString("courseDuration"));
                System.out.println("Course Detail: " + rs.getString("courseDetail"));
                System.out.println("--------------------------");
            }
        }
    }

    private static void searchCourse(Connection conn) throws SQLException {
        System.out.print("Enter Course ID to search: ");
        String courseID = sc.nextLine();

        String sql = "SELECT * FROM courses WHERE courseID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, courseID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Course Found:");
                    System.out.println("Course ID: " + rs.getString("courseID"));
                    System.out.println("Course Name: " + rs.getString("courseName"));
                    System.out.println("Course Fees: " + rs.getDouble("courseFees"));
                    System.out.println("Course Duration: " + rs.getString("courseDuration"));
                    System.out.println("Course Detail: " + rs.getString("courseDetail"));
                } else {
                    System.out.println("Course not found!");
                }
            }
        }
    }

    private static void editCourse(Connection conn) throws SQLException {
        System.out.print("Enter Course ID to edit: ");
        String courseID = sc.nextLine();

        String checkSql = "SELECT * FROM courses WHERE courseID = ?";
        try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
            checkStmt.setString(1, courseID);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (!rs.next()) {
                    System.out.println("Course not found!");
                    return;
                }
            }
        }

        System.out.println("Editing Course:");
        System.out.print("New Course Name: ");
        String courseName = sc.nextLine();
        System.out.print("New Course Fees: ");
        double courseFees = sc.nextDouble();
        sc.nextLine(); // Consume newline
        System.out.print("New Course Duration: ");
        String courseDuration = sc.nextLine();
        System.out.print("New Course Detail: ");
        String courseDetail = sc.nextLine();

        String updateSql = "UPDATE courses SET courseName = ?, courseFees = ?, courseDuration = ?, courseDetail = ? WHERE courseID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(updateSql)) {
            pstmt.setString(1, courseName);
            pstmt.setDouble(2, courseFees);
            pstmt.setString(3, courseDuration);
            pstmt.setString(4, courseDetail);
            pstmt.setString(5, courseID);
            pstmt.executeUpdate();
            System.out.println("Course updated successfully!");
        }
    }

    private static void deleteCourse(Connection conn) throws SQLException {
        System.out.print("Enter Course ID to delete: ");
        String courseID = sc.nextLine();

        String sql = "DELETE FROM courses WHERE courseID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, courseID);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Course deleted successfully!");
            } else {
                System.out.println("Course not found!");
            }
        }
    }
}
