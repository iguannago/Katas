package com.WilliamHill;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 03/05/2016.
 */
public class NodeTest {

    private Node node = new Node();
    private Node child = new Node();

    @Test
    public void addAChildToANodeTest() {
        node.addChild(child);
        List<Node> children = node.getChildren();
        assertEquals(1, children.size());
    }

    @Test
    public void getAllDescendantTest() {
        node.addChild(child);
        Set<Node> descendants = node.getAllDescendants();
        assertEquals(1, descendants.size());
    }

    @Test
    public void getAllDescendantsForAChildWithAChild() {
        Node thirdChild = new Node();
        Node anotherChild = new Node();
        anotherChild.addChild(thirdChild);
        child.addChild(anotherChild);
        node.addChild(child);
        assertEquals(3, node.getAllDescendants().size());
    }

}
