# Report5!! Put ALL together!!!!! #



## Part 1 – Debugging Scenario ##

### Student Post:
**Name**: John 
**Issue with reading logic in Java Program**

Hi,

I made a bash script that compiles and executes a Java program, but I'm getting unexpected output. My Java program is supposed to read a text file and print out each line with line numbers and stopp when it is null. However, in my output it only shows the second line and a null with line number 1 before each string printed out from the selected text file `read.txt`. I guess the issue might be with my file reading logic in Java, but I double-checked and it looks fine for me. Here's a screenshot of the output (symptom) when I run my bash script :

<img width="300" alt="image" src="https://github.com/Ailinnastar/CSE15L/assets/156360722/39bf20a6-6933-4c60-ba0e-8d5a27481f4a">
 
What should I do? Thanks for the help!


---

### TA Response:

Hi John!

I undestood that your Java program isn't reading the lines correctly. What I can suggest is look in t the pattern how the lines are skipped and not printed out. If it is consistant skipping inteval, maybe look in to the documentation of the command used to read the whole text or reading lines in each iteration. 

Also for the line number, you may looking to to the number that is incrementing or not for each loop.

Hope this helps!

---

### Follow-up Student Post:

Thanks for the quick response! 
And yes! it was the `.readLine()` and incorrect increments causing this issues.
I found that the out put is printing out the even number lines in the text file, so I looked in to my code and documentation of `.readLine()` and found `.readLine()` will read next line when called, I called `.readLine()` twice in one interatiion, so that it caused skipping one line everytime and printing null although passing the non-null condition of the loop. 
Also the line number incrementation was so outside te loop which did noy did the increment cirrectly as I wished.

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

### Description of What to Edit to Fix the Bug:

Upon reviewing the `ReadLine.java` code, looking in to the `read.txt` and the output, I realised that I did not really understand how does `.readLine()` works when called everytime, which caused the skipping line and the null output in the outcome. I made a variable for the `.readline()` so that the line can be stored in to the variable without moving to the next one when i want the line. Furthermore, I found that the incrementation for the number was not accurate, it stays the same untill the program exit the loop. Meanwhile I moved the incrementation inside the loop instead of outside the loop.

What did I do to fix the bug:
- store the line in to a variable for future use
```
line = reader.readLine()
```
- put the incremetation inside the loop
  

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

One intriguing concept I learned during the second half of this quarter was the power and versatility of the Java Debugger (jdb). Before, debugging for me primarily consisted of inserting print statements throughout my code, which was fine but wasn't always effective for tracking down where is causing the bug. Through jdb, I discovered a more refined approach to debugging that allowed me to pause execution, inspect variable states, step through code one line at a time, and evaluate expressions on the fly. This not only made the debugging process more efficient but also have  the ability to use debugging mode without depending on the java debugger from editor extension. 

Furthermore, vim was also a highlight form the second half of this quater, where I a able to edit and inspect files form the terminal witout actully opening the file or `echo`  `cat` the content, which expand my knolegdes and aquire a new skill in editing files in any condition if and only if I can access the file from my end, which made things easy if I want to accesss the other computer through ssh and edit and fix things. 

