import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Xulin Yang, 904904
 *
 * @create 2019-11-26 0:28
 * description:
 **/

public class TCPServer {
    private ServerSocket serverSocket;

    public static final String PING = "ping";

    public static final String PONG = "pong";

    public TCPServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void run() throws IOException {
        Socket client = null;
        try {
            client = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            for (String request = reader.readLine(); request != null;
                        request = reader.readLine()) {

                System.out.println("Read from client:" + request);
                if (request.toLowerCase().equals(PING)) {
                    writer.write(PONG);
                    writer.newLine();
                    writer.flush();
                } else {
                    writer.write(request.toUpperCase());
                    writer.newLine();
                    writer.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }
}
