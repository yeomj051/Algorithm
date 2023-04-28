import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	//파이프 설치 경로 이동 delta
	static int[][] delta = {{-1,1},{0,1},{1,1}};
	//지도
	  static char[][] map;
	
	//가로, 세로
	static int R;
	static int C;
	
	//파이프 갯수
	static int pipeCount=0;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		R =Integer.parseInt(stringTokenizer.nextToken());
		C =Integer.parseInt(stringTokenizer.nextToken());
		
		map = new char[R][C];
		
//		System.out.println("================origin");
		for (int i = 0; i < R; i++) {
			String string = bufferedReader.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = string.charAt(j);
//				System.out.print(map[i][j]);
			}
//			System.out.println();
		}
		
		
		for (int i = 0; i < R; i++) {
			installPipe(map, i, 0);
		}

		System.out.println(pipeCount);
		
		
	}
	
	private static boolean installPipe(char[][] map,int indexR, int indexC) {
		map[indexR][indexC] = '-';
		
		if(indexC == C-1) {
			pipeCount++;
//			System.out.println("================change");
//			for (int i = 0; i < R; i++) {
//				for (int j = 0; j < C; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
			return true;
		}
		
		

		for (int i = 0; i < 3; i++) {
			int x = indexR + delta[i][0];
			int y = indexC + delta[i][1];
			
			if (x >= 0 && x < R && map[x][y] == '.') {
				if(installPipe(map, x, y)) return true;
			}
		}
		
		return false;
	}

}
