import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Event1 {

    public Event1(String eventName, LocalDate eventDate) {
        this.eventName = eventName;
        this.eventDate = eventDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public Event1() {
    }

    String eventName;
    LocalDate eventDate;

    @Override
    public String toString() {
        return "Event1{" +
                "eventName='" + eventName + '\'' +
                ", eventDate=" + eventDate +
                '}';
    }

    public static void main(String[] args)
    {
        Event1 e1=new Event1("Music1",LocalDate.of(2024,1,1));
        Event1 e2=new Event1("concert1",LocalDate.of(2024,1,2));
        Event1 e3=new Event1("sports",LocalDate.of(2024,1,3));

        ArrayList<Event1>list=new ArrayList<>();
        list.add(e1);
        System.out.println(list);
        list.add(e2);
        System.out.println(list);
        list.add(e3);
        System.out.println(list);

        Collections.sort(list, Comparator.comparing(Event1::getEventDate));

        // Printing events
        for (Event1 event : list) {
            System.out.println(event);
        }
    }
}
