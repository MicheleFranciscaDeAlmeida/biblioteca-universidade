package com.cesumar.controller;

import com.cesumar.model.LivroDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/livros")
public class LivroServlet extends HttpServlet {
    private LivroDAO dao = new LivroDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("livros", dao.listar());
        req.getRequestDispatcher("/listar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String isbn = req.getParameter("isbnExcluir");
        if (isbn != null && !isbn.trim().isEmpty()) {
            dao.excluirPorIsbn(isbn);
        }
        resp.sendRedirect(req.getContextPath() + "/livros");
    }
    
    // Método público para o JSF Bean acessar o mesmo DAO
    public LivroDAO getDao() { return dao; }
}