public class DireccionIP {
    private int[] octetos = new int[4];
    private char clase;


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

    public char getClase() {
        return clase;
    }

    private char conseguirClase(DireccionIP direccionIP) {
        char clase = 'A';
        if (direccionIP.octetos[0]<128){
            clase = 'A';
        } else if (direccionIP.octetos[0]>=128 && direccionIP.octetos[0]<192){
            clase='B';
        }else if (direccionIP.octetos[0]>=192 && direccionIP.octetos[0]<224){
            clase='C';
        }
        return clase;
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

    @Override
    public String toString(){
        return octetos[0]+"."+octetos[1]+"."+octetos[2]+"."+octetos[3];
    }
}
