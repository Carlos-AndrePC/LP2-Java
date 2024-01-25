public class ValidaData {
    public static boolean isDia(int d){
        if( d>0 && d<32){
            return true;
        }
        else return false;
    }
    public static boolean isMes(int m){
        if( m>0 && m<13){
            return true;
        }
        else return false;
    }
    public static boolean isAno(int a){
        if( a>=1908 && a<=2023){
            return true;
        }
        else return false;
    }
    public static boolean isDia(String d){
        int dn = Integer.parseInt(d);
        if( dn>0 && dn<32){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean isMes(String m){
        int mn = Integer.parseInt(m);
        if( mn>0 && mn<13){
            return true;
        }
        else return false;
    }
    public static boolean isAno(String a){
        int an = Integer.parseInt(a);
        if( an>=1908 && an<=2023){
            return true;
        }
        else return false;
    }
}
