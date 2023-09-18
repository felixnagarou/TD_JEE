package com.example.td_jee.controllers;

import com.example.td_jee.data.FakeDB;
import com.example.td_jee.models.User;
import com.example.td_jee.models.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@WebServlet(name = "SignUpServlet", value = "/auth/signUp" )
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO userDTO = new UserDTO();
        ArrayList<String> errors = new ArrayList<>();

        req.setAttribute("user", userDTO);
        req.setAttribute("mode", "signUp");

        req.getRequestDispatcher("/WEB-INF/auth/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<String> errors = new ArrayList<>();

        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Optional<User> foundUser = FakeDB.userList.stream().filter(u -> (u.getMail().equals(email) && u.getUsername().equals(username)) && u.getPassword().equals(password)).findFirst();

        if (!foundUser.isPresent()) {
            User user = new User(username, password, email);
            FakeDB.userList.add(user);
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/session/bookManagement");
        } else {
            errors.add("Not Disponible.");
            UserDTO userDTO = new UserDTO();
            userDTO.setMail(email);
            userDTO.setPassword(password);
            userDTO.setUsername(username);

            req.setAttribute("user", userDTO);
            req.setAttribute("errors", errors);
            req.setAttribute("mode", "signUp");

            req.getRequestDispatcher("/WEB-INF/auth/login.jsp").forward(req, resp);
        }
    }
}
