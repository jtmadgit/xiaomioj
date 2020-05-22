package com.online.judge;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @{author} issuser
 * @{create} 2019-09-17-11:49
 */
public class ProcessBuilderTest {

  public static void main(String[] args) throws Exception {

    List<String> commonad = new ArrayList();
    commonad.add("ipconfig");
    commonad.add("-all");
    ProcessBuilder processBuilder = new ProcessBuilder(commonad);
    processBuilder.redirectErrorStream(true);
    Process process = processBuilder.start();
    InputStream in=process.getInputStream();
    byte[] re=new byte[1024];
    while (in.read(re)!= -1) {
      System.out.println(new String(re, "utf-8"));
    }
    in.close();
    if(process.isAlive()){
      process.waitFor();
    }
  }

}
