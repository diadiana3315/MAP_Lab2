package controller;

import domain.BoardingGate;

import repository.Repository;

import java.util.List;

public class BoardingGateController {
    private Repository<BoardingGate> boardingGateRepository;

    public BoardingGateController(Repository<BoardingGate> boardingGateRepository) {
        this.boardingGateRepository = boardingGateRepository;
    }


    public void addBoardingGate(BoardingGate boardingGate) {
        boardingGateRepository.save(boardingGate);
    }

    public void removeBoardingGate(int gateNumber) {
        List<BoardingGate> boardingGates = boardingGateRepository.getAll();
        for (BoardingGate gate : boardingGates) {
            if (gate.getGateNumber() == gateNumber) {
                boardingGateRepository.remove(gate);
                return;
            }
        }
        System.out.println("Boarding gate not found.");
    }

    public List<BoardingGate> getAllBoardingGates() {
        return boardingGateRepository.getAll();
    }
}
