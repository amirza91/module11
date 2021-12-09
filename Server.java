import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        try{
            ServerSocket socket =new ServerSocket(8000);
            Socket sock = socket.accept();
            DataInputStream data = new DataInputStream(sock.getInputStream());
            DataOutputStream outPut = new DataOutputStream(sock.getOutputStream());

            int number = data.readInt();
            System.out.println("Client: " + number);
            outPut.writeUTF(prime(number));


            outPut.flush();

            outPut.close();
            socket.close();
        }catch(Exception e){
            System.out.println(e);
        }




        }

        public static String prime(int number){
        if (number % 2 == 0 || number % 3 == 0)
            return " not prime";
        else
            return "Prime";

        }





}
