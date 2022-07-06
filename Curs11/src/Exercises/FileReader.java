package Exercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FileReader {
    private String filePath;

    public FileReader(String filePath) {
        this.filePath = filePath;
    }

    public List<Student> readStudents() throws IOException {
        BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath));
        List<Student> list = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            list.add(studentFromString(line));
        }
        return list;
    }

    private Student studentFromString(String line){
        String[] stundetInfo = line.split(Pattern.quote("|"));
        return new Student(stundetInfo[0], stundetInfo[1], Integer.parseInt(stundetInfo[2]));
    }
}
