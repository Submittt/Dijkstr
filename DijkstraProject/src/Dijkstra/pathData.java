package Dijkstra;

import java.util.List;
import java.util.ArrayList;

public class pathData implements GraphIndex {

    
    public static List<List<int[]>> createAdjacencyList() {
        List<List<int[]>> pathAdjacencyList = new ArrayList<>();
        

        for (int i = 0; i < 25; i++) {
            pathAdjacencyList.add(new ArrayList<>());
        }

        // Node Example
        // pathAdjacencyList.get(Main_B)
        //                  .add(new int[] { AdjacencyNode(인접노드), Weight(가중치) });


        // Building Nodes
        pathAdjacencyList.get(Main_B)
                        .add(new int[] {j12,30});
        pathAdjacencyList.get(B2_B4)
                        .add(new int[] {j4,125});
        pathAdjacencyList.get(B5)
                        .add(new int[] {j3,50});
        pathAdjacencyList.get(B6_B9)
                        .add(new int[] {j17,50});
        pathAdjacencyList.get(HighTech_B)
                        .add(new int[] {j6,80});
        pathAdjacencyList.get(Naville_B)
                        .add(new int[] {j1,116});
        pathAdjacencyList.get(FC_B)
                        .add(new int[] {j16,40});

        
        // Junction Nodes
        pathAdjacencyList.get(j1).add(new int[] {Naville_B,116});
        pathAdjacencyList.get(j1).add(new int[] {j2,105});
        pathAdjacencyList.get(j1).add(new int[] {j5,331});

        pathAdjacencyList.get(j2).add(new int[] {j3,20});
        pathAdjacencyList.get(j2).add(new int[] {j1,105});
        pathAdjacencyList.get(j2).add(new int[] {j15,300});

        pathAdjacencyList.get(j3).add(new int[] {B5,40});
        pathAdjacencyList.get(j3).add(new int[] {j4,82});
        pathAdjacencyList.get(j3).add(new int[] {j2,20});

        pathAdjacencyList.get(j4).add(new int[] {j3,82});
        pathAdjacencyList.get(j4).add(new int[] {B2_B4,125});
        pathAdjacencyList.get(j4).add(new int[] {j5,168});

        pathAdjacencyList.get(j5).add(new int[] {j1,331});
        pathAdjacencyList.get(j5).add(new int[] {j6,165});
        pathAdjacencyList.get(j5).add(new int[] {j4,168});

        pathAdjacencyList.get(j6).add(new int[] {HighTech_B,6});
        pathAdjacencyList.get(j6).add(new int[] {j8,168});
        pathAdjacencyList.get(j6).add(new int[] {j7,86});

        pathAdjacencyList.get(j7).add(new int[] {j6,86});
        pathAdjacencyList.get(j7).add(new int[] {j10,133});

        pathAdjacencyList.get(j8).add(new int[] {j6,168});
        pathAdjacencyList.get(j8).add(new int[] {j9,37});

        pathAdjacencyList.get(j9).add(new int[] {j8,37});
        pathAdjacencyList.get(j9).add(new int[] {j10,30});
        pathAdjacencyList.get(j9).add(new int[] {j13,60});

        pathAdjacencyList.get(j10).add(new int[] {j7,133});
        pathAdjacencyList.get(j10).add(new int[] {j9,30});
        pathAdjacencyList.get(j10).add(new int[] {j14,63});

        pathAdjacencyList.get(j11).add(new int[] {j4,60});
        pathAdjacencyList.get(j11).add(new int[] {j12,70});
        pathAdjacencyList.get(j11).add(new int[] {j15,130});

        pathAdjacencyList.get(j12).add(new int[] {Main_B,30});
        pathAdjacencyList.get(j12).add(new int[] {j11,70});
        pathAdjacencyList.get(j12).add(new int[] {j13,90});

        pathAdjacencyList.get(j13).add(new int[] {j12,90});
        pathAdjacencyList.get(j13).add(new int[] {j14,30});
        pathAdjacencyList.get(j13).add(new int[] {j9,60});
        pathAdjacencyList.get(j13).add(new int[] {j15,245});

        pathAdjacencyList.get(j14).add(new int[] {j10,63});
        pathAdjacencyList.get(j14).add(new int[] {j13,30});
        pathAdjacencyList.get(j14).add(new int[] {j17,146});

        pathAdjacencyList.get(j15).add(new int[] {j2,300});
        pathAdjacencyList.get(j15).add(new int[] {j11,130});
        pathAdjacencyList.get(j15).add(new int[] {j13,245});
        pathAdjacencyList.get(j15).add(new int[] {j16,185});

        pathAdjacencyList.get(j16).add(new int[] {FC_B,40});
        pathAdjacencyList.get(j16).add(new int[] {j17,28});
        pathAdjacencyList.get(j16).add(new int[] {j15,185});

        pathAdjacencyList.get(j17).add(new int[] {j14,146});
        pathAdjacencyList.get(j17).add(new int[] {B6_B9,50});
        pathAdjacencyList.get(j17).add(new int[] {j16,28});
    
        return pathAdjacencyList;
    }
}
