package com.jabaddon.back2basics.common;

/**
 * @author Rafael Antonio Guti&eacute;rrez Turullols
 */
public class Student {
    protected Long id;
    protected String name;
    protected String lastName;

    public Student(Long id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (!id.equals(student.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public Object getCompleteName() {
        return getName() + " " + getLastName();
    }
}
