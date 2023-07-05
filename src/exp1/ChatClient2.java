package exp1;

import java.io.*;
import java.net.*;


// Another Chat-Server program, also works
public class ChatClient2 {
    public static void main(String[] args) throws IOException {
        Socket sk = new Socket("localhost", 2000);
        BufferedReader sin = new BufferedReader(new InputStreamReader(sk.getInputStream()));
        PrintStream sout = new PrintStream(sk.getOutputStream());
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Client : ");
            String s = stdin.readLine();
            sout.println(s);
            s = sin.readLine();
            System.out.println("Server : " + s);
            if (s.equalsIgnoreCase("END") || s.equalsIgnoreCase("Bye")) {
                sout.println("BYE");
                break;
            }
        }
        sk.close();
    }
}
