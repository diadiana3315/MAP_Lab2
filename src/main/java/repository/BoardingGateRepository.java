package repository;

import domain.BoardingGate;

import java.util.ArrayList;
import java.util.List;

public class BoardingGateRepository implements Repository<BoardingGate> {
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

    @Override
    public BoardingGate getById(int id) {
        return null;
    }
}
