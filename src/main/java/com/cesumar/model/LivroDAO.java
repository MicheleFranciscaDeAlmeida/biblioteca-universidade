package com.cesumar.model;

import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    // Base de dados em memória (Singleton simples)
    private static List<Livro> acervo = new ArrayList<>();

    public void adicionar(Livro livro) {
        acervo.add(livro);
    }

    public List<Livro> listar() {
        return new ArrayList<>(acervo);
    }

    public void excluirPorIsbn(String isbn) {
        acervo.removeIf(l -> l.getIsbn().equals(isbn));
    }
}