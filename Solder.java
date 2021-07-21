package dz7;

import java.util.Random;

public class Solder {

    protected String name;
    protected float attack;
    protected float defense;
    protected float hp;
    private Random random = new Random();

    public Solder(String name, float attack, float defense, float hp) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        if (hp < 0) {
            this.hp = -hp;
        } else {
            this.hp = hp;
        }
    }

    public Solder(String name, float attack) {
        this.name = name;
        this.attack = attack;
    }

    public void attack(Solder enemy) {
        if (enemy != this) {
            float dealDamage = (this.attack - (this.attack / enemy.defense)) * random.nextFloat();
            enemy.hp -= dealDamage;
            System.out.println(this.name + " deal damage " + enemy.name + " >> " + dealDamage + " dmg. ");
        } else {
            System.out.println(" Its me ");
        }
    }

    public void heal(Solder enemy) {
        if (enemy.hp > 150) {
            System.out.println(this.name + " try heal " + enemy.name + ", but heal failed");
        } else {
            float summeryHeal = this.attack * random.nextFloat();
            enemy.hp += summeryHeal;
            System.out.println(this.name + " heal " + enemy.name + " on: " + summeryHeal);
        }
    }


    public void baf(Solder enemy) {
        if (enemy.attack > 50) {
            System.out.println("Baf failed");
        } else {
            float castBaf = this.attack + random.nextFloat();
            enemy.attack += castBaf;
            System.out.println(this.name + " increased the attack " + enemy.name + " by: " + castBaf);
        }
    }

    public void criticalDamage(Solder enemy) {
        if (this.hp < 50) {
            float critical = 50f;
            enemy.hp -= critical;
            System.out.println(this.name + " deal critical damage: " + critical + " to the " + enemy.name);
        }
    }

    public String getMeInfo() {
        return " My name is " + this.name + ". My attack is " + this.attack + ". My heal is " + this.hp;
    }

    public boolean isDeadSolder() {
        return this.hp <= 0;
    }
}
