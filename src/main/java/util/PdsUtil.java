package util;

import java.util.Date;

public class PdsUtil {

	/* 파일명 변경(time) */
	// ex) myfile.txt --> 2646718454.txt
	
	
	// myfile.txt -> indexOf('.') -> 6
	// '.'의 위치를 구하여 파일명, 확장자명 나눈다.
	// substring(0, 6) -> 파일명. 0부터 6 전까지
	// substring(6) -> 확장자명(.txt). 6부터 끝까지
	
	public static String getNewFileName(String f) {
		String filename = "";
		String fpost = "";
		
		if(f.indexOf('.') >= 0) {	// 도트가 있을 때(확장자명이 있을때),
			fpost = f.substring(f.lastIndexOf('.'));	//확장자명 (.txt)
			filename = new Date().getTime() + fpost;
		}
		else {
			filename = new Date().getTime()+ ".back";	//임의의 확장자명을 붙여둠
		}
		
		return filename;
	}
	
	
}
