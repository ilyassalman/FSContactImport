package domain;

import net.fortuna.ical4j.model.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Joyce on 24.02.2015.
 */
@Entity
@Table(name = "userworks")
public class UserworksEntity extends BasePersistable implements Serializable {

    private EventsEntity event;
    private UsersEntity user;
    private Timestamp startTime;
    private Timestamp endTime;
    
    public UserworksEntity(UserworksEntity userwork){
        startTime = userwork.getStartTime();
        endTime = userwork.getEndTime();
    }

    public UserworksEntity(){
        super();
    }

    @Basic
    @Column(name = "StartTime")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "EndTime")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserworksEntity that = (UserworksEntity) o;

        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = startTime != null ? startTime.hashCode() : 0;
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserworksEntity{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "EventID", referencedColumnName = "ID")
    public EventsEntity getEvent() {
        return event;
    }

    public void setEvent(EventsEntity event) {
        this.event = event;
    }

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "ID")
    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    @Transient
    public DateTime getStart(){
        return convertTimeStampToTimestamp(startTime);
    }
    @Transient
    public DateTime getEnd(){
        return convertTimeStampToTimestamp(endTime);
    }
    private DateTime convertTimeStampToTimestamp(Timestamp stamp){
        return new DateTime(stamp.getTime());
    }
    @Transient
    public void setId(int id){
        this.id = id;
    }
}
