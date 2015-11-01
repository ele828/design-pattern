package registrar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Eric on 15/11/1.
 */
public class Student {
    private String studentId;
    private String name;
    private String classId;

    private List<Course> courses = new ArrayList<Course>();

    public Student(String studentId, String name, String classId) {
        this.studentId = studentId;
        this.name = name;
        this.classId = classId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setCourse(Course course) {
        this.courses.add(course);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (obj.getClass() != Student.class)
            return false;

        if (obj == this)
            return true;

        Student thatStudent = (Student) obj;
        return thatStudent.getStudentId().equals(studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }
}
