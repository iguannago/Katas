package com.WilliamHill;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by davicres on 03/05/2016.
 */
public class Node {
    private List<Node> children = new ArrayList<>();

    public void addChild(Node node) {
        children.add(node);
    }

    public List<Node> getChildren() {
        return children;
    }

    public Set<Node> getAllDescendants() {
        Set<Node> descendants = new HashSet<>();
        descendants.addAll(children);
        for (Node node: children) {
            descendants.addAll(node.getAllDescendants());
        }
        return descendants;
    }
}
