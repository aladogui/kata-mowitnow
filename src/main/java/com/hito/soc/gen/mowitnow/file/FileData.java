package com.hito.soc.gen.mowitnow.file;

import com.hito.soc.gen.mowitnow.Mower;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class FileData {

  private List<Mower> mowers;

  public List<Mower> getMowers() {
    if(mowers== null){
      mowers = new ArrayList<>();
    }
    return mowers;
  }
}
