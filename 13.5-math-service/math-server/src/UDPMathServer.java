import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Xulin Yang, 904904
 *
 * @create 2019-11-25 16:57
 * description:
 **/

public class UDPMathServer extends MathServer {

    private DatagramSocket serverSocket;

    public UDPMathServer(int port) throws IOException {
        serverSocket = new DatagramSocket(port);
    }

    @Override
    public void run() {
        try {
            // prepare
            byte[] buffer = new byte[2048];

            // receive
            DatagramPacket request = new DatagramPacket(buffer,
                    buffer.length);
            serverSocket.receive(request);
            String input = new String(request.getData(), 0, request.getLength());
            System.out.println("UCP Read from client: " + input);

            // response
            String output = execute(input);
            output += "\n";

            byte[] outputBuffer = output.getBytes();
            DatagramPacket reply = new DatagramPacket(outputBuffer,
                    output.length(),
                    request.getAddress(),
                    request.getPort());
            serverSocket.send(reply);
        }
        catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
        finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}
