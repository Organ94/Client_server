import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("127.0.0.1", 8080);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            System.out.println(in.readLine());
            out.println(SCANNER.nextLine());

            System.out.println(in.readLine());
            System.out.println(in.readLine());
            out.println(SCANNER.nextLine());

            System.out.println(in.readLine());
            out.println(SCANNER.nextLine());

            System.out.println(in.readLine());
            out.println(SCANNER.nextLine());

            System.out.println(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
