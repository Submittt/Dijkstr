package Dijkstra;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class pathData implements GraphIndex {

    public static Map<String, Integer> buildingNodeMap = new LinkedHashMap<>();  

        static {
        buildingNodeMap.put("본관", 1);
        buildingNodeMap.put("2&4호관", 2);
        buildingNodeMap.put("5호관", 3);
        buildingNodeMap.put("6&9호관", 4);
        buildingNodeMap.put("하이테크", 5);
        buildingNodeMap.put("나빌레관", 6);
        buildingNodeMap.put("미융대관", 7);
        }
    
    public static Map<String, Integer> junctionNodeMap = new LinkedHashMap<>();  

    static {
        junctionNodeMap.put("교차로_1", 8);
        junctionNodeMap.put("교차로_2", 9);
        junctionNodeMap.put("교차로_3", 10);
        junctionNodeMap.put("교차로_4", 11);
        junctionNodeMap.put("교차로_5", 12);
        junctionNodeMap.put("교차로_6", 13);
        junctionNodeMap.put("교차로_7", 14);
        junctionNodeMap.put("교차로_8", 15);
        junctionNodeMap.put("교차로_9", 16);
        junctionNodeMap.put("교차로_10", 17);
        junctionNodeMap.put("교차로_11", 18);
        junctionNodeMap.put("교차로_12", 19);
        junctionNodeMap.put("교차로_13", 20);
        junctionNodeMap.put("교차로_14", 21);
        junctionNodeMap.put("교차로_15", 22);
        junctionNodeMap.put("교차로_16", 23);
        junctionNodeMap.put("교차로_17", 24);
    }

    
    public static List<HashMap<Integer, Integer>> createAdjacencyList() {
        

        List<HashMap<Integer, Integer>> pathAdjacencyList = new ArrayList<>();
        
        for (int j = 0;  j < 25; j++) {
            pathAdjacencyList.add(new HashMap<>());
        }

        // Node Example
        // pathAdjacencyList.get(본관)
        //               .put( { AdjacencyNode(인접노드), Weight(가중치) });


        // Building Nodes
        pathAdjacencyList.get(본관)
                    .put(교차로_12, 30);
        pathAdjacencyList.get($2_4호관)
                    .put(교차로_4, 125);
        pathAdjacencyList.get($5호관)
                    .put(교차로_3, 50);
        pathAdjacencyList.get($6_9호관)
                    .put(교차로_17, 50);
        pathAdjacencyList.get(하이테크)
                    .put(교차로_6, 80);
        pathAdjacencyList.get(나빌레관)
                    .put(교차로_1, 116);
        pathAdjacencyList.get(미융대)
                    .put(교차로_16, 40);
        
        // Junction Nodes
        pathAdjacencyList.get(교차로_1).put(나빌레관, 116);
        pathAdjacencyList.get(교차로_1).put(교차로_2, 105);
        pathAdjacencyList.get(교차로_1).put(교차로_5, 331);
        
        pathAdjacencyList.get(교차로_2).put(교차로_3, 20);
        pathAdjacencyList.get(교차로_2).put(교차로_1, 105);
        pathAdjacencyList.get(교차로_2).put(교차로_15, 300);
        
        pathAdjacencyList.get(교차로_3).put($5호관, 40);
        pathAdjacencyList.get(교차로_3).put(교차로_4, 82);
        pathAdjacencyList.get(교차로_3).put(교차로_2, 20);
        
        pathAdjacencyList.get(교차로_4).put(교차로_3, 82);
        pathAdjacencyList.get(교차로_4).put($2_4호관, 125);
        pathAdjacencyList.get(교차로_4).put(교차로_5, 168);
        
        pathAdjacencyList.get(교차로_5).put(교차로_1, 331);
        pathAdjacencyList.get(교차로_5).put(교차로_6, 165);
        pathAdjacencyList.get(교차로_5).put(교차로_4, 168);
        
        pathAdjacencyList.get(교차로_6).put(하이테크, 6);
        pathAdjacencyList.get(교차로_6).put(교차로_8, 168);
        pathAdjacencyList.get(교차로_6).put(교차로_7, 86);
        
        pathAdjacencyList.get(교차로_7).put(교차로_6, 86);
        pathAdjacencyList.get(교차로_7).put(교차로_10, 133);
        
        pathAdjacencyList.get(교차로_8).put(교차로_6, 168);
        pathAdjacencyList.get(교차로_8).put(교차로_9, 37);
        
        pathAdjacencyList.get(교차로_9).put(교차로_8, 37);
        pathAdjacencyList.get(교차로_9).put(교차로_10, 30);
        pathAdjacencyList.get(교차로_9).put(교차로_13, 60);
        
        pathAdjacencyList.get(교차로_10).put(교차로_7, 133);
        pathAdjacencyList.get(교차로_10).put(교차로_9, 30);
        pathAdjacencyList.get(교차로_10).put(교차로_14, 63);
        
        pathAdjacencyList.get(교차로_11).put(교차로_4, 60);
        pathAdjacencyList.get(교차로_11).put(교차로_12, 70);
        pathAdjacencyList.get(교차로_11).put(교차로_15, 130);
        
        pathAdjacencyList.get(교차로_12).put(본관, 30);
        pathAdjacencyList.get(교차로_12).put(교차로_11, 70);
        pathAdjacencyList.get(교차로_12).put(교차로_13, 90);
        
        pathAdjacencyList.get(교차로_13).put(교차로_12, 90);
        pathAdjacencyList.get(교차로_13).put(교차로_14, 30);
        pathAdjacencyList.get(교차로_13).put(교차로_9, 60);
        pathAdjacencyList.get(교차로_13).put(교차로_15, 245);
        
        pathAdjacencyList.get(교차로_14).put(교차로_10, 63);
        pathAdjacencyList.get(교차로_14).put(교차로_13, 30);
        pathAdjacencyList.get(교차로_14).put(교차로_17, 146);
        
        pathAdjacencyList.get(교차로_15).put(교차로_2, 300);
        pathAdjacencyList.get(교차로_15).put(교차로_11, 130);
        pathAdjacencyList.get(교차로_15).put(교차로_13, 245);
        pathAdjacencyList.get(교차로_15).put(교차로_16, 185);
        
        pathAdjacencyList.get(교차로_16).put(미융대, 40);
        pathAdjacencyList.get(교차로_16).put(교차로_17, 28);
        pathAdjacencyList.get(교차로_16).put(교차로_15, 185);
        
        pathAdjacencyList.get(교차로_17).put(교차로_14, 146);
        pathAdjacencyList.get(교차로_17).put($6_9호관, 50);
        pathAdjacencyList.get(교차로_17).put(교차로_16, 28);
        
        return pathAdjacencyList;
    }

    public static int parseStringToInt(String inputValue) {
        Integer buildingNumber = buildingNodeMap.get(inputValue);
        return buildingNumber.intValue();
    }

    public static String parseIntToString(int inputValue) {
        for (Map.Entry<String, Integer> entry : buildingNodeMap.entrySet()) {
            if (entry.getValue() == inputValue) {
                return entry.getKey();
            }
        }
        
        for (Map.Entry<String, Integer> entry : junctionNodeMap.entrySet()) {
            if (entry.getValue() == inputValue) {
                return entry.getKey();
            }
        }
        return null;
    } 

    public static void showInformation() {
        System.out.println(
                "\n캠퍼스 내의 강의실 간 최단거리 계산\n##다익스트라 알고리즘##" 
            );
        System.out.println(
            "\n입력 가능 건물 리스트입니다\n반드시 문자열로 입력해주세요!\n"
        );

        for (String key : buildingNodeMap.keySet()) {
            System.out.printf("%s \n", key);
        }
        System.out.println("");
}

}
