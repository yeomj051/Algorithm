import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	//암호 자릿 수, 주어지는 문자 개수
	static int L, C;
	//문자열
	static char[] alphabet;
	// 암호 리스트
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		//암호 자릿 수
		L = Integer.parseInt(stringTokenizer.nextToken());
		//주어지는 문자 개수
		C = Integer.parseInt(stringTokenizer.nextToken());
		
		//문자열 배열 생성
		alphabet = new char[C];
		
		//문자 입력 받기
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < C; i++) {
			alphabet[i] = stringTokenizer.nextToken().charAt(0);
		}
		//주어진 문자 정렬하기
		Arrays.sort(alphabet);
		
		//출력 stringBuilder
		StringBuilder stringBuilder = new StringBuilder();
		
		// C개 중 L개를 고르는 조합 찾기
		comb(0, 0, new char[L], stringBuilder);
		
		System.out.println(stringBuilder);
	}
	

	private static void comb(int start, int count, char[] keyArray, StringBuilder stringBuilder) {
		if(count == L) {
			if (findKey(keyArray)) {
				for (int i = 0; i < keyArray.length; i++) {
					stringBuilder.append(keyArray[i]);
				}
				stringBuilder.append("\n");
			}
			
			
			return;
		}
		
		for (int i = start; i < C; i++) {
			keyArray[count] = alphabet[i];
			comb(i+1, count+1, keyArray, stringBuilder);
		}
	}
	
	private static boolean findKey(char[] keyArray) {
		//모음 개수
		int vowels = 0;
		//자음 개수
		int consonants =0;
		
		for (char c : keyArray) {
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowels++;
			else consonants++;
		}
		
		if (vowels >= 1 && consonants >=2) {
			return true;
		}else {
			return false;
		}
		
	}

}
