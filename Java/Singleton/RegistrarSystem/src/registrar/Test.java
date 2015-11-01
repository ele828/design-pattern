package registrar;

import exception.CourseSizeExceededException;
import exception.RegisteredSameCourseException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eric on 15/11/1.
 */
public class Test {
    public static void main(String ...args) throws RegisteredSameCourseException {

        execReg(
                CourseType.English,
                new Student("20135058", "Eric", "1")
        );

        execReg(
                CourseType.English,
                new Student("20135051", "Eric", "1")
        );

        execReg(
                CourseType.English,
                new Student("20135059", "Eric", "1")
        );

        execReg(
                CourseType.English,
                new Student("20135060", "Nick", "1")
        );

        execReg(
                CourseType.Math,
                new Student("20135061", "Nick", "1")
        );


    }

    public static void execReg(CourseType courseType, Student student) {
        Registrar registrarController = Registrar.getInstance();
        registrarController.newCourse(CourseType.English, 2);

        try{
            registrarController.register(courseType, student);
        } catch(RegisteredSameCourseException ex) {
            System.err.println(ex);
        } catch(CourseSizeExceededException ex) {
            System.err.println(ex);
        }
    }

}
