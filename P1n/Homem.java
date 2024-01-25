public class Homem extends Pessoa{
    int idade;
    public Homem(String n,String sn, int d,int m,int ano,long cpf,float p ,float a){
            super(n, sn, d, m, ano, cpf, p, a);
            idade = 2023-ano;
    }
    public Homem(String n,String sn, int d,int m,int ano){
        super(n, sn, d, m, ano);
        idade = 2023 - ano;
    }
    public Homem(){
        super();
    }
    public void setDataNasc(int d, int m, int ano){
        idade =2023 - ano ;
        super.setDataNasc(d, m, ano);
    }   
    public String toString(){
        return super.toString() + "\nHomem\nIdade:"+ idade;
    }
}