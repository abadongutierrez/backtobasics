package com.jabaddon.back2basics.datastructures;

import com.jabaddon.back2basics.common.Student;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * @author Rafael Antonio Guti&eacute;rrez Turullols
 */
public class HashMapTest {

    @Test
    public void testPutNGet() {
        Student s1 = new Student(1L, "Nick", "Fury");
        Student s2 = new Student(2L, "Vicent", "Vang Gogh");
        Student[] students = new Student[]{s1, s2};
        Map<Long, Student> map = fromArrayToMap(students);
        assertThat(map.get(1L), is(s1));
        assertThat(map.get(2L), is(s2));
    }

    @Test
    public void testEquals() {
        Student s1 = new Student(1L, "Nick", "Fury");
        Student s2 = new Student(2L, "Vicent", "Vang Gogh");
        Student s3 = new Student(1L, "Scott", "Summers");
        Student[] students = new Student[]{s1, s2};
        Map<Long, Student> map = fromArrayToMap(students);

        //
        assertThat(map.containsValue(s3), is(true));
    }

    @Test
    public void testHashCode() {
        Student s1 = new Student(1L, "Nick", "Fury");
        Student s2 = new Student(2L, "Vicent", "Vang Gogh");
        Student s3 = new Student(3L, "Scott", "Fury");
        Student[] students = new Student[]{s1, s2, s3};
        Map<String, Student> map = fromArrayToMapUsingLastNameAsKey(students);

        //
        assertThat(map.get("Fury").getId(), is(not(1L)));
        assertThat(map.get("Fury").getId(), is(3L));
    }

    @Test
    public void testIterateThroughMapEntries() {
        Student s1 = new Student(1L, "Nick", "Fury");
        Student s2 = new Student(2L, "Vicent", "Vang Gogh");
        Student s3 = new Student(3L, "Scott", "Fury");
        Student[] students = new Student[]{s1, s2, s3};
        Map<Long, Student> map = fromArrayToMap(students);
        Set<Map.Entry<Long,Student>> entries = map.entrySet();
        int total = 0;
        for (Map.Entry<Long, Student> entry: entries) {
            System.out.println("Student:{" + entry.getKey() + ", " + entry.getValue().getCompleteName() + "}");
            total++;
        }
        assertThat(total, is(3));
    }

    private Map<String, Student> fromArrayToMapUsingLastNameAsKey(Student[] students) {
        HashMap<String, Student> map = new HashMap<String, Student>();
        for (Student student : students) {
            map.put(student.getLastName(), student);
        }
        return map;
    }

    private Map<Long, Student> fromArrayToMap(Student[] students) {
        HashMap<Long, Student> map = new HashMap<Long, Student>();
        for (Student student : students) {
            map.put(student.getId(), student);
        }
        return map;
    }
}
