package abstract_factory;

public interface Army {
    King createKing(String name);
    General createGeneral(int index);
    Soldier createSoldier(int index);

    void attack();
    void defend();
    void throwUp();

    int getPower();
}