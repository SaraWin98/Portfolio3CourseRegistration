package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class Course {

    private String name;

    //A course has an observable array list of all the enrolled students.
    //and in another observable list the grade of that student at the corresponding index
    private ObservableList<Student> enrolledStudents = FXCollections.observableArrayList();
    private ObservableList<Grade> gradesOfStudents = FXCollections.observableArrayList();


    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObservableList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public ObservableList<Grade> getGradesOfStudents() {
        return gradesOfStudents;
    }

    public void setGradesOfStudents(ObservableList<Grade> gradesOfStudents) {
        this.gradesOfStudents = gradesOfStudents;
    }
    //A method that returns the average grade of the course through a prepared statement and SQL query.
    public String averageGradeOfCourse(GradeModel gradeModel) throws SQLException {
        return gradeModel.courseAVGPreparedStatement(this.name);
    }

    public boolean enrollStudent(Student student){
        return enrolledStudents.add(student);
    }

    @Override
    public String toString() {
        return name;
    }
}
