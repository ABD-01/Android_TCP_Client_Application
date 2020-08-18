// A Java program for a Server
import java.net.*;
import java.io.*;

public class Server
{
    public static void main(String args[])
    {
        if (args.length < 1) return;
        int port = Integer.parseInt(args[0]);

        // starts server and waits for a connection
        try
        {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started at port: " + port);

            System.out.println("Waiting for a client ...");

            Socket serverSocket = server.accept();
            System.out.println("Client accepted " + serverSocket.getRemoteSocketAddress());

            // takes input from the client socket
            InputStream inFromClient = serverSocket.getInputStream();
            DataInputStream in = new DataInputStream(inFromClient);

            String line = "";

            // reads message from client until "Over" is sent
            while (!line.equals("Over"))
            {
                try
                {
                    line = in.readUTF();
                    System.out.println(line);

                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");

            // close connection
            serverSocket.close();
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
}
