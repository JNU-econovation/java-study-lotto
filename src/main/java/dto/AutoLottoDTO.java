package dto;

import model.LottoTicket;

import java.util.List;

public class AutoLottoDTO {
    List<LottoTicket> lottoTickets;

    public AutoLottoDTO(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int getNumberOfLottoTicket() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
