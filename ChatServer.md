# Code
```bash
import java.net.URI;
import java.io.IOException;
class Handler implements URLHandler {
    String x = "";

    public String handleRequest(URI url) {
        String query = url.getQuery();
        if (url.getPath().equals("/add-message")) {
            String[] split_user_s = query.split("&");
            if (split_user_s[0].startsWith("s=") && split_user_s[1].startsWith("user=")) {
                String toAdd = split_user_s[0].split("=")[1];
                String user = split_user_s[1].split("=")[1];
                x += user + ": " + toAdd + "\n";
                
                return x;
            }
        }
        else if (url.getPath().equals("/reset")) {
            x = "";
            return "";
        } 
        return "Wrong!!";
    }
}

class ChatServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }
        int port = Integer.parseInt(args[0]);
        Server.start(port, new Handler());
    }
}
```
# Screenshot of using `/add-message`
![WeChat0a9e20072bb5d6beec2a8a1273c85cac](https://github.com/Ailinnastar/CSE15L/assets/156360722/82c23049-8d92-4ea7-9675-d939364be63b)
![WeChat6d5f6fcde99351fb3795946178dec49a](https://github.com/Ailinnastar/CSE15L/assets/156360722/5228682a-51d8-4490-852c-c83bd91cb14e)
