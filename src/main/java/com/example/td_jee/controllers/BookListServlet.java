package com.example.td_jee.controllers;

import com.example.td_jee.data.FakeDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="BookListServlet",value ="/session/favoriteBooks" )

public class BookListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("bookList", FakeDB.bookList);
        req.getRequestDispatcher("/WEB-INF/session/favoriteBooks.jsp").forward(req, resp);
    }
}
