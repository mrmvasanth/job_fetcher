package com.packs.kafka.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReaderService {
    private static final String urlPattern="job\\/[a-zA-Z0-9]*-[a-zA-Z0-9]*";
    Pattern pattern = Pattern.compile(urlPattern, Pattern.CASE_INSENSITIVE);

    public int getJobsCount(){
        BufferedReader reader;
        int jobsCount=0;
        try {
            reader = new BufferedReader(new FileReader("/home/administrator/Projects/JobScanner/Sample log.txt"));
            String line = reader.readLine();
            while (line != null) {
                Matcher matcher = pattern.matcher(line);
                if(matcher.find()){
                    jobsCount++;
                }
                line = reader.readLine();
            }
            reader.close();
            return jobsCount;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jobsCount;
    }
}
