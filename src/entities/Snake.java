package entities;

public class Snake extends BoardEntity{
    public Snake(int start, int end) {
        super(start, end);
    }

    @Override
    public String getEncounterMesage() {
        return "Awww!! you got hit by a snake";
    }

    @Override
    public String getString() {
        return "S( "+this.getEnd()+" )  ";
    }
}
