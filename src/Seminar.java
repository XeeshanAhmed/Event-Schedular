import java.util.ArrayList;
import java.util.List;

public class Seminar {
    private String topic;
    private String speaker;
    List<Integer> attendees = new ArrayList<>();
    Room room;
    Slot timeSlot;

    public Seminar(String topic,String speaker)
    {
        this.topic=topic;
        this.speaker=speaker;
    }
    public void setTopic(String topic)
    {
        this.topic=topic;
    }
    public String getTopic()
    {
        return this.topic;
    }
    public void setSpeaker(String speaker)
    {
        this.speaker=speaker;
    }
    public String getSpeaker()
    {
        return this.speaker;
    }
    public void addAttandee(Integer attendee)
    {
        this.attendees.add(attendee);
    }
    public void setRoom(Room room)
    {
        this.room=room;
    }
    public Room getRoom()
    {
        return this.room;
    }
    public void setTimeSlot(Slot timeSlot)
    {
        this.timeSlot=timeSlot;
    }
    public Slot getTimeSlot()
    {
        return this.timeSlot;
    }
    public List<Integer> getAttendees()
    {
        return this.attendees;
    }
}
