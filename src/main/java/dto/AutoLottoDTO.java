package dto;

import model.LottoTicket;

import java.util.List;

public class AutoLottoDTO {
    int numberOfLottoTicket;
    List<LottoTicket> lottoTickets;

    public AutoLottoDTO(int numberOfLottoTicket, List<LottoTicket> lottoTickets) {
        this.numberOfLottoTicket = numberOfLottoTicket;
        this.lottoTickets = lottoTickets;
    }

    public int getNumberOfLottoTicket() {
        return numberOfLottoTicket;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
