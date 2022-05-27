import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        while (true) {
            try (ServerSocket server = new ServerSocket(8080);
                 Socket clientSocket = server.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                System.out.println("New connection accepted");
                out.println("Write your name");
                String name = in.readLine();
                out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));

                out.println("Write your surname");
                String surname = in.readLine();

                out.println("Write your age");
                int age = Integer.parseInt(in.readLine());

                out.println("Write your driver's license category");
                String category = in.readLine();

                out.println(info(name, surname, age, category));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String info(String name, String surname, int age, String category) {
        return "Your name: " + name
                + "; Your surname: " + surname
                + "; Your age: " + age
                + "; Your driver`s license category: '" + category + "'";
    }
}

