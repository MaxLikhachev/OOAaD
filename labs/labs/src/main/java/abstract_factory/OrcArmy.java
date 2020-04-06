package abstract_factory;

import java.util.ArrayList;

public class OrcArmy implements Army {

    King king;
    ArrayList<General> generals = new ArrayList<>();
    ArrayList<Soldier> soldiers = new ArrayList<>();

    public OrcArmy(String kingName, int generalsCount, int soldiersCount) {
        this.king = this.createKing(kingName);
        
        for (int i = 0; i < generalsCount; i++) {
            generals.add(createGeneral(i + 1));

            for (int j = 0; j < soldiersCount / generalsCount; j++) {
                soldiers.add(createSoldier((i + 1) * (10 ^ ((int)(String.valueOf(Math.abs(soldiersCount)).length()) + 1)) + j));            
            }
        }
    }

    @Override
    public King createKing(String name) {
        return new OrcKing(name);
    }

    @Override
    public General createGeneral(int index) {
        return new OrcGeneral(index);
    }

    @Override
    public Soldier createSoldier(int index) {
        return new OrcSoldier(index);
    }

    @Override
    public void attack() {
        this.king.attack();
        
        for (General general : generals) {
            general.attack();
        }

        for (Soldier soldier : soldiers) {
            soldier.attack();
        }
    }

    @Override
    public void defend() {
        this.king.defend();
        
        for (General general : generals) {
            general.defend();
        }

        for (Soldier soldier : soldiers) {
            soldier.defend();
        }
    }

    @Override
    public void throwUp() {
        this.king.throwUp();
        
        for (General general : generals) {
            general.throwUp();
        }

        for (Soldier soldier : soldiers) {
            soldier.throwUp();
        }
    }

    @Override
    public int getPower() {
        return 1 + this.generals.size() + this.soldiers.size();
    }

}