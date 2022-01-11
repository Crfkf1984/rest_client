package org.example;

import org.example.configuration.MyConfig;
import org.example.entity.Todo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main( String[] args ){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication",Communication.class);
        List<Todo> list = communication.getAllTodo();
        Todo todos = communication.getTodo(14);
        Todo t = new Todo(18,"Comp", "Need off comp", "Low", "2022-01-16");
        communication.deleteTodo(18);
        //communication.saveTodo(t);
//        System.out.println(todos);
//        System.out.println(list);
    }
}
