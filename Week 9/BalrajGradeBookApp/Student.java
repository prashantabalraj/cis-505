/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.

Balraj, P. (2026). CIS 505 Intermediate Java Programming.
Bellevue University.
*/

/*
 * The Student class stores information about a student.
 * This includes the student's first name, last name,
 * course name, and grade.
 */
public class Student
{
    // Class variables
    private String firstName;
    private String lastName;
    private String course;
    private String grade;

    /*
     * Default constructor.
     */
    public Student()
    {

    }

    /*
     * Parameterized constructor.
     *
     * @param firstName Student first name.
     * @param lastName Student last name.
     * @param course Course name.
     * @param grade Student grade.
     */
    public Student(String firstName, String lastName,
                   String course, String grade)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.grade = grade;
    }

    /*
     * Returns the first name.
     *
     * @return firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /*
     * Sets the first name.
     *
     * @param firstName Student first name.
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /*
     * Returns the last name.
     *
     * @return lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /*
     * Sets the last name.
     *
     * @param lastName Student last name.
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /*
     * Returns the course name.
     *
     * @return course
     */
    public String getCourse()
    {
        return course;
    }

    /*
     * Sets the course name.
     *
     * @param course Course name.
     */
    public void setCourse(String course)
    {
        this.course = course;
    }

    /*
     * Returns the student grade.
     *
     * @return grade
     */
    public String getGrade()
    {
        return grade;
    }

    /*
     * Sets the student grade.
     *
     * @param grade Student grade.
     */
    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    /*
     * Returns the student information as a String.
     *
     * @return Student information.
     */
    @Override
    public String toString()
    {
        return "First Name: " + firstName
                + " | Last Name: " + lastName
                + " | Course: " + course
                + " | Grade: " + grade;
    }
}