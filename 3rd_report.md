# LAB report 3!!


## Part 1！ 
- **Induce Failure**
```bash
  @Test
    public void testReversed1() {
      int[] input1 = { 3, 2, 1 };
      int[] output1 = ArrayExamples.reversed(input1);
      assertArrayEquals(new int[] { 1, 2, 3 }, input1);
    }
```
- **Does not indeuce faliure**
```bash
  @Test
  public void testReversed() {
    int[] input1 = {};
    assertArrayEquals(new int[] {}, ArrayExamples.reversed(input1));
  }
```

- **Symptom**
<img width="870" alt="image" src="https://github.com/Ailinnastar/CSE15L/assets/156360722/3b32f0f2-300d-40d6-9c55-dfba44f28515">

<img width="867" alt="image" src="https://github.com/Ailinnastar/CSE15L/assets/156360722/42110d9b-87d8-4992-9297-9b2dce334095">

### **before-and-after code change required to fix it**

- **Before fixed**
```bash
 static int[] reversed(int[] arr) {
    int[] newArray = new int[arr.length];
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = newArray[arr.length - i - 1];
    }
    return arr;
  }
```
- **Fixed**
```bash
static int[] reversed(int[] arr) {
    int[] newArray = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i -= 1) {
      newArray[arr.length - 1 - i] = arr[i];
    }
    return newArray;
  }
```
**Explanation**
Through observing the buggy code, what we can find that the returned array `arr` is filled by 0's by the new array created `newArray` with 0 with the size of `arr`. Therefore by swapping the assign and to be assigned, we can achive to assigned reversly from the orginal order array `arr` to new array `newArray` filled with 0 originaly to reversed array.


## Part 2!! `grep` command 
### Working directory: `docsearch/technical`

- **Option: -i**
The -i makes `grep` case-insensitive search string in the given file.

Example 1: Search for "struggle" in chapter-1.txt
Search through chapter-1.txt of the string `'struggle'` without case sensitively.
```bash
grep -i "struggle" 911report/chapter-1.txt
```
<img width="678" alt="image" src="https://github.com/Ailinnastar/CSE15L/assets/156360722/84340ddf-0677-41f3-ae6b-ebc57fa0c772">

Example 2: Searching for "know" in chapter-10.txt
Even this the String inputed is upper case `'KNOW'` it will search for all the string in any cases in the `chapter-10.txt` and return the lines containng it.
```bash
grep -i "KNOW" 911report/chapter-10.txt
```
<img width="668" alt="image" src="https://github.com/Ailinnastar/CSE15L/assets/156360722/9f067485-d524-4406-9608-c19bb8d0c41e">

It will be usful when we want to figure out how many times the string apeared in the file without caring it is in the upper or lower letter cases.

(Source: ‘How to use the Linux grep command’ https://www.ionos.com/digitalguide/server/configuration/linux-grep-command/#:~:text=The%20grep%20command%20“grep%20%2Dl,%2Di%20“test”%20example.）



- **Option: -r**
The -r option allows `grep` to read and search all files recursively in a directory.

Example 1: Searching for "user" recursively in all files within the curretn working directory `technical`
Searches for the string "lover" deeply from the current working directory `technical` to the directories, i.e. `biomed`, `plos`, `government`, in the cureent working directory.

```bash
grep -r "lover" 
```
<img width="705" alt="image" src="https://github.com/Ailinnastar/CSE15L/assets/156360722/ba4cdba4-353e-43b5-87c9-eb3ce40ec2d6">


Example 2: Recursively searching for "timeout" in all .conf files
Current working directory:
```bash
pwd               
/Users/ailinna/Desktop/docsearch
```
Implmentation:
```bash
grep -r "crushing" technical 
```
Searches for the string "crushing" deeply from the sprcified working directory `technical` to the directories, i.e. `biomed`, `plos`, `government`, in the specified working directory.

<img width="613" alt="image" src="https://github.com/Ailinnastar/CSE15L/assets/156360722/52e73f1b-7082-42bb-a3e1-b9ac0128c9b3">


It will be useful when have to find for a string that is unique, we can search for that line by searching for all of the files under the current working directroy.

(Source: ‘grep(1) - Linux man page’ https://man7.org/linux/man-pages/man1/grep.1.html)




- **Option: -v**
The -v option inverts the match, return lines/ file that do not contains the string.

Example 1: Showing all lines that do not contain "a" in chapter-10.txt
```bash
grep -v "a" technical/911report/chapter-10.txt
```
This returns all those lines that do not contains `a` in the chapter-10.txt.

<img width="430" alt="image" src="https://github.com/Ailinnastar/CSE15L/assets/156360722/17471ccf-21ce-42eb-8d63-0fe16cb8a761">


Example 2: Showing all files
```bash
grep -l "#" technical/government/Alcohol_Problems/*.txt
```
This returns the .txt that do not contains the `#` under the directory `technical/government/Alcohol_Problems`
<img width="664" alt="image" src="https://github.com/Ailinnastar/CSE15L/assets/156360722/e08c6627-0523-44e0-a4b0-fbe72680678f">



It is useful for filtering out lines that contains the string specified, to focus on lines that expected to have the string but do not in current stage.

(Source: ‘grep(1) - Linux man page’ https://man7.org/linux/man-pages/man1/grep.1.html)


- **Option: -c**
The -c option makes grep return counts of all the lines that contains the string.

Example 1: Count how many lines in the file Session4-PDF.txt that contain the keyword "here"
```bash
grep -c "here" technical/government/Alcohol_Problems/Session4-PDF.txt
```
This return how many lines in the specific file `Session4-PDF.txt` have the string `here`.
<img width="657" alt="image" src="https://github.com/Ailinnastar/CSE15L/assets/156360722/5b978eb5-2c7a-4ea7-b3e3-4700512f5e8e">


Example 2: Counts lines all files if contains "here" in each file under the directory `Alcohol_Problem`
```bash
 grep -c "here" technical/government/Alcohol_Problems/*.txt
```
This rturn how many lines in each directory if contains the string `here` under the directory `technical/government/Alcohol_Problems`.

<img width="673" alt="image" src="https://github.com/Ailinnastar/CSE15L/assets/156360722/bf64904f-0be4-4fb7-b8fc-fab1e9267717">

This is useful when the interest is in how many lines have the term in the file, not actually know which line specifically cotains the string.

(Source: ‘How to use the Linux grep command’ https://www.ionos.com/digitalguide/server/configuration/linux-grep-command/#:~:text=The%20grep%20command%20“grep%20%2Dl,%2Di%20“test”%20example.）








