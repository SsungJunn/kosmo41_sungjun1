/*
 * Path와 Path 클래스
 * Java.no.file.Path - 파일 및 디렉토리의 경로 표현을 위해 자바 7에서 추가된 인터페이스
 * Get 메소드 호출의 성공 여부는 해당 파일 또는 디렉토리의 존재 여부와 상관 없다.
 */

import java.nio.file.Path;
import java.nio.file.Paths;

class A1_PathDemo {

	public static void main(String[] args) {
		Path pt1 = Paths.get("C:\\JavaStudy\\PathDemo.java");
		Path pt2 = pt1.getRoot();
		Path pt3 = pt1.getParent();
		Path pt4 = pt1.getFileName();
		
		System.out.println("Absolute: " + pt1);
		System.out.println("Root: " + pt2);
		System.out.println("Parent: " + pt3);
		System.out.println("File: " + pt4);
	}

}
