public abstract class PessoaIMC extends Pessoa{
    protected float altura;
    protected float peso;
        public PessoaIMC(){
        super();
    };
    public PessoaIMC(String n,String sn, int d,int m,int ano,float a,float p){
        super(n, sn, d, m, ano);
        setAltura(a);
        setPeso(p);
        
    }
    public PessoaIMC(String n,String sn, int d,int m,int ano,long cpf,float a,float p){
        super(n, sn, d, m, ano, cpf);
        setAltura(a);
        setPeso(p);
    }
    public void setAltura(float a){
        this.altura = a;
    }
    public void setPeso(float p){
        this.peso = p;
    }
    public float getAltura(){
        return altura;
    }
    public float getPeso(){
        return this.peso;
    }
    public static float calculaIMC(float altura, float peso){
        return peso/(altura * altura);
    }
    
    public abstract String resultIMC();

    public String toString(){
        return super.toString()+"Altura: " + this.altura + "\nPeso: " + this.peso + "\n" +"IMC: "+calculaIMC(altura, peso)+" Logo ";
    }
}
