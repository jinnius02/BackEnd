package com.ureca.step4.di;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputImpl implements FileOutput{
/*
            <write>               <read>
byte        OutputStream          InputStream  
    -------------------------------------------
char        Writer                Reader
*/
	
	@Override
	public void output(String str) {

		try {
			FileWriter fw = new FileWriter("hello.txt");
			fw.write(str);//파일에 내용(str)출력
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}