package entities;

public class Ladder extends BoardEntity{


    public Ladder(int start, int end) {
        super(start, end);
    }

    @Override
    public String getEncounterMesage() {
        return "You have got on to a ladder";
    }

    @Override
    public String getString() {
        return "L( "+this.getEnd()+" )  ";
    }
}
