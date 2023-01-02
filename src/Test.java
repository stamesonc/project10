import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        //COMPLETE THIS CLASS AFTER ALL THE OTHER CLASSES

        /*
        Write a code that asks user to if they would like join your classes
        If the answer is "Yes" from user,then ask user information; firstName, lastName, age, gender, class to join
        ***If user is age is not more than 20, do not allow them to join
        ***If user wants to join any other class except Math and Science, do not allow them to join

        REMEMBER - checkAge and checkClassName methods may throw exceptions. You have to handle them

        Keep asking users the question they would to like join until you have got 3 students overall
        Create MathStudent or ScienceStudent objects based on user's answer for the class they want to join
        Print a "Congratulations! You are registered for {className} class."

        Store all these 3 objects in a collection and print them

        EXPECTED OUTPUT OF THE PROGRAM:
        Print information of all 3 students
        Print how many students are MathStudent with message -> "Math students = {numberOfMathStudents}"
        Print how many students are ScienceStudent with message -> "Science students = {numberOfScienceStudents}"
         */

        Scanner input = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int Student = 0;
        do{
            System.out.println(UserQuestions.askToJoin);
            String answer = input.next();

            if(answer.toUpperCase().startsWith("N")) continue;
            else if(answer.toUpperCase().startsWith("Y")) {
                try {
                    System.out.println(UserQuestions.askFirstName);
                    String firstName = input.next();

                    System.out.println(UserQuestions.askLastName);
                    String lastName = input.next();

                    System.out.println(UserQuestions.askAge);
                    int age = input.nextInt();
                    Permission.checkAge(age);

                    System.out.println(UserQuestions.askGender);
                    String gender = input.next();

                    System.out.println(UserQuestions.askClassName);
                    String className = input.next();
                    Permission.checkClassName(className);

                    if (className.equalsIgnoreCase("math")) students.add(
                            new MathStudent(firstName, lastName, age, gender, className));
                    else students.add(new ScienceStudent(firstName, lastName, age, gender, className));
                    Student++;

                    System.out.println("Congratulations! You are registered for " + className + " class.");
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }while (students.size() < 3);


        students.forEach(System.out::println);
        System.out.println("Math students = " + (int) students.stream().filter(element -> element.getClassName().equalsIgnoreCase("Math")).count());
        System.out.println("Science students = " + (int) students.stream().filter(element -> element.getClassName().equalsIgnoreCase("Science")).count());

    }}



