// This Implementation is for the Client
import java.net.*;
import java.io.*;
import java.util.Scanner;


    public class Client1 {
        // initialize socket and input output streams
        private Socket socket		 = null;
        private DataInputStream input = null;
        private DataOutputStream out	 = null;

        // constructor to put ip address and port
        public Client1(String address, int port)
        {
            // This implementation is for establishing a or the connection
            try
            {
                socket = new Socket(address, port);
                System.out.println("Connected");

                // takes input from terminal
                input = new DataInputStream(System.in);

                // sends output to the socket
                out = new DataOutputStream(socket.getOutputStream());
            } catch(IOException u)
            {
                System.out.println(u);
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
        //Here is where the User will input the details and log in
        public static void main(String args[])
        {
            Scanner myObj = new Scanner(System.in);
            String iD;

            // Enter username and press Enter
            System.out.println("Enter Your ID:   ");
            iD = myObj.nextLine();

            System.out.println("Your ID is: " + iD);
            Client1 client = new Client1("127.0.0.1", 5000);
        }
    }
