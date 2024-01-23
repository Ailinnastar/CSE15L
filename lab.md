# LAB 1 report!!


## Command: `cd` 
- **Initial Working Directory**: `/home`
- **Discussion on working directory**: `cd` will navigate and change the current working directory to specified directory if the diretory path is correct and exist.
  
```bash
[user@sahara ~]$ pwd
/home
```
### Example 1: No Arguments
```bash
[user@sahara ~/lecture1]$ pwd
/home/lecture1
[user@sahara ~/lecture1]$ cd
[user@sahara ~]$ pwd
/home
[user@sahara ~]$ 
[user@sahara ~]$ cd
[user@sahara ~]$ 
```

- **Working Directory**: `/home`
- **Output**: No output, if at the root Directory (in this case it is `/home`) stay in the home Directory, otherwise change Directory to home Directory.
- **Explanation**: The `cd` command with no arguments changes the working directory to the home directory.

### Example 2:command with argument to directory
```bash
[user@sahara ~]$ cd lecture1/
[user@sahara ~/lecture1]$ pwd
/home/lecture1
```
- **Working Directory**: `/home`
- **Output**: No output, change diretory to the directory specified 
- **Explanation**: This command changes the working directory to `lecture1` that I have specified and it is in the current dirctory(`/home`). If directory specified is not exist in the current directory, the will output an error message as below.
```bash
[user@sahara ~]$ cd lecture
bash: cd: lecture: No such file or directory
```

  
### Example 3: command with argument to file
```bash
[user@sahara ~/lecture1]$ cd Hello.java
bash: cd: Hello.java: Not a directory
[user@sahara ~/lecture1]$ pwd
/home/lecture1
```
- **Working Directory**: `/home/lecture1` resulted from `cd lecture1`
- **Output**: `bash: cd: Hello.java: Not a directory`, no chage in working directory
- **Explanation**: The error message indicates that `Hello.java` is not a directory. As `cd` command can only navigate and change directories, not to files, but will not affect the working directory.

![4701706043183_ pic](https://github.com/Ailinnastar/CSE15L/assets/156360722/834753ba-bf34-40f4-8948-96a905cb1d18)



## Command: `ls` 
- **Initial Working Directory**: `/home`
- **Discussion on Directory**: `ls` will never chnage the woking directory, it will remain in the working directory, in this case it is `/home`.
```bash
[user@sahara ~]$ pwd
/home
```
### Example 1: No Arguments
```bash
[user@sahara ~]$ ls
lec2.java  lecture1  URIMain.class
```
- **Working Directory**: `/home`
- **Output**: Lists all the files and directories in `/home` which is the current working directory.
- **Explanation**: The `ls` command lists the contents of the current working directory. 

### Example 2: command with argument to directory
```bash
[user@sahara ~]$ ls lecture1/
Hello.class  Hello.java  messages  README
```
- **Working Directory**: `/home`
- **Output**: Lists all the files and directories in `/lecture1` as specified is the oath is correct.
- **Explanation**: This command lists the contents of the directory specified by the user without changing working directory, in this case lists all the files and stuff in directory `/lecture1`.

### Example 3: command with argument to file
```bash
[user@sahara ~]$ ls lec2.java 
lec2.java
```
- **Working Directory**: `/home`
- **Output**: `lec2.java` repeats the file that is specified
- **Explanation**: The `ls` command displays the specified file if it exists in the current directory. if do not exist it will print an error message as below.
```bash
[user@sahara ~]$ ls lec3.java 
ls: cannot access 'lec3.java': No such file or directory
```
![4711706044151_ pic](https://github.com/Ailinnastar/CSE15L/assets/156360722/c036be00-0f26-45aa-a4c9-1f97879e2082)


## Command: `cat` 

- **Working Directory**: `/home`
- **Discussion on working directory**: cat will remain in the working directory `/home`. This can be observed through the part`[user@sahara ~]` where `~` did not changed to other directory.  
```bash
[user@sahara ~]$ pwd
/home
[user@sahara ~]$ pwd 
/home
```

### Example 1: No Arguments (Error)
```bash
[user@sahara ~]$ cat
lol
lol
i am in /home now          
i am in /home now
cat is repeating my sentences that i have typed
cat is repeating my sentences that i have typed
^C
```
- **Output**: No output, waiting for user input, it will repeat user's input untill user quit it（`^C`).
- **Explanation**: Without arguments, `cat` waits for input from the user, will repeat the input from user untill user chose to quit.


### Example 2: command with argument to file
```bash
[user@sahara ~]$cat lec2.java
import java.net.URI;
import java.net.URISyntaxException;

class URIMain {
  public static void main(String[] args) throws URISyntaxException {
    URI uri = new URI("http://ieng6-202.ucsd.edu:4000/");
    System.out.println(uri.getHost());
    System.out.println(uri.getPath());
    URI anotherURI = new URI("http://ieng6-203.ucsd.edu:4000/search?q=hello");
    System.out.println(anotherURI.getHost());
    System.out.println(anotherURI.getPath());
    System.out.println(anotherURI.getQuery());
  }
}
```

- **Output**: print out all the codes or contents in the file (lec2.java), if the file exists or the file path is right.
- **Explanation**: This command displays the contents of `lec2.java`(in this case lec2.java is in the working directory correctly), if the file path is not correct from the curret directtory then it will display an error message like below.
```bash
[user@sahara ~]$ cat lec3.java
cat: lec3.java: No such file or directory
```

### Example 3: command with argument to directory
```bash
[user@sahara ~]$ cat lecture1
cat: lecture1: Is a directory
```
- **Output**: `cat: lecture1: Is a directory`
- **Explanation**: The `cat` command displays contents for files therefore for will not work for directory and shows error message.


![4691706041597_ pic](https://github.com/Ailinnastar/CSE15L/assets/156360722/dc6c49ad-fce0-4862-bbe3-6fb9a7de2b91)

