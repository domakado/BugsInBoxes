package server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    private final int port;
    public static final int PORTNUMBER = 8080;

    TCPServer(int port) { //wie der Server erstellt wird
        this.port = port;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        TCPServer tcpServer = new TCPServer(PORTNUMBER); //erstellt Server

        tcpServer.doSomething(); //baut Verbindung, lesen + schreiben mit der Verbindung
    }

    private void doSomething() throws IOException, InterruptedException {
        ServerSocket srvSocket = new ServerSocket(this.port);
        System.out.println("server socket created");
        Socket socket = srvSocket.accept();
        System.out.println("client connection accepted");

        socket.getInputStream().read();
        System.out.println("read something");

        OutputStream os = socket.getOutputStream();
        os.write("Hello World <:)".getBytes());
        System.out.println("write soemthing");

        Thread.sleep(5000); //schlafen
        System.out.println("woke up");
        os.close(); //stream schließen
    }

}
