import java.io.*;

public class P1nX
{
    Pessoa[] arrayPessoas;
    public static void main(String[] args){
        P1nX progama = new P1nX();
        Pessoa pessoa1 = progama.pessoalinha(args);
        System.out.println(pessoa1);
        progama.encherVetPessoas();
        progama.printarrayP(pessoa1);
        System.out.println("Foram prencidas: " + Pessoa.numPessoas());
    }
    public Pessoa pessoalinha(String[] args){
        Pessoa pessoa1;
        if(args.length == 6){
            if(args[0].equalsIgnoreCase("M")){
                pessoa1 = new Homem();
                if(args[1].matches("[a-zA-Z]+")){
                    pessoa1.setNome(args[1]);
                }
                if(args[2].matches("[a-zA-Z]+")){
                    pessoa1.setNome(args[2]);
                }
                if(ValidaData.isDia(args[3]) && ValidaData.isMes(args[4]) && ValidaData.isAno(args[5])){
                    pessoa1.setDataNasc(Integer.parseInt(args[3]),Integer.parseInt(args[4]),Integer.parseInt(args[5]));
                }
            }
            else{
                pessoa1 = new Mulher();
                if(args[1].matches("[a-zA-Z]+")){
                    pessoa1.setNome(args[1]);
                }
                if(args[2].matches("[a-zA-Z]+")){
                    pessoa1.setNome(args[2]);
                }
                if(ValidaData.isDia(args[3]) && ValidaData.isMes(args[4]) && ValidaData.isAno(args[5])){
                    pessoa1.setDataNasc(Integer.parseInt(args[3]),Integer.parseInt(args[4]),Integer.parseInt(args[5]));
                }
            }
        }
        else if(args.length == 9 ) {
            if(args[0].equalsIgnoreCase("M")){
                pessoa1 = new Homem();
                if(args[1].matches("[a-zA-Z]+")){
                    pessoa1.setNome(args[1]);
                }
                if(args[2].matches("[a-zA-Z]+")){
                    pessoa1.setNome(args[2]);
                }
                if(ValidaData.isDia(args[3]) && ValidaData.isMes(args[4]) && ValidaData.isAno(args[5])){
                    pessoa1.setDataNasc(Integer.parseInt(args[3]),Integer.parseInt(args[4]),Integer.parseInt(args[5]));
                }
                if(Validacpf.isCPF(args[6])){
                    String s = new String();
                    for(int i =0;i<args[6].length();i++){
                    if((int)(args[6].charAt(i)) >47 && 58>(int)(args[6].charAt(i))){
                        s = s + args[6].charAt(i);
                    }
                    }
                    pessoa1.setCPF(Long.parseLong(s));
                }
                args[7].replace(',', '.');
                if(args[7].matches("[0-9.]+")){
                    float peso = Float.parseFloat(args[7]);
                    if(peso<200 && peso>40){
                        pessoa1.setPeso(peso);
                    }
                }
                args[8].replace(',', '.');
                if(args[8].matches("[0-9.]+")){
                    Float altura = Float.parseFloat(args[8]);
                    if(altura<3 && altura>1){
                        pessoa1.setAltura(altura);
                    }
                }
            }
            else{
                pessoa1 = new Mulher();
                if(args[1].matches("[a-zA-Z]+")){
                    pessoa1.setNome(args[1]);
                }
                if(args[2].matches("[a-zA-Z]+")){
                    pessoa1.setNome(args[2]);
                }
                if(ValidaData.isDia(args[3]) && ValidaData.isMes(args[4]) && ValidaData.isAno(args[5])){
                    pessoa1.setDataNasc(Integer.parseInt(args[3]),Integer.parseInt(args[4]),Integer.parseInt(args[5]));
                }
                if(Validacpf.isCPF(args[6])){
                    String s = new String();
                    for(int i =0;i<args[6].length();i++){
                    if((int)(args[6].charAt(i)) >47 && 58>(int)(args[6].charAt(i))){
                        s = s + args[6].charAt(i);
                    }
                    }
                    pessoa1.setCPF(Long.parseLong(s));
                }
                args[7].replace(',', '.');
                if(args[7].matches("[0-9.]+")){
                    float peso = Float.parseFloat(args[7]);
                    if(peso<200 && peso>40){
                        pessoa1.setPeso(peso);
                    }
                }
                args[8].replace(',', '.');
                if(args[8].matches("[0-9.]+")){
                    Float altura = Float.parseFloat(args[8]);
                    if(altura<3 && altura>1){
                        pessoa1.setAltura(altura);
                    }
                }
            }
        }
        else{
            pessoa1 = new Pessoa("", "", 0, 0, 0);
        }
        return pessoa1;
    }
    public void encherVetPessoas(){
        BufferedReader indata = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int n = -1;
        try {
            System.out.println("Quantas pessoas a mais você quer criar: ");
            line = indata.readLine();
            if(line.matches("[0-9]+")){
                n = Integer.parseInt(line); 
            }
            while(n<0)
            {
                System.out.println("Tem que ser um inteiro igual ou maior a 0: ");
                line = indata.readLine();
                if(line.matches("[0-9]+")){
                    n = Integer.parseInt(line); 
                }         
            }
            arrayPessoas = new Pessoa[n];
        } catch (IOException e) {
            System.out.println("Vc nao digitou um numero Inteiro.");
        }
        
        for(int i =0;i<n;i++)
        {
            try
            {
                System.out.println("Masculino(M) ou Feminino(F) ou Enter para acabar: ");
                line = indata.readLine();
                if(line.equalsIgnoreCase("M")||line.equalsIgnoreCase("Masculino"))
                {
                    arrayPessoas[i] = new Homem();
                    enchPessoa(arrayPessoas[i]);
                }
                else if(line.equalsIgnoreCase("F")||line.equalsIgnoreCase("Feminino"))
                {
                    arrayPessoas[i] = new Mulher();
                    enchPessoa(arrayPessoas[i]);
                }
                else if (line.isEmpty()){
                    return;
                }
                else{
                    i--;
                } 
            }
            catch (Exception e)
            {
                System.out.println("Não foi um genero");
            }
        }
    }
    public void enchPessoa(Pessoa p)
    {
        try {
            BufferedReader indata = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Digite o primeiro Nome: ");
            String line = indata.readLine();
            while(p.getNome().equals("")){
                if(line.matches("[a-zA-Z]+")){
                    p.setNome(line);
                }
                else{
                    System.out.println("Digite o primeiro Nome: ");
                    line = indata.readLine();
                }
            }
            System.out.println("Digite o Ultimo Nome: ");
            line = indata.readLine();
            while(p.getSobreNome().equals("")){
                if(line.matches("[a-zA-Z]+")){
                    p.setSobreNome(line);
                }
                else{
                    System.out.println("Digite o Ultimo Nome: ");
                    line = indata.readLine();
                }
            }
            System.out.println("Digite o dia de nascimento: ");
            line = indata.readLine();
            int d = 0;
            while(d == 0){
                if(line.matches("[0-9]+")&& ValidaData.isDia(line)){
                    d = Integer.parseInt(line);
                }
                else{
                    System.out.println("Digite o dia de nascimento: ");
                    line = indata.readLine();
                }
            }
            System.out.println("Digite o mes de nascimento: ");
            line = indata.readLine();
            int m = 0;
            while(m == 0){
                if(line.matches("[0-9]+")&& ValidaData.isMes(line)){
                    m = Integer.parseInt(line);
                }
                else{
                    System.out.println("Digite o mes de nascimento: ");
                    line = indata.readLine();
                }
            }
            System.out.println("Digite o ano de nascimento: ");
            line = indata.readLine();
            int ano = 0;
            while(ano == 0){
                if(line.matches("[0-9]+") && ValidaData.isAno(line)){
                    ano = Integer.parseInt(line);
                }
                else{
                    System.out.println("Digite o ano de nascimento: ");
                    line = indata.readLine();
                }
            }
            p.setDataNasc(d, m, ano);
            System.out.println("Digite o cpf(Nao obrigatorio, Enter vazio para isso): ");
            line = indata.readLine();
            while(!Validacpf.isCPF(line)){
                if(line.isEmpty()){
                    break;
                }
                System.out.println("Digite o cpf(Nao obrigatorio, Enter vazio para isso): ");
                line = indata.readLine();
            }
            if(line.isEmpty()){
                p.setCPF(0);
            }
            else{
                String s = new String();
                for(int i =0;i<line.length();i++){
                    if((int)(line.charAt(i)) >47 && 58>(int)(line.charAt(i))){
                        s = s + line.charAt(i);
                    }
                }
                p.setCPF(Long.parseLong(s));
            }
            System.out.println("Digite o Peso(Nao obrigatorio, Enter direto): ");
            line = indata.readLine();
            while(p.getPeso() == 0.0f){
                if(line.isEmpty()){
                    break;
                }
                else{
                    if(line.matches("[0-9]+.[0-9]+")){
                        float peso = Float.parseFloat(line);
                        if(peso<200 && peso>40){
                            p.setPeso(peso);
                        }
                        else{
                            System.out.println("Digite o Peso(Nao obrigatorio, Enter direto): ");
                            line = indata.readLine();
                        }
                    }
                    else{
                        System.out.println("Digite o Peso(Nao obrigatorio, Enter direto): ");
                        line = indata.readLine();
                    }
                }
            }
            System.out.println("Digite o Altura(Nao obrigatorio, Enter direto): ");
            line = indata.readLine();
            while(p.getAltura() == 0.0f){
                if(line.isEmpty()){
                    break;
                }
                else{
                    if(line.matches("[0-9].[0-9]+")){
                        float altura = Float.parseFloat(line);
                        if(altura<3 && altura>1){
                            p.setAltura(altura);
                        }
                        else{
                            System.out.println("Digite o Altura(Nao obrigatorio, Enter direto): ");
                            line = indata.readLine();
                        }
                    }
                    else{
                        System.out.println("Digite o Altura(Nao obrigatorio, Enter direto): ");
                        line = indata.readLine();
                    }
                }
            }
            
        } catch (Exception e) {
            System.out.println("Valor invalido");
        }
    }
    public void printarrayP(Pessoa p1){
        int nHomem = 0;
        int nMulher = 0;
        if(p1 instanceof Homem){
            nHomem++;
        }
        if(p1 instanceof Mulher){
            nMulher++;
        }
        for(int i = 0;i<(Pessoa.numPessoas()-1);i++){
            if(arrayPessoas[i] instanceof Homem){
                nHomem++;
            }
            if(arrayPessoas[i] instanceof Mulher){
                nMulher++;
            }
            System.out.println(arrayPessoas[i]);
        }
        System.out.println("Tem "+ nHomem + " homens e "+ nMulher +" mulheres");
    }
}