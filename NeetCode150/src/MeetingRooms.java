import java.util.Comparator;
import java.util.List;

public class MeetingRooms {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.start));

        for(int i = 1; i < intervals.size(); i++){
            if(intervals.get(i).start < intervals.get(i - 1).start){
                return false;
            }
        }
        return true;
    }
}
