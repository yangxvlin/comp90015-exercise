import java.io.*;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String host;
        int port;

        if (args.length < 2) {
            host = "localhost";
            port = 8000;
        } else {
            host = args[0];
            port = Integer.parseInt(args[1]);
        }

        System.out.println("Connecting to host:port: " + host + ":" + port);
        try {
            Socket client = new Socket(host, port);
            System.out.println("Connected to host:port: " + host + ":" + port);
            Scanner scanner = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            System.out.print("Input string to be sent to server (q to exit): ");
            String input = scanner.nextLine();
            while (!input.equals("q")) {
                writer.write(input);
                writer.newLine();
                writer.flush();

                String response = reader.readLine();
                System.out.println("Server's response: " + response + "#");

                System.out.print("Input string to be sent to server (q to exit): ");
                input = scanner.nextLine();
            }

            reader.close();
            writer.close();
            scanner.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
