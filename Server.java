import java.net.*;
import java.io.*;
import utils.Calc;

public class Server {
    public Server(){
        try{
            int port = Integer.parseInt(Server.ask("Port: "));
            ServerSocket server = new ServerSocket(port);
            Server.println("Server started, listening on port "+port);
            Server.println("Waiting for clients...");

            Socket client = server.accept();

            Server.println("Client connected on port: "+client.getPort());

            BufferedReader clientInput = new BufferedReader(
                new InputStreamReader(
                    client.getInputStream()
                )
            );

            PrintWriter serverOutput = new PrintWriter(
                client.getOutputStream()
            );
            
            int data = Integer.parseInt(clientInput.readLine());

            String fact = Double.toString(Calc.factorial(data));

            serverOutput.println(fact);
            serverOutput.flush();

            client.close();
        }
        catch(Exception e){
            Server.println("Exception: "+e.toString());
        }
    }   

    public static void main(String[] args) {
        new Server();
    }

    public static void println(String message){
        System.out.println(message);
    }

    public static void print(String message){
        System.out.print(message);
    }

    public static String ask(String message) throws IOException{
        Server.print(message);
        InputStreamReader userInputReader = new InputStreamReader(System.in);
        BufferedReader userInput = new BufferedReader(userInputReader);
        return userInput.readLine();
    }
}
