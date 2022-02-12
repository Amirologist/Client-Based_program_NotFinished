// This Implementation is for the Client
import java.net.*;
import java.io.*;
import java.util.Scanner;


public class Client2 {
    // initialize socket and input output streams
    private Socket socket		 = null;
    private DataInputStream input = null;
    private DataOutputStream out	 = null;

    // constructor to put ip address and port
    public Client2(String address, int port)
    {
        // This implementation is fo establishing a or the connection
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            input = new DataInputStream(System.in);

            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }

        // string to read message from input
        String line = "";

        // keep reading until "Over" is input
        while (!line.equals("Over"))
        {
            try
            {
                line = input.readLine();
                out.writeUTF(line);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }

        // close the connection
        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
    //Here is where the User will input the details and log in and know of he's connecting
    public static void main(String args[])
    {
        Scanner myObj = new Scanner(System.in);
        String iD;

        // Enter username and press Enter
        System.out.println("Enter Your ID:   ");
        iD = myObj.nextLine();

        System.out.println("Your ID is: " + iD);
        Client2 client = new Client2("127.0.0.1", 5000);
    }
}
