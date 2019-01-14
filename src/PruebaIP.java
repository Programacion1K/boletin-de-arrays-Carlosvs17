import java.util.Arrays;

public class PruebaIP {
    public static void main(String[] args) {

        DireccionIP ip1;
        ip1 = new DireccionIP(132,25,1,20);
        DireccionIP ip2;
        ip2 = new DireccionIP(202,55,3,40);
        DireccionIP ip3 = new DireccionIP("192.168.1.3");

        System.out.println(ip1.infoIP());
        System.out.println("");
        System.out.println(ip2.infoIP());
        System.out.println("");
        System.out.println(ip3.infoIP());



    }
}
