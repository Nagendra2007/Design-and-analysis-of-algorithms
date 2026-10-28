import java.util.*;

public class HuffmanCoding {
    static class Node {
        char ch;
        int freq;
        Node left;
        Node right;
        long id;
        Node(char ch, int freq, Node left, Node right, long id) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
            this.id = id;
        }
        boolean isLeaf() {
            return left == null && right == null;
        }
    }

    static long seq = 0;

    static Map<Character, Integer> frequency(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    static Node buildTree(Map<Character, Integer> freq) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.<Node>comparingInt(n -> n.freq).thenComparingLong(n -> n.id));
        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            pq.add(new Node(e.getKey(), e.getValue(), null, null, seq++));
        }
        if (pq.size() == 1) {
            Node leaf = pq.poll();
            Node parent = new Node('\0', leaf.freq, leaf, null, seq++);
            pq.add(parent);
        }
        while (pq.size() > 1) {
            Node a = pq.poll();
            Node b = pq.poll();
            Node parent = new Node('\0', a.freq + b.freq, a, b, seq++);
            pq.add(parent);
        }
        return pq.poll();
    }

    static void buildCode(Node x, String prefix, Map<Character, String> st) {
        if (x.isLeaf()) {
            st.put(x.ch, prefix.length() > 0 ? prefix : "0");
            return;
        }
        if (x.left != null) buildCode(x.left, prefix + "0", st);
        if (x.right != null) buildCode(x.right, prefix + "1", st);
    }

    static String encode(String s, Map<Character, String> codes) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) sb.append(codes.get(c));
        return sb.toString();
    }

    static String decode(String bits, Node root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return "";
        if (root.isLeaf()) {
            for (int i = 0; i < bits.length(); i++) sb.append(root.ch);
            return sb.toString();
        }
        Node x = root;
        for (int i = 0; i < bits.length(); i++) {
            char b = bits.charAt(i);
            x = b == '0' ? x.left : x.right;
            if (x.isLeaf()) {
                sb.append(x.ch);
                x = root;
            }
        }
        return sb.toString();
    }

    static String showChar(char c) {
        if (c == ' ') return "' '";
        if (c == '\n') return "\\n";
        if (c == '\t') return "\\t";
        return String.valueOf(c);
    }

    public static void main(String[] args) {
        String text = "this is an example for huffman encoding";
        Map<Character, Integer> freq = frequency(text);
        Node root = buildTree(freq);
        Map<Character, String> codes = new LinkedHashMap<>();
        buildCode(root, "", codes);
        String encoded = encode(text, codes);
        String decoded = decode(encoded, root);

        System.out.println("Original: " + text);
        System.out.println("Frequencies:");
        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            System.out.println(showChar(e.getKey()) + " -> " + e.getValue());
        }
        System.out.println("Codes:");
        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            char c = e.getKey();
            System.out.println(showChar(c) + " -> " + codes.get(c));
        }
        System.out.println("Encoded length (bits): " + encoded.length());
        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + decoded);
        System.out.println("Match: " + text.equals(decoded));
    }
}