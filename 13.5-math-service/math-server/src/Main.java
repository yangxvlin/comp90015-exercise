import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("required input: <tcp port number> <udp port number>");
            System.exit(2);
        }

        int tcpPort = Integer.parseInt(args[0]);
        int udpPort = Integer.parseInt(args[1]);

        try {
            TCPMathServer tcpMathServer = new TCPMathServer(tcpPort);
            System.out.println("Math TCP server is running on port: " + tcpPort);
            UDPMathServer udpMathServer = new UDPMathServer(udpPort);
            System.out.println("Math UDP server is running on port: " + udpPort);

            tcpMathServer.run();
            System.out.println("Math TCP server is closed...");
            udpMathServer.run();
            System.out.println("Math UDP server is closed...");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
