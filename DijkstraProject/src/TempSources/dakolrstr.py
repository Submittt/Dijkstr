import networkx as nx
import matplotlib.pyplot as plt

# Define the graph
G = nx.Graph()

# Building Nodes (add edges between building nodes and junctions)
G.add_edge('MB', 'j16', weight=40)
G.add_edge('B2_B4', 'j4', weight=125)
G.add_edge('B5', 'j3', weight=50)
G.add_edge('B6_B9', 'j17', weight=50)
G.add_edge('HB', 'j6', weight=80)
G.add_edge('NB', 'j1', weight=116)
G.add_edge('NF', 'j16', weight=40)

# Junction Nodes (add edges between junction nodes)
G.add_edge('j1', 'NB', weight=116)
G.add_edge('j1', 'j2', weight=105)
G.add_edge('j1', 'j5', weight=331)

G.add_edge('j2', 'j3', weight=20)
G.add_edge('j2', 'j1', weight=105)
G.add_edge('j2', 'j15', weight=300)

G.add_edge('j3', 'B5', weight=40)
G.add_edge('j3', 'j4', weight=82)
G.add_edge('j3', 'j2', weight=20)

G.add_edge('j4', 'j3', weight=82)
G.add_edge('j4', 'B2_B4', weight=125)
G.add_edge('j4', 'j5', weight=168)

G.add_edge('j5', 'j1', weight=331)
G.add_edge('j5', 'j6', weight=165)
G.add_edge('j5', 'j4', weight=168)

G.add_edge('j6', 'HB', weight=6)
G.add_edge('j6', 'j8', weight=168)
G.add_edge('j6', 'j7', weight=86)

G.add_edge('j7', 'j6', weight=86)
G.add_edge('j7', 'j10', weight=133)

G.add_edge('j8', 'j6', weight=168)
G.add_edge('j8', 'j9', weight=37)

G.add_edge('j9', 'j8', weight=37)
G.add_edge('j9', 'j10', weight=30)
G.add_edge('j9', 'j13', weight=60)

G.add_edge('j10', 'j7', weight=133)
G.add_edge('j10', 'j9', weight=30)
G.add_edge('j10', 'j14', weight=63)

G.add_edge('j11', 'j4', weight=60)
G.add_edge('j11', 'j12', weight=70)
G.add_edge('j11', 'j15', weight=130)

G.add_edge('j12', 'MB', weight=30)
G.add_edge('j12', 'j11', weight=70)
G.add_edge('j12', 'j13', weight=90)

G.add_edge('j13', 'j12', weight=90)
G.add_edge('j13', 'j14', weight=30)
G.add_edge('j13', 'j9', weight=60)
G.add_edge('j13', 'j15', weight=245)

G.add_edge('j14', 'j10', weight=63)
G.add_edge('j14', 'j13', weight=30)
G.add_edge('j14', 'j17', weight=146)

G.add_edge('j15', 'j2', weight=300)
G.add_edge('j15', 'j11', weight=130)
G.add_edge('j15', 'j13', weight=245)

G.add_edge('j16', 'NF', weight=40)
G.add_edge('j16', 'j17', weight=28)
G.add_edge('j16', 'j15', weight=185)

G.add_edge('j17', 'j14', weight=146)
G.add_edge('j17', 'B6_B9', weight=50)
G.add_edge('j17', 'j16', weight=28)

# Draw the graph with node labels and edge weights
pos = nx.spring_layout(G)  # Positioning the nodes using spring layout
plt.figure(figsize=(12, 12))
nx.draw(G, pos, with_labels=True, node_size=1500, node_color='lightblue', font_size=10, font_weight='bold', edge_color='gray')

# Draw edge labels (weights)
edge_labels = nx.get_edge_attributes(G, 'weight')
nx.draw_networkx_edge_labels(G, pos, edge_labels=edge_labels)

plt.title("Graph Representation of Building and Junction Nodes")
plt.show()
