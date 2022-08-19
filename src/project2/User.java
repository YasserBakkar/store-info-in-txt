package project2;

import java.io.BufferedReader;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class User {

    private String name;
    private String surname;
    private String email;
    private String userName;
    private String password;
    private String address;
    private ArrayList<String> posts;
    private File userFile;
    private File postFile;

    public User(String name, String surname, String email, String userName, String password, int mode) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.posts = new ArrayList<String>();
        this.userFile = new File(email + ".txt");
        this.postFile = new File(email + "posts.txt");
        if (!this.userFile.exists()) {
            try {
                userFile.createNewFile();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if(mode == 0){
        writeUserInfosTxt();
        }
    }
    
    public void writePostsToTxt(){
        try {
            FileOutputStream fos = new FileOutputStream(this.postFile);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            for (int i = 0; i < posts.size(); i++) {
                bw.write(posts.get(i));
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void writeUserInfosTxt(){
        try {
            FileOutputStream fos = new FileOutputStream(this.userFile);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            String line = this.name + "," + this.surname + "," + this.email +  "," + this.userName  + "," + this.password;
            bw.write(line);
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

   public ArrayList<String> viewProfile() {
        ArrayList<String> result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.userFile))) {
            while (bufferedReader.ready()) {
                result.add(bufferedReader.readLine());
            }
        } catch (Exception e) {
            System.out.println("bufferedReader error!");
        }
        return result;
    }

    public void addPost(String post) {
        posts.add(post);

    }

    public boolean login(String email, String pwd) {
        ArrayList<String> result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.userFile))) {
            while (bufferedReader.ready()) {
                result.add(bufferedReader.readLine());
            }
        } catch (Exception e) {
        }
        if (email.equals(result.get(2)) && pwd.equals(result.get(4))) {
            return true;
        } else {
            return false;
        }
    }

    public void signUp() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.userFile));
                PrintWriter printWriter = new PrintWriter(bufferedWriter);) {
            printWriter.println(this.name);
            printWriter.println(this.surname);
            printWriter.println(this.email);
            printWriter.println(this.userName);
            printWriter.println(this.password);
            printWriter.println(this.address);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
