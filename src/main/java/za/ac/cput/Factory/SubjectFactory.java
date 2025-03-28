package za.ac.cput.Factory;
/**

 * Author: Keewan Titus,230778577
 * Date:27/03/2025
 */
import za.ac.cput.domain.Subject;
import za.ac.cput.util.Helper;

public class SubjectFactory {
    public static Subject createSubject(String subjectId, String subjectName, String code, String department) {
        return new Subject.Builder()
                .setSubjectId(subjectId)
                .setSubjectName(subjectName)
                .setCode(code)
                .setDepartment(department)
                .build();






    }
}


