package project2;

import java.util.Scanner;

public class Project2 {

    public static void makePost(User u, String p) {
        u.addPost(p);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Wellcom!!");
        System.out.println("Enter Your name: ");
        String name = input.nextLine();
        System.out.println("Enter Your surname: ");
        String surname = input.nextLine();
        System.out.println("Enter Your email: ");
        String email = input.nextLine();
        System.out.println("Enter Your username: ");
        String username = input.nextLine();
        System.out.println("Enter Your password: ");
        String password = input.nextLine();
        User u = new User(name, surname, email, username, password, 0);

        while (true) {
            System.out.println("Choose your operation: ");
            System.out.println("1- Post");
            System.out.println("2- Time Line");
            System.out.println("3- Exit");
            int choosedOp = input.nextInt();
            if (choosedOp == 1) {
                System.out.println("Enter your post: ");
                String p = input.next();
                makePost(u, p);

            } else if (choosedOp == 2) {
                viewTimeLine(u);
            } else if (choosedOp == 3) {
                u = null;
                break;
            }
        }
    }

    private static void viewTimeLine(User u) {

        throw new UnsupportedOperationException("Not supported yet.");
    }
}
