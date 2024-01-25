package lp2g11.biblioteca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Livro implements Serializable{
    private String livro;
    private String códigoLivro;
    private String categorias;
    private int quantidade;
    private int emprestados;

    private ArrayList<EmprestPara> Hist;
    public Livro(String nome, String codigo, String estilo, int quan,int empre){
        Hist = new ArrayList<EmprestPara>();
        this.códigoLivro = codigo;
        this.livro = nome;
        this.categorias = estilo;
        this.quantidade = quan;
        this.emprestados = empre;
    }
    public void empresta() throws CopiaNaoDisponivelEx{
        if(emprestados++>quantidade){
            throw new CopiaNaoDisponivelEx();
        }
        emprestados++;
    }
    public void devolve() throws NenhumaCopiaEmprestadaEx{
        if(emprestados==0){
            throw new NenhumaCopiaEmprestadaEx();
        }
        emprestados--;
    }
    public void addUsuarioHist(GregorianCalendar pegou,GregorianCalendar devolveu,int codUsu){
        Hist.add(new EmprestPara(pegou, devolveu, codUsu));
    }
    public String getCódigoLivro() {
        return códigoLivro;
    }
    public String getLivro() {
        return livro;
    }
    public String getCategorias() {
        return categorias;
    }
    public int getQuantidade() {
        return quantidade;
    }public int getEmprestados() {
        return emprestados;
    }
    public ArrayList<EmprestPara> getHist() {
        return Hist;
    }
    public String toString(){
        String line = "\nLivro:" + livro+"\nCodigo do livro:" + códigoLivro+"\nCategorias:"+ categorias+"\nQuantidade:"+quantidade+"\nEmprestados:"+emprestados+"\nHistorico:";
        for(int i =0;i<Hist.size();i++){
            line += Hist.get(i);
        }
        return line;
    }
}