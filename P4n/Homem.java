public class Homem extends PessoaIMC{
    private int idade;
    public Homem(String n,String sn, int d,int m,int ano,long cpf,float a ,float p){
            super(n, sn, d, m, ano, cpf, a, p);
            idade = 2023-ano;
    }
    public Homem(String n,String sn, int d,int m,int ano,float a,float p){
        super(n, sn, d, m, ano,a,p);
        idade = 2023 - ano;
    }
    public void setDataNasc(int d, int m, int ano){
        idade =2023 - ano ;
        super.setDataNasc(d, m, ano);
    }   
    
    public String resultIMC() {
        float IMC = calculaIMC(altura,peso);
        if(IMC<20.7){
            return "esta abaixo do peso ideal \n";
        }
        else if(IMC<=26.4){
            return "esta no Peso Ideal \n";
        }
        else{
            return "esta acima do peso \n";
        }
    }
    public int getIdade(){
        return idade;
    }
    public String toString(){
        return super.toString()+ resultIMC() + "Homem\nIdade:"+ idade;
    }
}