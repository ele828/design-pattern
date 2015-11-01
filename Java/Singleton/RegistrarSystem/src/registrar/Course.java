package registrar;

import exception.CourseSizeExceededException;
import exception.RegisteredSameCourseException;
import java.util.*;

/**
 * Created by Eric on 15/11/1.
 */
public class Course {
    private CourseType courseType;
    private int maxSize;
    private Map<String, Student> studentMap = new HashMap<String, Student>();

    public Course(CourseType courseType, int size) {
        this.courseType = courseType;
        this.maxSize = size;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public boolean register(Student student) throws RegisteredSameCourseException, CourseSizeExceededException {
        if(student == null)
            return false;

        if (studentMap.containsKey(student.getStudentId())) {
            System.out.println(student.getStudentId() + " registered to " + courseType +" failed!");
            throw new RegisteredSameCourseException();
        }

        if (studentMap.size() >= maxSize) {
            System.out.println(student.getStudentId() + " registered to " + courseType +" failed!");
            throw new CourseSizeExceededException();
        }

        // Add to collections
        studentMap.put(student.getStudentId(), student);
        // Retain pointer in Student
        student.setCourse(this);

        System.out.println(student.getStudentId() + " registered to " + courseType +" successfully!");

        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (obj.getClass() != Course.class)
            return false;

        if (obj == this)
            return true;

        Course thatCourse = (Course) obj;
        return thatCourse.getCourseType() == courseType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseType);
    }
}
