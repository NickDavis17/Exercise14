package com.company;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        serializeSimple();
        deserializeSimple();
        //ArrayList<Todos> toDoList = new ArrayList<Todos>();

    }

    static void serializeSimple(){
        Todos list = new Todos("Walk the dog", false, 0, 3, "dog");
        Todos list2 = new Todos("Pay the bills", false, 1, 1, "bills");

        // System.out.println(person);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        String json2 = gson.toJson(list2);

        try {
            FileWriter writer = new FileWriter("data.json");
            gson.toJson(list, writer);
            gson.toJson(list2, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void deserializeSimple(){
        String list1Json = " {\"body\": \"Walk the dog\", \"done\": false, \"id\": 0, \"priority\": 3, \"title\": \"dog\"}";
        String list2Json = " {\"body\": \"Pay the bills\", \"done\": false, \"id\": 1, \"priority\": 1, \"title\": \"bills\"}";
        Gson gson = new Gson();
        Todos list1 = gson.fromJson(list1Json,Todos.class);
        Todos list2 = gson.fromJson(list2Json,Todos.class);
//        a.add(list1);
//        a.add(list2);
//        System.out.println(a);
        System.out.println(list1);
        System.out.println(list1.getClass().getSimpleName());
        System.out.println(list2);
        System.out.println(list2.getClass().getSimpleName());

    }
}
class Todos{

    private String body;
    private boolean done;
    private int id;
    private int priority;
    private String title;

    public Todos(String body, boolean done, int id, int priority, String title) {
        this.body = body;
        this.done = done;
        this.id = id;
        this.priority = priority;
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Todos{" +
                "body='" + body + '\'' +
                ", done=" + done +
                ", id=" + id +
                ", priority=" + priority +
                ", title='" + title + '\'' +
                '}';
    }
}

class ToDoList{
    private Todos[] toDo;

    public ToDoList(Todos[] toDo) {
        this.toDo = toDo;
    }



    public Todos[] getToDo() {
        return toDo;
    }

    public void setToDo(Todos[] toDo) {
        this.toDo = toDo;
    }

    @Override
    public String toString() {
        return "ToDoList{" +
                "toDo=" + Arrays.toString(toDo) +
                '}';
    }
}
