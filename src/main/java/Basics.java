import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Basics {



    public static void main(String[] args){

        System.out.println("Hello World!");

        double lower = 3.0;
        double higher = 4.0;

        int [] studentIdList = {1001, 1002};
        char[][] studentsGrades = { { 'A', 'A', 'A', 'B' }, { 'A', 'B', 'B' } };

        StudentUtil.getStudentsByGPA(lower, higher, studentIdList, studentsGrades);



    }


}
