package sample;

import java.util.Vector;

public class College {
    private final int cost_Per_Point = 300;
    private String college_Name;
    private Vector<Course> all_Courses;


    public College(String name) {
        this.college_Name = name;
        this.all_Courses = new Vector<Course>();
    }

    public int get_Revenue(Object initiator) {
        if (initiator instanceof Principle) {
            int revenue = 0;
            for (Course c : all_Courses)
                revenue += c.getPoints() * c.getRegistered_Students().size() * cost_Per_Point;
            return revenue;
        }
        else {
            System.out.println("Calling object lacks permission.");
            return -1;
        }
    }

    public void add_Course(Course course) {
        if (course != null) {
            if (!(all_Courses.contains(course))) {
                all_Courses.add(course);
                System.out.println((course.getName() + " Was added to " + this.getCollege_Name() + " College."));
            }
        }
    }
    public void register_Student_To_Course(Student student, Course course) {
        if (student != null && course != null) {
            if (all_Courses.contains(course)) {
                course.register_Student(student);
            }
        }
    }
    public void show_All_Courses() {
        for (Course c : all_Courses)
            System.out.println(c.toString());
    }

    public String getCollege_Name() { return college_Name; }
    public void setCollege_Name(String college_Name) { this.college_Name = college_Name; }

    public Vector<Course> getAll_Courses() { return all_Courses; }
    public void setAll_Courses(Vector<Course> all_Courses) { this.all_Courses = all_Courses; }
}
