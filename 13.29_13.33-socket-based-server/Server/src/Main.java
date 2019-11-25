import java.io.IOException;

public class Main {

    public static final int DEFAULT_PORT = 8000;

    public static void main(String[] args) {
        int port;

        if (args.length < 1) {
            port = DEFAULT_PORT;
        } else {
            port = Integer.parseInt(args[0]);
        }
        System.out.println("Using port: " + port);

        try {
            TCPServer tcpServer = new TCPServer(port);
            tcpServer.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
