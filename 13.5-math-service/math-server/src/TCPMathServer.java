import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Xulin Yang, 904904
 *
 * @create 2019-11-25 16:57
 * description:
 **/

public class TCPMathServer extends MathServer {

    private ServerSocket serverSocket;

    public TCPMathServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    @Override
    public void run() {
        try {
            // prepare
            Socket socket = this.serverSocket.accept();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));

            // receive
            String input = reader.readLine();
            System.out.println("TCP Read from client: " + input);
            String output = execute(input);

            // response
            writer.write(output);
            writer.newLine();
            writer.flush();

            // end
            reader.close();
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
