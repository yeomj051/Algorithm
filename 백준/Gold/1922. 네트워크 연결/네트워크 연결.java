import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
									
	static class Computer{
	    int vertex, cost;
	
	    public Computer(int vertex, int cost) {
	        this.vertex = vertex;
	        this.cost = cost;
	    }
	}
	
	static List<ArrayList<Computer>> computers;
	static int computerCount;
	static int sum;	

	public static void main(String[] args) throws IOException {
	    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	
	    computerCount = Integer.parseInt(bufferedReader.readLine());
	    int conactCount = Integer.parseInt(bufferedReader.readLine());
	
	    computers = new ArrayList<>();
	    computers.add(new ArrayList<Computer>());
	
	    for (int i = 1; i <= computerCount; i++) {
	        computers.add(new ArrayList<Computer>());
	    }
	
	    for (int i = 1; i <= conactCount; i++) {
	        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
	
	        int vertex1 = Integer.parseInt(stringTokenizer.nextToken());
	        int vertex2 = Integer.parseInt(stringTokenizer.nextToken());
	        int cost = Integer.parseInt(stringTokenizer.nextToken());
	
	        computers.get(vertex1).add(new Computer(vertex2,cost));
	        computers.get(vertex2).add(new Computer(vertex1,cost));
	
	    }
			prim();
		
	    
	
	    System.out.println(sum);
	}

	private static void prim(){
	    PriorityQueue<Computer> queue = new PriorityQueue<>((e1,e2) -> e1.cost - e2.cost);
	    sum = 0;
	    boolean visit[] =new boolean[computerCount+1];
	
	
	    //1번 컴퓨터부터 시작
	    visit[1] = true;
	    queue.addAll(computers.get(1));
	    int count = 1;
	
	    while (!queue.isEmpty()){
	        Computer vertex = queue.poll();
	
	        if(visit[vertex.vertex]) continue;
	
	        sum += vertex.cost;
	        visit[vertex.vertex]= true;
	
	        count++;
	        if (count == computerCount) break;
	
	        queue.addAll(computers.get(vertex.vertex));
	    }
	
	}
}
