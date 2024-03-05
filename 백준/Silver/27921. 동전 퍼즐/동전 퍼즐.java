import java.io.*;
import java.util.*;
import java.awt.*;

class Main {
	// b: before a: after
	public static int bx,by,ax,ay;
	public static int[][] bMap,aMap;
	public static int coin;		// 전체 코인 갯수
	public static int max;		// 최대로 겹친 코인 갯수
	
	public static void main(String[] args) throws Exception {
		//입력 객체
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// before size
		bx = Integer.parseInt(st.nextToken());
		by = Integer.parseInt(st.nextToken());
		
		// before 배열 입력
		bMap = new int[bx][by];
		for(int i=0; i<bx; i++){
			String string = br.readLine();
			char[] arr = string.toCharArray();
			for(int j=0; j<by; j++){
				if(arr[j] == 'O'){
					bMap[i][j] = 1;
					coin++;
				}else bMap[i][j] = 0;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		// after sizer
		ax = Integer.parseInt(st.nextToken());
		ay = Integer.parseInt(st.nextToken());
		
		// after 배열 입력
		aMap = new int[ax][ay];
		for(int i=0; i<ax; i++){
			String string = br.readLine();
			char[] arr = string.toCharArray();
			for(int j=0; j<ay; j++){
				if(arr[j] == 'O'){
					aMap[i][j] = 1;
				}else aMap[i][j] = 0;
			}
		}
		
		// 겹치게 되는 모든 경우의 수만큼 반복
		for(int i=1; i<bx+ax; i++){
			// before 배열에서 겹치는 시작 x좌표
			int bxs = (bx-i < 0) ? 0 : bx-i;
			// after 배열에서 겹치는 시작 x좌표
			int axs = (bx-i < 0) ? (bx-i)*(0-1) : 0;
			for(int j=1; j<by+ay; j++){
				// before 배열에서 겹치는 시작 y좌표
				int bys = (by-j < 0) ? 0 : by-j;
				// after 배열에서 겹치는 시작 y좌표
				int ays = (by-j < 0) ? (by-j)*(0-1) : 0;
				// 겹치는 코인 갯수 확인
				check(bxs,bys,axs,ays);
			}
		}
		
		StringBuilder sb = new StringBuilder().append(coin - max);
		System.out.println(sb);
	}
	
	// 겹치는 코인 갯수 확인 함수
	public static void check(int bxs, int bys, int axs, int ays){
		int count =0;
		for(int bi=bxs, ai=axs; bi<bx && ai<ax; bi++,ai++){
			for(int bj=bys, aj=ays; bj<by && aj<ay; bj++, aj++){
				// 동전이 겹치는 경우 count +1
				if(bMap[bi][bj]==1 && aMap[ai][aj]==1) count++;
			}
		}
		
		// 가장 많이 겹치는 갯수일 경우 max 갱신
		max = Math.max(max,count);
	}
}