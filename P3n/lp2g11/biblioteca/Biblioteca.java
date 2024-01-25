package lp2g11.biblioteca;
import java.io.*;
import java.util.*;

public class Biblioteca {
    Hashtable<Integer,Usuário> usuarios;
    Hashtable<String,Livro> livros;
    public Biblioteca(){
        usuarios = new Hashtable<Integer,Usuário>();
        livros = new Hashtable<String,Livro>();
    }
    public void  cadastraUsuário(Usuário usu){
        usuarios.put(usu.getCódigoUsuário(), usu);
    }
    public void cadastraLivro(Livro liv){
        livros.put(liv.getCódigoLivro(), liv);
    }
    public void salvaArquivo(Hashtable<Integer,Usuário> has,String nome){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nome));
            out.writeObject(has);
            out.close();
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public void salvaArquivos(Hashtable<String,Livro> has,String nome){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nome));
            out.writeObject(has);
            out.close();
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public void lêArquivo(String nome, int i){
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(nome));
            if(i==1){
                livros = (Hashtable<String,Livro>) in.readObject();
            }
            if(i==2){
                usuarios = (Hashtable<Integer,Usuário>) in.readObject();
            }
            in.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public void emprestaLivro(Usuário usu,Livro livro){
        try {
            livro.empresta();
            GregorianCalendar dataEmprestado = new GregorianCalendar();
            GregorianCalendar dataDevolução = new GregorianCalendar(GregorianCalendar.YEAR, GregorianCalendar.MONTH, GregorianCalendar.DAY_OF_MONTH+7);
            usu.addLivroHist(dataEmprestado, dataDevolução, livro.getCódigoLivro());
            livro.addUsuarioHist(dataEmprestado, dataDevolução, usu.getCódigoUsuário());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void devolveLivro(Usuário usu,Livro livro){
        try {

            livro.devolve();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public String imprimeUsuários(){
        String line ="";
        line += usuarios.toString();
        return line;
    }
    public String imprimeLivros(){
        return livros.toString();
    }
    public Livro getLivro (String cód) throws LivroNaoCadastrado{
        return livros.get(cód);
    }
    public Usuário getUsuário(int cód) throws UsuárioNaoCadastradoEx{
        return usuarios.get(cód);
    }
    public Hashtable<String, Livro> getLivros() {
        return livros;
    }
    public Hashtable<Integer, Usuário> getUsuarios() {
        return usuarios;
    }
}
