import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try{
            Socket socket = new Socket("localhost",8000);
            DataInputStream data = new DataInputStream(socket.getInputStream());
            DataOutputStream outPut = new DataOutputStream(socket.getOutputStream());

            System.out.println("Enter a number: ");
            int number = scanner.nextInt();
            outPut.writeInt(number);

            String result = data.readUTF();
            System.out.println("Number " + number + " = " + result );

            outPut.flush();

            outPut.close();
            socket.close();




        }catch(Exception e){
            System.out.println(e);
        }



    }
}
