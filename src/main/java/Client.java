import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client implements Runnable {
    @Override
    public void run() {
        try {
            // Определяем сокет сервера
            InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 23337);
            final SocketChannel socketChannel = SocketChannel.open();
            //  подключаемся к серверу

            // Получаем входящий и исходящий потоки информации
            try (socketChannel; Scanner scanner = new Scanner(System.in)) {
                socketChannel.connect(socketAddress);

                //  Определяем буфер для получения данных
                final ByteBuffer inputBuffer = ByteBuffer.allocate(2 << 10);

                String msg;

                while (true) {
                    System.out.println("Enter message for server...");
                    msg = scanner.nextLine();
                    if ("end".equals(msg)) break;
                    socketChannel.write(ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8)));
                    Thread.sleep(2000);
                    int bytesCount = socketChannel.read(inputBuffer);
                    System.out.println(new String(inputBuffer.array(), 0, bytesCount, StandardCharsets.UTF_8).trim());
                    inputBuffer.clear();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
