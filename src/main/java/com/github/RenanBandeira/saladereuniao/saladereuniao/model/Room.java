package com.github.RenanBandeira.saladereuniao.saladereuniao.model;


import javax.persistence.*;

@Entity
@Table(name="meentingroom")
public class Room {

    private long id;
    private String name;
    private String date;
    private String starHour;
    private String endHour;

    public Room() {

    }

    public Room(long id, String name, String date, String starHour, String endHour) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.starHour = starHour;
        this.endHour = endHour;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    @Column(name="name", nullable = false)
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Column(name="date", nullable = false)
    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }

    @Column(name="starhour", nullable = false)
    public String getStarHour() {
        return starHour;
    }


    public void setStarHour(String starHour) {
        this.starHour = starHour;
    }

    @Column(name="endhour", nullable = false)
    public String getEndHour() {
        return endHour;
    }


    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

@Override
    public String toString(){
        return "room [id="+id+",name="+name+",starthour="+starHour+",endhour="+endHour+"]";
}

}
