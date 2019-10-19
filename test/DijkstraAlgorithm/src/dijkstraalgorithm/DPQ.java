
package dijkstraalgorithm;
import java.util.*; 

public class DPQ {
    private int dist[]; 
    private Set<Integer> settled; 
    private PriorityQueue<Node> pq; 
    private int V; // indica el numero de vertices
    List<List<Node> > adj; 
  
    public DPQ(int V) 
    { 
        this.V = V; 
        dist = new int[V]; 
        settled = new HashSet<Integer>(); 
        pq = new PriorityQueue<Node>(V, new Node()); 
    } 
  
    // Function para el algoritmo de Dijkstra
    public void dijkstra(List<List<Node> > adj, int src) 
    { 
        this.adj = adj; 
  
        for (int i = 0; i < V; i++) 
            dist[i] = Integer.MAX_VALUE; 
  
        // añadir nodo fuente a la cola de prioridad
        pq.add(new Node(src, 0)); 
  
        // incializa la ditancia a esa fuente en 0 
        dist[src] = 0; 
        while (settled.size() != V) { 
  
            // remueve e nodo de menor distancia de la cola de prioridad
            int u = pq.remove().node; 
  
            
            settled.add(u); 
  
            e_Neighbours(u); 
        } 
    } 
  
    // Funcion que procesa los nodos vecinos 
    // de el nodo anterior 
    private void e_Neighbours(int u) 
    { 
        int edgeDistance = -1; 
        int newDistance = -1; 
  
        // todos los vecinos de v
        for (int i = 0; i < adj.get(u).size(); i++) { 
            Node v = adj.get(u).get(i); 
  
            // si actual nodo ha sido procesado
            if (!settled.contains(v.node)) { 
                edgeDistance = v.cost; 
                newDistance = dist[u] + edgeDistance; 
  
                // Si la nueva distancia es más barata en costo 
                if (newDistance < dist[v.node]) 
                    dist[v.node] = newDistance; 
  
                // Anadir ndo actual a la cola de prioridad 
                pq.add(new Node(v.node, dist[v.node])); 
            } 
        } 
    } 
  

    public static void main(String arg[]) 
    { 
        int V = 5; 
        int source = 0; 
  
        List<List<Node> > adj = new ArrayList<List<Node> >(); 
   
        for (int i = 0; i < V; i++) { 
            List<Node> item = new ArrayList<Node>(); 
            adj.add(item); 
        } 
        adj.get(0).add(new Node(1, 9)); 
        adj.get(0).add(new Node(2, 6)); 
        adj.get(0).add(new Node(3, 5)); 
        adj.get(0).add(new Node(4, 3)); 
  
        adj.get(2).add(new Node(1, 2)); 
        adj.get(2).add(new Node(3, 4)); 
  
        // Calculo del camino mas corto 
        DPQ dpq = new DPQ(V); 
        dpq.dijkstra(adj, source); 
  
        // Imprime el camino mas corto de todos los nodos desde el nodo fuente 
        System.out.println("The shorted path from node :"); 
        for (int i = 0; i < dpq.dist.length; i++) 
            System.out.println(source + " to " + i + " is "
                               + dpq.dist[i]); 
    }
}
