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
## Working directory: `docsearch/technical`

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








- **Option: -v**
The -v option inverts the match, return lines that do not contains the string.

Example 1: Showing all lines that do not contain "success" in a file
```bash
grep -v "success" ./technical/operation.log
```
This command is useful for filtering out lines that contain the word "success", possibly to focus on lines with errors or warnings.

Example 2: Inverting the match to exclude comments from a configuration file
```bash
grep -v "^#" ./technical/server.conf
```
This command filters out comment lines (lines starting with #) in server.conf, which can be helpful when you want to view only the active configuration lines.




- **Option: -l (files with matches)**
The -l option makes grep return all the files that contains the string.

Example 1: Finding files that contain the keyword "database"
```bash
grep -l "database" ./technical/*
```
This command lists filenames in the ./technical directory that contain the term "database", which is useful when the interest is in which files contain the term, not the actual matching lines.

Example 2: Finding configuration files that mention "port"
```bash
grep -l "port" ./technical/*.cfg
```
This command will list all .cfg files in the ./technical directory that mention "port". This is useful for quickly identifying relevant configuration files.




(Source: grep(1) - Linux man page)






