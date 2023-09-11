package com.example.td_jee.controllers;

import com.example.td_jee.data.FakeDB;
import com.example.td_jee.models.Book;
import com.example.td_jee.models.BookDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@WebServlet(name = "BookDetailServlet", value = "session/favorites")
public class BookDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookIsbn = req.getParameter("isbn");
        ArrayList<String> errors = new ArrayList<>();

        Optional<Book> bookFound = FakeDB.bookList.stream().filter(book -> book.getIsbn().equals(bookIsbn)).findFirst();

        if (bookFound.isPresent()){
            BookDTO bookDTO = new BookDTO(
                    bookFound.get().getTitle(),
                    bookFound.get().getAuthor(),
                    bookFound.get().getPublicationType(),
                    bookFound.get().getPublicationDate(),
                    bookFound.get().getEditor(),
                    bookFound.get().getIsbn()
            );
            req.setAttribute("book", bookDTO);
            req.setAttribute("mode", "consultFavBooks");
            req.getRequestDispatcher("/WEB-INF/session/bookManagement.jsp").forward(req, resp);
        } else {
            req.setAttribute("mode", "showAll");
            resp.sendRedirect(req.getContextPath() + "/sessions/favoriteBooks");
        }


    }
}
