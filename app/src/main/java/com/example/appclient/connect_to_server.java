package com.example.appclient;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.*;
import java.net.*;

public class connect_to_server extends AsyncTask<Void, Void, String> {

    static String LOG_TAG;
    static Context context;
    static String ip;
    static int port;
    static String connected = "failed";

    String message = "This is a test message is from Client Application.";
    String toast_message = "Message Sent";

    static Socket clientSocket;
    static OutputStream outToServer;
    static DataOutputStream out;

    @Override
    protected String doInBackground(Void... voids) {
        connectToServer(ip, port);
        return connected;
    }

    void connectToServer(String ip, int port) {
        Log.d(LOG_TAG, "entered this activity");
        try
        {
            if (!(connected.equals("connected"))) {
                clientSocket = new Socket(ip, port);
                toast_message = "This client is connected to " + clientSocket.getRemoteSocketAddress();
                Log.d(LOG_TAG, toast_message);
                connected = "connected";

                outToServer = clientSocket.getOutputStream();
                out = new DataOutputStream(outToServer);
            }
            out.writeUTF(message + "\n");
            if (message.equalsIgnoreCase("Over")) {
                toast_message = "Closing Connection";
                out.close();
                clientSocket.close();
                connected = "completed";
            }
        }
        catch(UnknownHostException u)
        {
            toast_message = "UnknownHostException: " + u.toString();
            Log.d(LOG_TAG, toast_message);
        }
        catch(IOException i)
        {
            toast_message = " IOException: " + i.toString();
            Log.d(LOG_TAG, toast_message );
        }
        catch (Exception e)
        {
            toast_message = "Exception: " + e.toString();
            Log.d(LOG_TAG, toast_message );
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(context, toast_message, Toast.LENGTH_SHORT).show();
    }
}
