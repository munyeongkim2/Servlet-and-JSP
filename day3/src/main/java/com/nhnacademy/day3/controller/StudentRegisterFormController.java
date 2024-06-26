package com.nhnacademy.day3.controller;

import com.nhnacademy.day3.Gender;
import com.nhnacademy.day3.Student;
import com.nhnacademy.day3.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@RequestMapping(value = "/student/register.do", method = RequestMapping.Method.POST)
public class StudentRegisterFormController implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse response) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        Gender gender = Gender.valueOf(req.getParameter("gender"));
        int age = Integer.parseInt(req.getParameter("age"));
        //todo null check

        studentRepository.save(new Student(id,name,gender,age));

        return "redirect:/student/list.do";
    }
}
