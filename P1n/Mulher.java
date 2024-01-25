public class Mulher extends Pessoa {
    int idade;
    public Mulher(String n,String sn, int d,int m,int ano,long cpf,float p ,float a){
            super(n, sn, d, m, ano, cpf, p, a);
            idade = 2023-ano;
    }
    public Mulher(String n,String sn, int d,int m,int ano){
        super(n, sn, d, m, ano);
        idade = 2023 - ano;
    }
    public Mulher(){
        super();
    }
    public void setDataNasc(int d, int m, int ano){
        idade = 2023 - ano;
        super.setDataNasc(d, m, ano);
    }  
    public String toString(){
        return super.toString() + "\nMulher\nIdade:"+ idade;
    }
}
