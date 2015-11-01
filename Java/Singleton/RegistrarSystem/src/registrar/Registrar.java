package registrar;

import java.util.*;

import exception.CourseSizeExceededException;
import exception.RegisteredSameCourseException;
/**
 * Created by Eric on 15/11/1.
 */
public class Registrar {
    private static Registrar registrar;
    private Map<CourseType, Course> courseMap = new HashMap<CourseType, Course>();

    private Registrar() {}

    public static Registrar getInstance() {
        synchronized (Registrar.class) {
            return registrar == null
                    ? registrar = new Registrar()
                    : registrar;
        }
    }

    public boolean register(CourseType courseType, Student student) throws RegisteredSameCourseException
                                                                            , CourseSizeExceededException {
        if (courseType == null)
            return false;
        if (!courseMap.containsKey(courseType))
            courseMap.put(courseType, new Course(courseType, 30));
        Course course = courseMap.get(courseType);
        return course.register(student);
    }

    public Course newCourse(CourseType courseType, int maxSize) {
        return courseMap.containsKey(courseType)
                ? courseMap.get(courseType)
                : courseMap.put(courseType, new Course(courseType, maxSize));
    }

}
