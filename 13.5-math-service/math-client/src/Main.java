import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Required input: <host> <tcp port> <udp port>");
            System.exit(1);
        }

        String serverName = args[0];
        int port1 = Integer.parseInt(args[1]);
        int port2 = Integer.parseInt(args[2]);

        Socket tcpClient = null;
        try {
            // prepare
            System.out.println("Connecting to " + serverName + ":" + port1);
            tcpClient = new Socket(serverName, port1);
            System.out.println("Connected to " + serverName + ":" + port1);

            // request
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(tcpClient.getOutputStream()));
            writer.write("+:12:21");
            writer.newLine();
            writer.flush();

            // receive
            // get the result from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(tcpClient.getInputStream()));
            System.out.println("TCP: " + reader.readLine());

            // end
            reader.close();
            writer.close();
            tcpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DatagramSocket udpClient = null;
        try {
            // prepare
            InetAddress host = InetAddress.getByName(args[0]);
            System.out.println("Connecting to " + serverName + ":" + port2);
            udpClient = new DatagramSocket();
            System.out.println("Connected to " + serverName + ":" + port2);

            // request
            String message = "*:12:21";
            byte[] requestMessage = message.getBytes();
            DatagramPacket request = new DatagramPacket(requestMessage, message.length(), host, port2);

            udpClient.send(request);

            // receive
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket response = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            udpClient.receive(response);
            System.out.println("UDP: " + new String(response.getData(), 0, response.getLength()));

            // end
            udpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
