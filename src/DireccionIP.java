public class DireccionIP {
    private int[] octetos = new int[4];


    DireccionIP(String direccionIP) {
        this.octetos=conseguirOctetos(direccionIP);
    }

    DireccionIP(int primerOcteto, int segundoOcteto, int tercerOcteto, int cuartoOcteto) {
        this.octetos[0] = primerOcteto;
        this.octetos[1] = segundoOcteto;
        this.octetos[2] = tercerOcteto;
        this.octetos[3] = cuartoOcteto;
    }

    DireccionIP(int[] direccionIP) {

        this.octetos = direccionIP;
    }

    private char clase(){
        if(octetos[0]>=0 && octetos[0]<128){
            return 'A';
        }else if(octetos[0]<192){
            return 'B';
        }else if(octetos[0]<224){
            return 'C';
        }
        return 'n';
    }


    private String comprobarmascaraRed(){ ;
        if(clase()=='A'){
            return "255.0.0.0";
        }
        if(clase()=='B'){
            return "255.255.0.0";
        }
        if(clase()=='C'){
            return "255.255.255.0";
        }
        return "";
    }

    private String esPublica(){
        if(clase() == 'A'){
            if(octetos[0] < 11){
                return "Es privada.";
            }
        }
        if(clase() == 'B'){
            if(octetos[0] == 172 && octetos[1] > 15 && octetos[1]<32){
                return "Es privada";
            }
        }
        if(clase() == 'C'){
            if(octetos[0]==192 && octetos[1]==168){
                return "Es privada";
            }
        }
        return "Es pública";
    }

    private String direccionRed(){ ;
        if(clase()=='A'){
            return octetos[0]+".0.0.0";
        }
        if(clase()=='B'){
            return octetos[0]+"."+octetos[1]+".0.0";
        }
        if(clase()=='C'){
            return octetos[0]+"."+octetos[1]+"."+octetos[2]+".0";
        }
        return "";
    }

    private boolean esDireccionRed(int[] direccionIP){
        if(direccionIP[3]==0){
            return true;
        }
        return false;
    }

    public String infoIP(){
        String salida="";
        salida+="Dirección IP: "+toString()+"\n";
        salida+="¿La IP es una dirección de red? "+ esDireccionRed(octetos)+"\n";
        salida+="Dirección de red: "+direccionRed()+"\n";
        salida+="Máscara de red: "+ comprobarmascaraRed()+"\n";
        salida+="Clase tipo "+ clase();
        salida+="\n"+esPublica();
        return salida;
    }

    private int[] conseguirOctetos(String direccionIP) {
        int[] octetos = new int[4];
        for (int i = 0; i < octetos.length-1; i++) {
            octetos[i]=Integer.parseInt(direccionIP.substring(0,direccionIP.indexOf('.')));
            direccionIP=direccionIP.substring(direccionIP.indexOf('.')+1,direccionIP.length());
            if(direccionIP.indexOf('.')==-1){
                octetos[3]=Integer.parseInt(direccionIP);
            }
        }
        return octetos;
    }

    public void setOctetos(int[] octetos) {
        this.octetos = octetos;
    }

    @Override
    public String toString(){
        return octetos[0]+"."+octetos[1]+"."+octetos[2]+"."+octetos[3];
    }
}
