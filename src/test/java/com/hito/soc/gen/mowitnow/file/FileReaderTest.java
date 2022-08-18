package com.hito.soc.gen.mowitnow.file;

import static org.mockito.MockitoAnnotations.openMocks;

import com.hito.soc.gen.exceptions.InvalidParamsException;
import com.hito.soc.gen.mowitnow.Mower;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

class FileReaderTest {

  public static final String VALID_INPUT_FILE_PATH = "src/test/resources/inputFile.txt";
  public static final String NOT_VALID_INPUT_FILE_PATH = "src/test/resources/inputFileError.txt";
  @InjectMocks
  FileReader fileReader;

  private FileData fileData;

  private Mower firstMower;
  private Mower secondMower;


  @BeforeEach
  void setUp() {
    openMocks(this);
    fileData = fileReader.readFileFromPath(VALID_INPUT_FILE_PATH);
    should_return_two_mowers();
    firstMower= fileData.getMowers().get(0);
    secondMower= fileData.getMowers().get(1);
  }

  @Test
  void should_handle_invalid_params_exception_when_invalid_lines_number(){
    Assertions.assertThrows(InvalidParamsException.class,
        () -> fileReader.readFileFromPath(NOT_VALID_INPUT_FILE_PATH), "Garden limit coordinates not valid in file");

  }

  @Test
  void should_return_two_mowers()  {
    Assertions.assertEquals(2, fileData.getMowers().size());
  }

  @Test
  void should_return_correct_garden_limit(){
    Assertions.assertNotNull(firstMower.getGardenLimit());
    Assertions.assertNotNull(firstMower.getGardenLimit().getLimitCoordinates());
    Assertions.assertEquals(5, firstMower.getGardenLimit().getLimitCoordinates().getX());
    Assertions.assertEquals(5, firstMower.getGardenLimit().getLimitCoordinates().getY());
    Assertions.assertNotNull(secondMower.getGardenLimit());
    Assertions.assertNotNull(secondMower.getGardenLimit().getLimitCoordinates());
    Assertions.assertEquals(5, secondMower.getGardenLimit().getLimitCoordinates().getX());
    Assertions.assertEquals(5, secondMower.getGardenLimit().getLimitCoordinates().getY());
  }

  @Test
  void should_return_correct_first_mower_position(){
    Assertions.assertEquals(1, firstMower.getPosition().getCoordinates().getX());
    Assertions.assertEquals(2, firstMower.getPosition().getCoordinates().getY());
    Assertions.assertEquals("N", firstMower.getPosition().getOrientation().name());
  }
 @Test
  void should_return_correct_second_mower_position(){
    Assertions.assertEquals(3, secondMower.getPosition().getCoordinates().getX());
    Assertions.assertEquals(3, secondMower.getPosition().getCoordinates().getY());
    Assertions.assertEquals("E", secondMower.getPosition().getOrientation().name());
  }

  @Test
  void should_return_valid_true_when_peer_lines(){
    Assertions.assertTrue(fileReader.isValidFileLinesNumber(5));
  }



}