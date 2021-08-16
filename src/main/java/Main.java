public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client();
        new Thread(server).start();
        System.out.println("Сервер запущен...");
        new Thread(client).start();

    }
}