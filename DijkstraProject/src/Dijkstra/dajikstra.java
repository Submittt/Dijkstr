package Dijkstra;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.List;

public class dajikstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.printf("출발지를 입력해주세요 : ");
            int stratNode = sc.nextInt();
            System.out.printf("도착지를 입력해주세요 : ");
            int endNode = sc.nextInt();
            sc.close();

            int vertaxCount = 25;
            int buildingCount = 8;
    
            int INF =Integer.MAX_VALUE;
    
    
            int[] distance = new int[vertaxCount];
            boolean[] visited = new boolean[vertaxCount];
    
            Arrays.fill(distance, INF);
            distance[stratNode] = 0;
    
    
            PriorityQueue<int[]> priorityQueue = 
                                                new PriorityQueue<>(
                                                    (a, b) -> Integer.compare(a[1], b[1]));
    
            // compare -> a와 b를 비교 (즉, a - b이고 내림차순 기준이 됨) (a,b는 노드의 데이터를 뜻한다)
            // ** 인덱스 번호의 의미? **
            // 인접리스트 노드의 0번째 데이터는 연결된 노드를 뜻하고
            // 인접리스트 노드의 1번째 데이터는 가중치를 뜻하기에 가중치(거리)에 대한 비교가 필요함
    
    
            List<List<int[]>> arrList = pathData.createAdjacencyList();
    
            priorityQueue.add(new int[] {stratNode, 0});
            // 시작점 => 0번째 인덱스
            // 거리값 => 1번째 인덱스
    
            while (!priorityQueue.isEmpty()) {
                int[] current = priorityQueue.poll();
                int currentNode = current[0];
    
                if (visited[currentNode]) continue;
                // 방문한 노드를 만나면 while continue 처리 (다시 반복)
    
                visited[currentNode] = true;
                // 방문하지 않은 노드라면 해당 라인이 실행되어 true 처리 => 로직 동작
    
                for (int[] edges : arrList.get(currentNode) ) {
                    int nextNode = edges[0];
                    int edgeWeight = edges[1];
    
                    if (distance[currentNode] + edgeWeight < distance[nextNode]) {
                        distance[nextNode] = distance[currentNode] + edgeWeight;
                        
                        priorityQueue.add(new int[] {nextNode, distance[nextNode]});
                    }
                }
            }
    
            
            if (visited[stratNode] && visited[endNode]) {
                System.out.println(
                    String.format("\n선택하신 출발지는 %d번 건물입니다", stratNode));
                System.out.println(
                    String.format("선택하신 도착지는 %d번 건물입니다", endNode));
    
                System.out.println(
                    String.format("\n%d번 건물 => %d번 건물까지의 최단거리는 %dm 입니다\n",
                                stratNode, endNode, distance[endNode]));
            }
    
            for (int i = 1; i < buildingCount; i++) {
                if (visited[i]) {
                    System.out.println(
                                    String.format(
                                                stratNode + "번 건물 => "+
                                                i+"번 건물 까지의 최단 거리는 : %dm 입니다",
                                                distance[i]));
                } else {
                    System.out.println(
                                    String.format("Node %d is Non Visited Node",i));
                }
            }
    

        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }  
}
