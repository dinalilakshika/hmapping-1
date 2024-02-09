package org.example;

import org.example.config.FactoryConfiguration;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.sql.SQLOutput;
import java.util.List;



// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String [] args){

   Session session = FactoryConfiguration.getInstance().getSession();
   Transaction transaction = session.beginTransaction();

   NativeQuery nativeQuery = session.createNativeQuery("SELECT * FROM STUDENT");
    nativeQuery.addEntity(Student .class);

    List<Student> studentList = nativeQuery.list();
    for (Student s: studentList){
        System.out.println(s.getName());
    }

         transaction.commit();
                 session.close();
    }
}