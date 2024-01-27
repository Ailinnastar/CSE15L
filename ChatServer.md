# Part 1!
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

## `/add-message?s=Hello&user=jpolitz`
![WeChat0a9e20072bb5d6beec2a8a1273c85cac](https://github.com/Ailinnastar/CSE15L/assets/156360722/82c23049-8d92-4ea7-9675-d939364be63b)

## Which methods in your code are called?
`handleRequest` in the `Handler` class was called


## What are the relevant arguments to those methods, and the values of any relevant fields of the class?
the argument `URI url` was passes in, which relate to the following coding block in the method, which was when the path  contains`/add-message` and with the query `s=` and `user=`, the server should display the specified format that is desighned.In this case the values where `s=Hello` and `useer=jpolitz`.

## How do the values of any relevant fields of the class change from this specific request? If no values got changed, explain why.
the `String x` value changed from a empty string to `jpolitz: Hello\n`

## `/add-message?s=How are you&user=yash`
![WeChat6d5f6fcde99351fb3795946178dec49a](https://github.com/Ailinnastar/CSE15L/assets/156360722/5228682a-51d8-4490-852c-c83bd91cb14e)

## Which methods in your code are called?
`handleRequest` in the `Handler` class was called

## What are the relevant arguments to those methods, and the values of any relevant fields of the class?
the argument `URI url` was passes in, which relate to the following coding block in the method, witch was when the path  contains`/add-message` and with the query `s=` and `user=`, the server should display the specified format that is desighned. In this case the values where `s=How are you` and `useer=yash`.

## How do the values of any relevant fields of the class change from this specific request? If no values got changed, explain why.
the `String x` value changed from `jpolitz: Hello\n` to `jpolitz: Hello\nyash: How are you` 


# Part 2!!

# Part 3!!!

From lab 2 and 3 i have learnt that to access the remote computer, we can use `SSH` key to accesses it. It was very cool for me as it gave me an insight in the algorism or process of how to use other computer from differnt locations. 

Moreover, I have also learnt to modify the file in the remote computer, there are many options, while it is  convinient to use `vim` when there is a small part of changes or updates. While also notice to control or in the `vim` it is very hard to get to the place and use the functions we often use, which required me to look in to those shortcuts to modofy the file or codes in the remote computer from my postion.




