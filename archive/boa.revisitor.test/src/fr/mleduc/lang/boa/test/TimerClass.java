package fr.mleduc.lang.boa.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TimerClass {
    public String name;
    private long start;

    private final StringBuilder sb = new StringBuilder();

    public TimerClass() {
        sb.append("type,case,time");
        sb.append(System.lineSeparator());
    }

    public void before() {
        this.start = System.currentTimeMillis();
    }

    public void after(String pathname) {
        sb.append(name).append(",").append(pathname).append(",").append(System.currentTimeMillis() - start);
        sb.append(System.lineSeparator());
    }

    public void save() {
        File file = new File(name + "_time.csv");
        try {
            FileWriter fw = new FileWriter(file);
            fw.append(sb);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

