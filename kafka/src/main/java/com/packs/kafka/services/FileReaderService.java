package com.packs.kafka.services;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.packs.kafka.config.Constants.*;


@Service
public class FileReaderService {
    Pattern pattern = Pattern.compile(URL_PATTERN, Pattern.CASE_INSENSITIVE);

    public int getJobsCount(){
        BufferedReader reader;
        int jobsCount=0;
        try {
            reader = new BufferedReader(new FileReader(LOG_FILE));
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
