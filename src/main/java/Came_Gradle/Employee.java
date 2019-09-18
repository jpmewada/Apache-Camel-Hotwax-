package Came_Gradle;

import com.google.gson.Gson;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import org.json.simple.JSONObject;

public class Employee  {
    String name;
    int age;
    int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String toJson(){
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }
}