package com.hito.soc.gen.mowitnow.file;

import com.hito.soc.gen.exceptions.InvalidFileException;
import com.hito.soc.gen.exceptions.InvalidParamsException;
import com.hito.soc.gen.mowitnow.GardenLimit;
import com.hito.soc.gen.mowitnow.Instruction;
import com.hito.soc.gen.mowitnow.Mower;
import com.hito.soc.gen.mowitnow.Position;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FileReader {


  public static final String SEPARATOR = " ";
  private static FileReader instance;

  private FileReader() {
  }

  public static FileReader getInstance() {
    if (instance == null) {
      instance = new FileReader();
    }
    return instance;
  }

  /**
   * Read file and return fileData object
   * @param path path of file
   * @return FileData object
   */
  public FileData readFileFromPath(final String path) {
    FileData fileData = new FileData();
    try (BufferedReader br = new BufferedReader(new java.io.FileReader(path))){
      String line ;
      int linesNb=0;
      while((line = br.readLine())!=null) {
        linesNb++;
        List<String> gardenLimit = Arrays.asList(line.trim().split(SEPARATOR));
        if (gardenLimit.size() != 2) {
          throw new InvalidParamsException("Garden limit coordinates not valid in file");
        }
        String firstPosition;
        String instructions;
        while ((firstPosition = br.readLine()) != null && (instructions = br.readLine()) != null) {
          linesNb +=2;
          String[] positionParams = firstPosition.trim().split(SEPARATOR);
          Position mowerPosition = new Position(positionParams);
          List<Instruction> instructionList = instructions.chars()
              .mapToObj(value -> Instruction.valueOf(String.valueOf((char) value)))
              .collect(Collectors.toList());
          fileData.getMowers().add(new Mower(mowerPosition, instructionList,
              new GardenLimit(gardenLimit.get(0), gardenLimit.get(1))));
        }
      }
      if(!isValidFileLinesNumber(linesNb)){
        log.error("Mal formatted file :{}", path);
        throw new InvalidFileException("Number of lines in the file is not valid");
      }
    }catch (IOException io){
      log.error("Error occurred when read file");
    }
    return fileData;
  }

  public boolean isValidFileLinesNumber(final int nbOfLines) {
    return nbOfLines % 2 == 1;
  }


}
