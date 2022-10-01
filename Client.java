import java.net.*;
import java.io.*;
import utils.Calc;

public class Client {
    public Client(){
        try{
            int serverPort = Integer.parseInt(Client.ask("Server Port: "));
            Socket connection = new Socket(InetAddress.getLocalHost(),serverPort);
            Client.println("Client connected to server.");

            PrintWriter clientOutput = new PrintWriter(
                connection.getOutputStream()
            );

            BufferedReader serverInput = new BufferedReader(
                new InputStreamReader(
                    connection.getInputStream()
                )
            );

            clientOutput.println("5");

            clientOutput.flush();

            Client.print("Factorial of 5: ");
            Client.print(serverInput.readLine());

            connection.close();

        }
        catch(Exception e){
            Client.println("Exception: "+e.toString());
        }
    }   

    public static void main(String[] args) {
        new Client();
    }

    public static void println(String message){
        System.out.println(message);
    }

    public static void print(String message){
        System.out.print(message);
    }

    public static String ask(String message) throws IOException{
        Client.print(message);
        InputStreamReader userInputReader = new InputStreamReader(System.in);
        BufferedReader userInput = new BufferedReader(userInputReader);
        return userInput.readLine();
    }
}
