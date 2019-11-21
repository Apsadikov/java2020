import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket clientSocket;
    private BufferedReader reader;

    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            String line;
            Server.getClientList().add(this);
            while ((line = reader.readLine()) != null) {
                for (ClientThread client : Server.getClientList()) {
                    if (!client.equals(this)) {
                        writer = new PrintWriter(client.clientSocket.getOutputStream(), true);
                        writer.println(line);
                    }
                }
            }
            reader.close();
            clientSocket.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
