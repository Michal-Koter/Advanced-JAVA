package org.example.tools;

import org.example.model.Geography;
import org.example.model.abstraction.IHaveHierarchicalStructure;

import java.util.*;

public class Hierarchy <TItem extends IHaveHierarchicalStructure> {
    private TItem root;

    public void setRootElement(TItem tItem) {
        root = tItem;
    }

    public TItem findElementById(int index) {
        Queue<TItem> queue = new LinkedList(root.getChildren());
        TItem pulled;
        TItem result = null;
        while (queue.size() != 0) {
            pulled = queue.poll();
            Iterator<TItem> iterator = pulled.getChildren().iterator();
            while (iterator.hasNext()) {
                TItem next = iterator.next();
                if (next.getId() != index) {
                    queue.add(next);
                } else {
                    result = next;
                }
            }
        }
        return result;
    }
}
