package models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Schedule {
    private int id;
    private String movieName;
    private int cost;
    private String date;
    private String time;
    private int seatsAvailable;
}
