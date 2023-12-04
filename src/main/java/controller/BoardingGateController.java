package controller;

import domain.BoardingGate;
import repository.BoardingGateRepository;

import java.sql.SQLException;

public class BoardingGateController {
    private BoardingGateRepository boardingGateRepository;

    public BoardingGateController(BoardingGateRepository boardingGateRepository) {
        this.boardingGateRepository = boardingGateRepository;
    }


    public void addBoardingGate(BoardingGate boardingGate) throws SQLException {
        boardingGateRepository.addBoardingGate(boardingGate);
    }

    public void removeBoardingGate(int gateNumber) throws SQLException {
        boardingGateRepository.deleteBoardingGate(gateNumber);
    }

    public void getAllBoardingGates() throws SQLException {
        boardingGateRepository.viewBoradingGates();
    }
}
