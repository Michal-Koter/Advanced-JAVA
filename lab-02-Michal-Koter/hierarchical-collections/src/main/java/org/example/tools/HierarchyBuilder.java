package org.example.tools;

import org.example.model.abstraction.IHaveHierarchicalStructure;

import java.util.List;

public class HierarchyBuilder <TItem extends IHaveHierarchicalStructure> {
    private List<TItem> elements;
    private TItem root;

    public void setElements(List<TItem> elements) {
        this.elements = elements;
    }

    public void buildHierarchy() {
        for (TItem element:elements) {
            Integer parentID = element.getParentId();
            if (parentID != null){
                TItem parent = findParent(parentID);
                element.setParent(parent);
                parent.getChildren().add(element);
            } else {
                root = element;
            }
        }
    }

    public TItem getRootElement() {
        return root;
    }

    private TItem findParent(Integer index) {
        for (TItem element: elements) {
            if (index == element.getId()) {
                return element;
            }
        }
        return null;
    }
}
