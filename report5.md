# Report5!! Put ALL together!!!!! #



## Part 1 – Debugging Scenario ##

### Student Post:
**Name**: John 

**Issue with reading logic in Java Program**

Hi,

I made a bash script that compiles and executes a Java program, but I'm getting unexpected output. My Java program is supposed to read a text file and print out each line with line numbers, but it only shows the second line and a null with line number 1 before each string printed from the text file `read.txt`. I think the issue might be with my file reading logic in Java, but I double-checked, and it looks fine to me. Here's a screenshot of the output (symptom) when I run my bash script:


<img width="300" alt="image" src="https://github.com/Ailinnastar/CSE15L/assets/156360722/39bf20a6-6933-4c60-ba0e-8d5a27481f4a">
 
What should I do? Thanks for the help!


---

### TA Response:

Hi John!

It seems your Java program isn't reading the lines correctly. Look into the pattern of how the lines are skipped and not printed. If there's a consistent skipping interval, maybe review the documentation of the command used to read the text or how you're reading lines in each iteration.

Also, for the line number, ensure it increments correctly for each loop iteration.

Hope this helps!

---

### Follow-up Student Post:

Thanks for the quick response!
And yes! It was the `.readLine()` and incorrect increments causing these issues.
I found that the output is printing out the even number lines in the text file, so I looked into my code and the documentation of `.readLine()` and realized calling `.readLine()` twice in one iteration caused it to skip one line every time and print null, although passing the non-null condition of the loop.
Also, the line number incrementation was outside the loop, which did not do the increment correctly as I wished.

**bug:**

<img width="459" alt="image" src="https://github.com/Ailinnastar/CSE15L/assets/156360722/0625db2a-e91c-4128-851b-68c07c3c8ef0">

**fixed:**

<img width="443" alt="image" src="https://github.com/Ailinnastar/CSE15L/assets/156360722/aaa05da8-b38f-4533-9697-f6ac6ca1d09e">


---
### Setup:

**File & Directory Structure:**

```
home/
│
├── bash.sh
└── ReadLile.java
└── read.txt
```

**`bash.sh` contents:**

```bash
if [ "$#" -ne 1 ]
then
    echo "Need file path"
    exit 1
fi

javac ReadLine.java

java ReadLine "$1"
```

**`ReadLile.java` buggy contents, before fix:**

```bash
import java.io.*;
import java.nio.file.*;

public class ReadLine {
    public static void main(String[] args) {
        Path filePath = Paths.get(args[0]);
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            int lineNumber = 1;
            while ((reader.readLine()) != null) {
                System.out.println(lineNumber + ": " + reader.readLine());
                
            }
            lineNumber++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
**`read.txt` contents:**
```
''''''
this is the second line
pikabooooooo!
```

**Command Line Used to Trigger the Bug:**

```bash
bash bash.sh read.txt 
```

### Description of What to Edit to Fix the Bug: ###
Upon reviewing the ReadLine.java, looking into the read.txt and the output, I realized that I did not understand how `.readLine()` works when called every time, which caused the line skipping and the null output in the outcome. I made a variable for the `.readLine()` so that the line can be stored into the variable without moving to the next one when I want the line. Furthermore, I found that the line number incrementation was not accurate, as it stayed the same until the program exited the loop. Meanwhile, I moved the incrementation inside the loop instead of outside.

What did I do to fix the bug:

- Store the line into a variable for future use
```
line = reader.readLine()
```
- Put the incrementation inside the loop
  

**Fixed `ReadLile.java`:**

```bash
import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class ReadLine {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("No file to read!!");
            return;
        }

        Path filePath = Paths.get(args[0]);
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {

            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


```

**Output after fixed:**

<img width="315" alt="image" src="https://github.com/Ailinnastar/CSE15L/assets/156360722/13d081db-05a3-4b85-bc8a-c51b48eba0b9">


## Part 2 – Reflection ##

One intriguing concept I learned during the second half of this quarter was the power and versatility of the Java Debugger (jdb). Before, debugging for me primarily consisted of inserting print statements throughout my code. This approach was fine but not always effective for tracking down bugs. Through jdb, I discovered a more refined approach to debugging that allowed me to pause execution, inspect variable states, step through code one line at a time, and evaluate expressions on the fly. This not only made the debugging process more efficient but also gave me the ability to use the debugging mode without depending on the Java debugger from the editor extension.


Furthermore, Vim was also a highlight from the second half of this quarter, where I was able to edit and inspect files from the terminal without actually opening the file or using `echo` or `cat` to display the content. This expanded my knowledge and acquired a new skill in editing files under any condition, as long as I can access the file from my end. This made things easier if I wanted to access another computer through ssh and edit and fix things.
