import java.util.*;

public class BreadthFirstSearch {
    static class Node {
        char data;
        List<Node> neighbors;

        Node(char data) {
            this.data = data;
            this.neighbors = new ArrayList<>();
        }
    }

    public static List<Character> bfs(Node start, Node destination) {
        if (start == null || destination == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> parentMap = new HashMap<>();
        Set<Node> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current == destination) {
                return constructPath(parentMap, destination);
            }

            for (Node neighbor : current.neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                }
            }
        }

        return null; // If no path is found
    }

    private static List<Character> constructPath(Map<Node, Node> parentMap, Node destination) {
        List<Character> path = new LinkedList<>();
        for (Node at = destination; at != null; at = parentMap.get(at)) {
            path.add(at.data);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example graph setup
        Node nodeA = new Node('A');
        Node nodeB = new Node('B');
        Node nodeC = new Node('C');
        Node nodeD = new Node('D');
        Node nodeE = new Node('E');

        nodeA.neighbors.add(nodeB);
        nodeA.neighbors.add(nodeC);
        nodeB.neighbors.add(nodeD);
        nodeC.neighbors.add(nodeE);
        nodeD.neighbors.add(nodeE);

        Map<Character, Node> nodes = new HashMap<>();
        nodes.put('A', nodeA);
        nodes.put('B', nodeB);
        nodes.put('C', nodeC);
        nodes.put('D', nodeD);
        nodes.put('E', nodeE);

        System.out.println("Available nodes: " + nodes.keySet());

        System.out.println("Enter the start node:");
        char startChar = Character.toUpperCase(scanner.next().charAt(0));

        System.out.println("Enter the destination node:");
        char destinationChar = Character.toUpperCase(scanner.next().charAt(0));

        Node startNode = nodes.get(startChar);
        Node destinationNode = nodes.get(destinationChar);

        List<Character> path = bfs(startNode, destinationNode);
        if (path != null) {
            System.out.println("Path: " + path);
        } else {
            System.out.println("No path found");
        }

        scanner.close();
    }
}

