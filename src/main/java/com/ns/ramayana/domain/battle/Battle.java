package com.ns.ramayana.domain.battle;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import com.ns.ramayana.domain.characters.Character;
import java.io.Serializable;
import java.util.Scanner;
@ToString
@EqualsAndHashCode
public class Battle implements Serializable{

    @Getter
    private final Integer level;
    @ToString.Exclude
    private Character playerTeam;
    @ToString.Exclude
    private Character computerTeam;

    @Getter
    private Integer minimumReputationNeededToPlay;

    private String  battleDescription;

    @Getter
    private Integer battleId;

    public Battle(String battleDescription, Character playerTeam, Character computerTeam, Integer minimumReputationNeededToPlay, Integer battleId, Integer level) {
        this.playerTeam = playerTeam;
        this.computerTeam = computerTeam;
        this.minimumReputationNeededToPlay =minimumReputationNeededToPlay;
        this.battleDescription=battleDescription;
        this.battleId=battleId;
        this.level=level;
    }

    public Boolean fight() {

        while (playerTeam.isAlive() && computerTeam.isAlive()) {
            System.out.println(this.toString());
            System.out.println("_________________________________________________________");
            System.out.println("Select Attack or Defend");
            Scanner in = new Scanner(System.in);
            String str = in.nextLine();
            if (str.equalsIgnoreCase("Attack")) {
                System.out.println("Attack by Ram");
                computerTeam.defendAttack(playerTeam.attack());
            } else {
                System.out.println("Defend by Ram");
                playerTeam.defendAttack(computerTeam.attack());
            }
        }
        System.out.println("Computer Team Status " + computerTeam.isAlive());
        System.out.println("Player Team Status " + playerTeam.isAlive());

    return playerTeam.isAlive();

    }


}
