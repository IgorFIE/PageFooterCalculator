package main;

import java.util.*;

/**
 * Created by pacifist on 21-09-2017.
 */
public class PageFooterCalculator {

    protected List<Integer> visiblePages = new ArrayList<>();
    private int totalPages;

    public synchronized void printPageFooter(int currentPage, int totalPages, int boundaries, int around){
        visiblePages.clear();
        this.totalPages = totalPages;
        addVisiblePages(currentPage, boundaries, around);
        System.out.println(convertVisiblePagesToString());
    }

    private void addVisiblePages(int currentPage, int boundaries, int around) {
        addBoundariesPages(boundaries);
        addPage(currentPage);
        addAroundPages(currentPage,around);
        Collections.sort(visiblePages);
    }

    private void addBoundariesPages(int boundaries) {
        if(boundaries > 0){
            for(int count = 0; count < boundaries;count++){
                addPage(count + 1);
                addPage(totalPages - count);
            }
        }
    }

    private void addAroundPages(int currentPage, int around) {
        if(around > 0){
            for(int count = 1; count <= around;count++){
                addPage(currentPage + count);
                addPage(currentPage - count);
            }
        }
    }

    private void addPage(int place) {
        if(!(visiblePages.contains(place) || place < 1 || place > totalPages)){
            visiblePages.add(place);
        }
    }

    protected String convertVisiblePagesToString() {
        String result = "";
        int lastPage = 0;
        int currentPage;

        for(int index = 0; index < visiblePages.size(); index++){
            currentPage = visiblePages.get(index);
            if(lastPage + 1 != currentPage){
                result += "... " + currentPage;
            } else {
                result += currentPage;
            }

            if(index != visiblePages.size() - 1){
                lastPage = currentPage;
                result += " ";
            }
        }
        return result;
    }
}
