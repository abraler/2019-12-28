package v2;

import v2.servlet.HttpServlet;
import v2.servlet.JokeJSServlet;

import java.net.Socket;

public class Task implements Runnable {
    private Socket socket;

    public Task(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 读取并解析请求 -> 处理业务 -> 组装并发送响应

            // 1. 读取并解析请求
            Request request = Request.parse(socket.getInputStream());
            Response response = new Response();

            // 2. 处理业务
            if (request.path.equals("/joke.js")) {
                HttpServlet servlet = new JokeJSServlet();
                servlet.doGet(request, response);
            }

            // 3. 组装并发送响应
            response.writeAndFlush(socket.getOutputStream());
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
