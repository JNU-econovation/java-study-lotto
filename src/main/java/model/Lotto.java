package model;

import dto.LottoDTO;
import utils.AutoTicketGenerator;
import utils.ManualTicketGenerator;

import java.util.*;

public class Lotto {
    private List<LottoNo> ticket;

    public Lotto() {
        this.ticket = AutoTicketGenerator.issue();
    }

    public Lotto(String manualBalls) {
        this.ticket = ManualTicketGenerator.issue(manualBalls);
    }

    public List<LottoNo> getTicket() {
        return ticket;
    }

    public LottoDTO toLottoDTO() {
        return new LottoDTO(ticket);
    }
}