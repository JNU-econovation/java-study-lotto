package dto;

import model.LottoNo;

import java.util.List;

public class LottoDTO {
    private List<LottoNo> ticket;

    public LottoDTO(List<LottoNo> ticket) {
        this.ticket = ticket;
    }

    public List<LottoNo> getTicket() {
        return ticket;
    }
}