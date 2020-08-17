// A Java program for a Server
import java.net.*;
import java.io.*;

public class Server
{
    /*
    //initialize socket and input stream
    private Socket          serverSocket   = null;
    private ServerSocket    server   = null;
    private DataInputStream in       =  null;

    // constructor with port
    public Server(int port)
    {
        // starts server and waits for a connection
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            // takes input from the client socket
            in = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));

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
            socket.close();
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    */
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