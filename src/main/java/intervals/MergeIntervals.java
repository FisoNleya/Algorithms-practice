package intervals;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {

        mergeIntervals();

    }


    public static void  mergeIntervals(){

        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(9,12));


        int currStart = intervals.get(0).start;
        int currEnd = intervals.get(0).end;


        System.out.println("Unmerged list : "+ intervals);

        List<Interval> mergedList = new ArrayList<>();

        for(int i = 1; i < intervals.size(); i++){

            Interval currInterval = intervals.get(i);

            if(currInterval.start> currEnd){
                mergedList.add(new Interval(currStart, currEnd));
                currStart = currInterval.start;
                currEnd = currInterval.end;
            }else {

                currStart = currInterval.start <= currStart? currInterval.start:currStart;
                currEnd = currInterval.end >=currEnd? currInterval.end: currEnd;
            }

        }

        mergedList.add(new Interval(currStart, currEnd));
        System.out.println("Merged list : "+ mergedList);

    }

}

class Interval {

    int start;
    int end;

    Interval(int start , int end){
        this.start = start;
        this.end = end;
    }

    public String toString(){
        return "{"+start+ ","+end+"}";
    }

}