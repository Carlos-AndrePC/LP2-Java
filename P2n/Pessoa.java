import java.util.Calendar;
import java.util.GregorianCalendar;

public class Pessoa{
    private String nome;
    private String sobreNome;
    private GregorianCalendar dataNasc;
    private long numCPF;
    private static int id = 0;
    public Pessoa(){
        nome = "";
        sobreNome = "";
        this.setDataNasc(1, 1, 1000);
        numCPF = 0;
        id++;
    }
    public Pessoa(String n,String sn, int d,int m,int ano){
        this.setNome(n);
        this.setSobreNome(sn);
        this.setDataNasc(d, m, ano);
        numCPF = 0;
        id++;
    }
    public Pessoa(String n,String sn, int d,int m,int ano,long cpf){
        this.setNome(n);
        this.setSobreNome(sn);
        this.setDataNasc(d, m, ano);
        this.setCPF(cpf);
        id++;
    }
    public String toString(){
        return "Nome: "+ nome +" "+ sobreNome+"\nNasceu:"+ dataNasc.get(Calendar.DATE)+"/"+ dataNasc.get(Calendar.MONTH)+"/"+dataNasc.get(Calendar.YEAR) +"\nCPF:"+ numCPF+"\n";
    }
    public void setNome(String s){
        nome = s;
    }
    public void setSobreNome(String s){
        sobreNome = s;
    }
    public void setDataNasc(int d, int m, int a){
        dataNasc = new GregorianCalendar(a,m,d);
    }
    public void setCPF(long i){
        numCPF = i;
    }
    public String getNome(){
        return nome;
    }
    public String getSobreNome(){
        return sobreNome;
    }
    public GregorianCalendar getDataNasc(){
        return dataNasc;
    }
    public long  getCPF(){
        return numCPF;
    }
    public static int numPessoas(){
        return id;
    }
}