package de.kiltz.vorgang.rs;

import java.util.List;

/**
 * @author tz (F0290158)
 */
public class Page<T> {
    private List<T> elements;
    // Zero-based
    private int page;
    private int size;
    private int totalPages;
    private int totalElements;

    public Page() {
    }

    public Page(List<T> elements, int page, int size, int totalElements) {
        this.elements = elements;
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
    }

    public List<T> getElements() {
        return elements;
    }

    public void setElements(List<T> elements) {
        this.elements = elements;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPages() {
        totalPages = (int) (totalElements / size);
        totalPages = totalElements % size == 0 ? totalPages : ++totalPages;

        return totalPages;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }
}
