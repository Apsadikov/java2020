import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.nextLine().equals("0")) {
            new Server().start(8000);
        } else {
            Client c = new Client();
            c.start("127.0.0.1", 8000);
            while (true) {
                c.sendMessage(sc.nextLine());
            }
        }
    }
}
