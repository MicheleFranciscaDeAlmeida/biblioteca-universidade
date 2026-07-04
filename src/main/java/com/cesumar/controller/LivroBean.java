package com.cesumar.controller;

import com.cesumar.model.Livro;
import com.cesumar.model.LivroDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean(name = "livroBean")
@SessionScoped
public class LivroBean {
    private Livro livro = new Livro();
    private LivroDAO dao = new LivroDAO();

    public void cadastrar() {
        // Tratamento de erros e validações
        if (livro.getTitulo() == null || livro.getTitulo().trim().isEmpty() ||
            livro.getAutor() == null || livro.getAutor().trim().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: Título e Autor são obrigatórios.", null));
            return;
        }

        // Validação de ISBN (deve ter 13 dígitos numéricos)
        if (!livro.getIsbn().matches("\\d{13}")) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: ISBN inválido. Deve conter 13 números.", null));
            return;
        }

        // Validação de Ano
        if (livro.getAno() < 1000 || livro.getAno() > 2026) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: Ano de publicação inválido.", null));
            return;
        }

        dao.adicionar(livro);
        livro = new Livro(); // Limpa o formulário
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso: Livro cadastrado!", null));
    }

    // Getters e Setters obrigatórios para o JSF
    public Livro getLivro() { return livro; }
    public void setLivro(Livro livro) { this.livro = livro; }
}