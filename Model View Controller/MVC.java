import java.util.*;
import java.lang.*;
import java.io.*;

// Model
class Student {
    private String rollNo;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getRoll() {
        return rollNo;
    }

    public void setRoll(String r) {
        this.rollNo = r;
    }
}

// View
class StudentView {
    public void printStudentDetails(String name, String roll) {
        System.out.println("Name of the student : " + name);
        System.out.println("Roll Number of student : " + roll);
    }
}

// Controller
class Controller {
    Student model;
    StudentView view;

    Controller(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentRoll() {
        return model.getRoll();
    }

    public void setStudentRoll(String roll) {
        model.setRoll(roll);
    }

    public void updateView() {
        view.printStudentDetails(model.getName(), model.getRoll());
    }
}

public class MVC {
    public static void main(String args[]) throws Exception {
        Student model;
        StudentView view;

        model = getData();
        view = new StudentView();

        Controller c = new Controller(model, view);

        c.updateView();

        c.setStudentName("Arka");
        c.setStudentRoll("13000121058");

        c.updateView();
    }

    public static Student getData() {
        Student s = new Student();
        s.setName("Ramu");
        s.setRoll("10");
        return s;
    }
}