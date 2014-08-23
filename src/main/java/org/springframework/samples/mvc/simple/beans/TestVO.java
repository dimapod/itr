package org.springframework.samples.mvc.simple.beans;

public class TestVO {
    private String name;
    private int age;

    public TestVO() {
    }

    public TestVO(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
}
