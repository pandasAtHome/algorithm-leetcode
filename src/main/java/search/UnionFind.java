package search;

import java.util.HashMap;
import java.util.Map;

public class UnionFind<E> {
    /**
     * 映射：子节点 => (父节点 or 根节点)
     *  - 父节点 != 根节点
     *      - 3 -> 2 -> 1 (父节点 = 2，根节点 = 1)
     */
    private final Map<E, E> parent;
    // 模块数量：每个模块的节点间没有联系
    private int connectNum = 0;

    public UnionFind() {
        this.parent = new HashMap<>();
    }

    // 新增节点
    public void add(E node) {
        if (parent.containsKey(node)) {
            parent.put(node, null);
            connectNum++;
        }
    }

    // 合并节点
    public void union(E nodeA, E nodeB) {
        E rootA = find(nodeA);
        E rootB = find(nodeB);
        // 根节点不一致，增加新节点
        if (rootA != rootB) {
            parent.put(rootA, rootB);
            connectNum--;
        }
    }

    // 查找根节点 & 缩短查找路径
    public E find(E node) {
        E root = node;

        // 查找根节点
        while (parent.get(root) != null) {
            root = parent.get(root);
        }

        // 缩短 子节点 查找 根节点的复杂度
        while (node != root) {
            E oldParent = parent.get(node);
            // 重置当前子节点的根节点
            parent.put(node, root);
            node = oldParent;
        }

        return root;
    }

    // 判断两个节点是否有联系
    public boolean isConnected(E nodeA, E nodeB) {
        return find(nodeA) == find(nodeB);
    }

    // 获取模块数量
    public int getConnectNum() {
        return connectNum;
    }
}
