package com.example.td_jee.controllers;

import com.example.td_jee.data.FakeDB;
import com.example.td_jee.models.User;
import com.example.td_jee.models.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@WebServlet(name = "SignInServlet", value = "/auth/signIn")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO userDTO = new  UserDTO();
        ArrayList<String> errors = new ArrayList<>();

        req.setAttribute("user", userDTO);
        req.setAttribute("errors", errors);
        req.setAttribute("mode", "signIn");

        req.getRequestDispatcher("/WEB-INF/auth/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<String> errors = new ArrayList<>();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String username = req.getParameter("username");

        Optional<User> foundUser = FakeDB.userList.stream().filter(u -> (u.getPassword().equals(email) || u.getUsername().equals(username)) && u.getPassword().equals(password)).findFirst();

        if (foundUser.isPresent()){
            req.getSession().setAttribute("user", foundUser.get());
            resp.sendRedirect(req.getContextPath() + "/session/bookManagement");
        } else {
            errors.add("logs are invalid, please enter correct credentials");
            UserDTO userDTO = new UserDTO();
            userDTO.setMail(email);
            userDTO.setUsername(username);
            userDTO.setPassword(password);
            req.setAttribute("user", userDTO);
            req.setAttribute("errors", errors);
            req.setAttribute("mode", "signIn");
            req.getRequestDispatcher("/WEB-INF/auth/login.jsp").forward(req, resp);
        }
    }
}
