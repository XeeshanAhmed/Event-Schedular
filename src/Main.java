import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scheduler scheduler= new Scheduler();
        scheduler.readSeminars("seminars.txt");
        scheduler.readScheduling("schedules.txt");
        List<String> overlappingSeminars=scheduler.seminarsWithOverlappingAttendees();
        System.out.println("List of conflicting seminars due to overlapping students :");
        for(int i=0;i<overlappingSeminars.size();i+=2)
        {
            System.out.println(overlappingSeminars.get(i)+" conflicts with "+overlappingSeminars.get(i+1));
        }
        List<String> conflictingSeimars=scheduler.findSeminarsOnSameSlot();
        System.out.println("List of conflicting seminars on same slot:");
        for(int i=0;i<conflictingSeimars.size();i+=2)
        {
            System.out.println(conflictingSeimars.get(i)+" conflicts with "+overlappingSeminars.get(i+1));
        }
    }
}