package ru.nsu.seleznev.a

import ru.nsu.seleznev.a.model.GivenTasks
import ru.nsu.seleznev.a.model.Group
import ru.nsu.seleznev.a.model.Lesson
import ru.nsu.seleznev.a.model.Lessons
import ru.nsu.seleznev.a.model.Marks
import ru.nsu.seleznev.a.model.Student
import ru.nsu.seleznev.a.model.Tasks

class DSL {
    private Student student = new Student()
    private Group group = new Group()
    private GivenTasks tasks = new GivenTasks()
    private Marks marks = new Marks()
    private Tasks tasksInfo = new Tasks()
    private Lessons lessons = new Lessons();


    void student(Closure<?> closure) {
        student.student(closure)
    }

    void group(Closure<?> closure) {
        group.group(closure)
    }

    void tasksInfo(Closure<?> closure) {
        closure.setDelegate(tasksInfo)
        closure.setResolveStrategy(Closure.DELEGATE_ONLY)
        closure.call()
    }

    void marks(Closure<?> closure) {
        closure.setDelegate(marks)
        closure.setResolveStrategy(Closure.DELEGATE_ONLY)
        closure.call()
    }

    void lessons(Closure<?> closure) {
        closure.setDelegate(lessons)
        closure.setResolveStrategy(Closure.DELEGATE_ONLY)
        closure.call()
    }


    void tasks(Closure<?> closure) {
        closure.setDelegate(tasks)
        closure.setResolveStrategy(Closure.DELEGATE_ONLY)
        closure.call()
    }

    Group getGroup() {
        return group
    }

    GivenTasks getTasks() {
        return tasks
    }

    Marks getMarks() {
        return marks
    }

    Tasks getTasksInfo() {
        return tasksInfo
    }

    Lessons getLessons() {
        return lessons
    }

    Student getStudent() {
        return student
    }

    GivenTasks getGivenTasks() {
        return tasks
    }

    Marks getGivenMarks() {
        return marks
    }


    @Override
    public String toString() {
        return "DSL{" +
                "student=" + student +
                ", group=" + group +
                ", tasks=" + tasks +
                ", marks=" + marks +
                ", tasksInfo=" + tasksInfo +
                ", lessons=" + lessons +
                '}';
    }
}