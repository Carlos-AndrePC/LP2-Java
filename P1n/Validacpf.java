public class Validacpf {

    public static boolean isCPF(String d){
        String s = new String();
        for(int i =0;i<d.length();i++){
            if((int)(d.charAt(i)) >47 && 58>(int)(d.charAt(i))){
                s = s + d.charAt(i);
            }
        }
        if (s.length() != 11){
            return false;
        }
        char d10, d11;
        int soma, r, num, peso;
        try{
            // 1 vereficador
            soma = 0;
            peso = 10;
            for(int i = 0 ;i<9;i++){
               num = (int)(s.charAt(i)-48);
               soma += (num *peso);
               peso--; 
            }
            r = 11 - (soma % 11);
            if((r==10)|| (r==11)){
                d10 = '0';
            }
            else d10 = (char)(r+48);
            // 2 vereficador
            soma = 0;
            peso = 11;
            for(int i = 0 ;i<10;i++){
               num = (int)(s.charAt(i)-48);
               soma += (num *peso);
               peso--; 
            }
            r = 11 - (soma % 11);
            if((r==10)|| (r==11)){
                d11 = '0';
            }
            else d11 = (char)(r+48);
        if((d10 == s.charAt(9) )&& (d11 == s.charAt(10))) return true;
        else return false;
    } catch(Exception e){
        return false;
    }
}
    public static boolean isCPF(long cpf){
        String s = String.valueOf(cpf);
        return isCPF(s);
    }

}
