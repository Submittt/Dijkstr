package Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
// import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.List;
import java.util.Map.Entry;

public class Dijkstra {


    public static List<Integer> getPath(int[] previous, int endNode) {
        // 이전 경로 정보 저장 배열, 도착지점 노드번호 입력

        List<Integer> pathList = new ArrayList<>();
        // 트래킹된 경로 저장할 리스트

        int cur = endNode;
        // 트래킹을 시작할 노드 => 도착지점 노드

        while (cur != -1) {
        // 첫번째 순서 노드까지 반복

            pathList.add(cur);
            cur = previous[cur];
            // 트래킹 타겟 노드를 리스트 추가
            // 트래킹 타겟 노드의 이전 노드를 할당하여 반복
        }
    
        Collections.reverse(pathList);
        // 시작 노드 -> 도착 노드 순으로 뒤집기
        return pathList;
    } 

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in , "EUC-KR");

                pathData.showInformation();

                System.out.printf("출발지를 입력해주세요: ");
                String startNode_str = sc.nextLine();
                int startNode = pathData.parseStringToInt(startNode_str);
    
                System.out.printf("도착지를 입력해주세요 : ");
                String endNode_str = sc.nextLine(); 
                int endNode = pathData.parseStringToInt(endNode_str);
        
                sc.close();
        

        int vertaxCount = 25;
        int buildingCount = 8;

        int INF = Integer.MAX_VALUE;

        int[] distance = new int[vertaxCount];
        int[] previous = new int[vertaxCount];
        boolean[] visited = new boolean[vertaxCount];

        Arrays.fill(distance, INF);
        Arrays.fill(previous, -1);
        distance[startNode] = 0;

        PriorityQueue<int[]> priorityQueue =
                new PriorityQueue<>( (a, b) -> Integer.compare(a[1], b[1]) );

        List<HashMap<Integer, Integer>> arrList = pathData.createAdjacencyList();

        priorityQueue.add(new int[] {startNode, 0}); 
        // 시작점 => 0번째 인덱스, 거리값 => 1번째 인덱스

        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();
            int currentNode = current[0];

            if (visited[currentNode]) continue;

            visited[currentNode] = true;

            for (Entry<Integer, Integer> edges : arrList.get(currentNode).entrySet()) {
                int nextNode = edges.getKey();
                int edgeWeight = edges.getValue();

                if (distance[currentNode] + edgeWeight < distance[nextNode]) {
                    distance[nextNode] = distance[currentNode] + edgeWeight;

                    // 다음 노드에 현재 노드를 할당 => 이전의 노드를 할당
                    // ex) a->b 순서로 이동했다면 previous[b] = a로 할당 
                    previous[nextNode] = currentNode;

                    priorityQueue.add(new int[] {nextNode, distance[nextNode]});
                }
            }
        }

        if (visited[startNode] && visited[endNode]) {
            System.out.println(
                    String.format("\n선택하신 출발지는 %s 건물입니다", pathData.parseIntToString(startNode)));
                    
            System.out.println(
                    String.format("선택하신 도착지는 %s 건물입니다", pathData.parseIntToString(endNode)));

            System.out.println(
                    String.format("\n%s 건물 => %s 건물까지의 최단거리는 %dm 입니다\n",
                            pathData.parseIntToString(startNode),
                            pathData.parseIntToString(endNode),
                            distance[endNode]));
        }
        
        List<Integer> trackedPathList = getPath(previous, endNode);
        System.out.print("최단경로 트래킹 : ");

        for (int pathNode : trackedPathList) {
            if (pathNode == endNode) {
                System.out.print(pathData.parseIntToString(pathNode));
            } else {
                System.out.print(pathData.parseIntToString(pathNode) + " -> ");
            }
        }
        System.out.println("");
        System.out.println("");


        for (int i = 1; i < buildingCount; i++) {
            if (visited[i]) {
                System.out.println(
                        String.format(
                            pathData.parseIntToString(startNode) + " 건물 => "+ pathData.parseIntToString(i) + " 건물 까지의 최단 거리는 : %dm 입니다",
                                distance[i]));
            } else {
                System.out.println(
                        String.format("Node %d is Non Visited Node", i));
            }
        }
    }
}

