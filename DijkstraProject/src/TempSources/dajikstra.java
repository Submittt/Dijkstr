package TempSources;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.List;

public class dajikstra {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.close();

        int vertaxCount = 6;

        // int edgeCount = 5;

        int INF =Integer.MAX_VALUE;
        int stratNode = 1;

        // int stratNode = sc.nextInt();

        int[] distance = new int[vertaxCount];
        boolean[] visited = new boolean[vertaxCount];

        Arrays.fill(distance, INF);
        distance[stratNode] = 0;


        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        // compare -> a와 b를 비교 (즉, a - b이고 내림차순 기준이 됨) (a,b는 노드의 데이터를 뜻한다)
        // ** 인덱스 번호의 의미? **
        // 인접리스트 노드의 0번째 데이터는 연결된 노드를 뜻하고
        // 인접리스트 노드의 1번째 데이터는 가중치를 뜻하기에 가중치(거리)에 대한 비교가 필요함

        List<List<int[]>> arrList = new ArrayList<>();
        

        for (int i = 0; i < vertaxCount; i++) {
            arrList.add(new ArrayList<>());
        }


        arrList.get(1).add(new int[] {2,8});
        arrList.get(1).add(new int[] {3,3});
        arrList.get(2).add(new int[] {4,4});
        arrList.get(2).add(new int[] {2,15});
        arrList.get(3).add(new int[] {4,13});
        arrList.get(4).add(new int[] {5,2});

        pq.add(new int[] {stratNode, 0} );

        // 시작점 => 0번째 인덱스
        // 거리값 => 1번째 인덱스

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];

            if (visited[currentNode]) continue;
            // 방문한 노드를 만나면 while continue 처리 (다시 반복)

            visited[currentNode] = true;
            // 방문하지 않은 노드라면 해당 라인이 실행되어 true 처리 => 로직 동작

            for (int[] edges : arrList.get(currentNode) ) {
                // System.out.println(Arrays.toString(edges));
                int nextNode = edges[0];
                int edgeWeight = edges[1];

                if (distance[currentNode] + edgeWeight < distance[nextNode]) {
                    distance[nextNode] = distance[currentNode] + edgeWeight;
                    pq.add(new int[] {nextNode, distance[nextNode]});
                }
            }
        }

        for (int i = 1; i < vertaxCount; i++) {
            if (visited[i]) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }
    }  
}
