package com.hito.soc.gen;


import com.hito.soc.gen.mowitnow.Mower;
import com.hito.soc.gen.mowitnow.file.FileData;
import com.hito.soc.gen.mowitnow.file.FileReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class MainApplication {

    public static final String SOURCE_INPUT_FILE = "src/main/resources/inputFile.txt";

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        FileData fileData = FileReader.getInstance().readFileFromPath(SOURCE_INPUT_FILE);
        for (int i=0 ; i<fileData.getMowers().size(); i++ ){
            Mower mower = fileData.getMowers().get(i);
            log.info("Begin process mower number {}", i+1);
            mower.executeMow();
            log.info("End process mower number {} in position {}", i+1, mower.getPosition().toString());
        }
    }


}
