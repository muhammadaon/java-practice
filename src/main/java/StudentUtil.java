public class StudentUtil {


    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
        double[] gpaList = new double[studentIdList.length];
        int count = 0;

        for (char[] studentGrade : studentsGrades) {
            double gpa = 0.0;

            for (char grade : studentGrade) {
                if (grade == 'A') {
                    gpa += 4.0;
                } else if (grade == 'B') {
                    gpa += 3.0;
                } else if (grade == 'C') {
                    gpa += 2.0;
                }
            }

            gpaList[count++] = gpa/studentGrade.length;
        }

        return gpaList;
    }


    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        // If we are doing parameter validation, then it generally is
        // done at the beginning of the method. This way if any of the
        // parameters are invalid, we return without performing any
        // further processing
        if (lower < 0 || higher < 0 || lower > higher) {
            return null;
        }

        double[] gpaList = calculateGPA(studentIdList, studentsGrades);

        int count = 0;
        for (double gpa : gpaList) {
            if (gpa >= lower && gpa <= higher) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i <  gpaList.length; i++) {
            if (gpaList[i] >= lower && gpaList[i] <= higher) {
                result[index++] = studentIdList[i];
            }
        }

        return result;
    }

}