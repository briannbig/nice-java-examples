import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPFinder {
    public static void main(String[] args) {
        try {
            InetAddress myAddress = InetAddress.getLocalHost();
            System.out.println("Local host: " + myAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
