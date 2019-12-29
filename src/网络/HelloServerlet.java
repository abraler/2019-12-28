package 网络;

public class HelloServerlet extends HttpServlet {

    @Override
    public void doGet(Request req, Response resp) {
     req.parameters.get("target");
     String currentUser="未登录";
     String cookie=req.headers.get("Cookie");
     if(cookie!=null){
         currentUser=cookie.split("=")[1];
     }
        resp.setHeader("Content-Type", "text/plain; charset=utf-8");
        resp.setHeader("X-teacher", "peixinchen");
        resp.setHeader("X-room", "201");

        resp.print("你好" +req.parameters.get("target"));
        resp.println("当前用户是"+currentUser);
    }
}
