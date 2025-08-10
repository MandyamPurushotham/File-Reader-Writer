# File-Reader-Writer
# File Reader and Writer


##  Overview
The **Notes Manager** is a simple Java console application that allows users to:
- Write notes and save them to a file.
- Read and display previously saved notes.
- Exit the program when done.

It uses `FileReader`, `FileWriter`, `BufferedReader`, and `BufferedWriter` for file handling.

---

##  Features
1. **Write a Note**
   - Enter multiple lines of text.
   - Type `END` on a new line to stop writing.
   - Notes are appended to `notes.txt`.

2. **Read Notes**
   - Displays all saved notes from `notes.txt`.
   - If no file exists, it shows `(No notes file found yet)`.

3. **Exit**
   - Safely closes the application.

---

##  File Structure
NotesManager.java
notes.txt
