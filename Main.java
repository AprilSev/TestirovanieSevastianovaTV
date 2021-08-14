package JCDZ9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Eva", Arrays.asList(new Course("English"), new Course("Math"),
                new Course("Git"), new Course("Linux"), new Course("Java"))));
        students.add(new Student("Igor", Arrays.asList(new Course("English"), new Course("Math"),
                new Course("Git"), new Course("Linux"))));
        students.add(new Student("Andrey", Arrays.asList(new Course("Math"),
                new Course("Git"), new Course("Linux"), new Course("Java"))));
        students.add(new Student("Ira", Arrays.asList(new Course("Math"),
                new Course("Git"), new Course("Java"))));
        students.add(new Student("Liza", Arrays.asList(new Course("English"), new Course("Git"),
                new Course("Linux"), new Course("Java"))));
        students.add(new Student("Ura", Arrays.asList(new Course("English"), new Course("Math"),
                new Course("Git"), new Course("Linux"), new Course("Java"))));

        //Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны
        // студенты.

        students.stream()
                .map(s -> s.getCourses())
                .flatMap(f -> f.stream())
                .collect(Collectors.toSet());

        //Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных
        // (любознательность определяется количеством курсов).

        students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(2)
                .collect(Collectors.toList());

        //Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов,
        // которые посещают этот курс.

        Course course = new Course("Java");
        students.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList());

    }
}
