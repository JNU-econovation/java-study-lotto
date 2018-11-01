package model;

import utils.AutoTicketGenerator;
import utils.ManualTicketGenerator;

import java.util.*;

public class Lotto {
    private List<LottoNo> ticket;

    public Lotto() {
        this.ticket = AutoTicketGenerator.issue();
    }

    public Lotto(String s) {
        this.ticket = ManualTicketGenerator.issue(s);
    }

    public List<LottoNo> getTicket() {
        return ticket;
    }
}
