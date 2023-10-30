package repository;

import domain.BoardingGate;

import java.util.ArrayList;
import java.util.List;

public class BoardingGateRepo implements Repository<BoardingGate> {
    private List<BoardingGate> boardingGates = new ArrayList<>();

    @Override
    public void save(BoardingGate entity) {
        boardingGates.add(entity);
    }

    @Override
    public void remove(BoardingGate entity) {
        boardingGates.remove(entity);
    }

    @Override
    public List<BoardingGate> getAll() {
        return boardingGates;
    }
}
