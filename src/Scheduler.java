import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<Seminar> seminars;

    public Scheduler()
    {
        seminars=new ArrayList<>();
    }
    public void readSeminars(String filePath)
    {
        BufferedReader reader=null;
        try{
            reader=new BufferedReader(new FileReader(filePath));
            String line;
            line=reader.readLine();
            while(line!=null)
            {
                String[]parts=line.split(",");
                String topic=parts[0];
                String speaker=parts[1];
                Seminar s=new Seminar(topic,speaker);
                for(int i=2;i<parts.length;i++)
                {
                    s.addAttandee(Integer.parseInt(parts[i]));
                }
                seminars.add(s);
                line=reader.readLine();
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File "+filePath+" not found");
        }
        catch(IOException e)
        {
            System.out.println("Error reading the file");
        }
        finally{
            if(reader!=null)
            {
                try
                {
                    reader.close();
                }
                catch(IOException e)
                {
                    System.out.println("Error closing the file");
                }
            }
        }
    }
    public void readScheduling(String filePath)
    {
        BufferedReader reader=null;
        try
        {
            reader=new BufferedReader(new FileReader(filePath));
            String line;
            line=reader.readLine();
            while(line!=null)
            {
                String[] parts=line.split(",");
                String seminarName=parts[0];
                Room room=new Room(parts[1]);
                Slot slot=new Slot(Integer.parseInt(parts[2]));
                int timeSlot=Integer.parseInt(parts[2]);
                for(int i=0;i<seminars.size();i++)
                {
                    if(seminars.get(i).getTopic().equals(seminarName))
                    {
                        seminars.get(i).setRoom(room);
                        seminars.get(i).setTimeSlot(slot);
                    }
                }
                line=reader.readLine();
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File "+filePath+" not found");
        }
        catch(IOException e)
        {
            System.out.println("Error while reading the file");
        }
        finally{
            if(reader!=null)
            {
                try
                {
                    reader.close();
                }
                catch(IOException e)
                {
                    System.out.println("Error closing the file");
                }
            }
        }
    }

    public List<String> seminarsWithOverlappingAttendees()
    {
        List<String> overlappingSeminars=new ArrayList<>();
        for(int i=0;i< seminars.size();i++)
        {
            for(int j=i+1;j<seminars.size();j++)
            {
                for(int k=0;k<seminars.get(i).attendees.size();k++)
                {
                    if(seminars.get(j).attendees.contains(seminars.get(i).attendees.get(k)) && (seminars.get(i).getTimeSlot().getSlot()==seminars.get(j).getTimeSlot().getSlot()) )
                    {
                        overlappingSeminars.add(seminars.get(i).getTopic());
                        overlappingSeminars.add(seminars.get(j).getTopic());
                        break;
                    }
                }
            }
        }
        return overlappingSeminars;
    }
    public List<String> findSeminarsOnSameSlot()
    {
        List<String> conflictingSeminars=new ArrayList<>();
        for(int i=0;i<seminars.size();i++)
        {
            for(int j=i+1;j<seminars.size();j++)
            {
                if((seminars.get(i).getTimeSlot().getSlot()==seminars.get(j).getTimeSlot().getSlot()) && (seminars.get(i).getRoom().getRoomNo().equals(seminars.get(j).getRoom().getRoomNo())))
                {
                    conflictingSeminars.add(seminars.get(i).getTopic());
                    conflictingSeminars.add(seminars.get(j).getTopic());

                }
            }
        }
        return conflictingSeminars;
    }
}
