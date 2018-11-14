package dto;

import model.LottoTicket;

import java.util.List;

public class LottoGameDTO {
    private int numberOfManualLottoTicket;
    private int ticketPrice;
    private List<LottoTicket> lottoTickets;

    public LottoGameDTO(int ticketPrice, int numberOfManualLottoTicket, List<LottoTicket> lottoTickets) {
        this.ticketPrice = ticketPrice;
        this.numberOfManualLottoTicket = numberOfManualLottoTicket;
        this.lottoTickets = lottoTickets;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getNumberOfManualLottoTicket() {
        return numberOfManualLottoTicket;
    }

    public void setNumberOfManualLottoTicket(int numberOfManualLottoTicket) {
        this.numberOfManualLottoTicket = numberOfManualLottoTicket;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public void setLottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }
}
