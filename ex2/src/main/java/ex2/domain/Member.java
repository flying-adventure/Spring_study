package ex2.domain;

import jakarta.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue

    @Column(name = "Member_ID")
    private Long Id;
    @Column(name = "Username")
    private String username;
    //@Column(name = "TEAM_ID")
    //private Long teamId;

    @ManyToOne
    @JoinColumn(name = "Team_ID")
    private Team team;
    //멤버:팀=N:1


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}