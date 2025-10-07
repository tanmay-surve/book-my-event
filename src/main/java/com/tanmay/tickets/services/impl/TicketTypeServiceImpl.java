package com.tanmay.tickets.services.impl;

import com.tanmay.tickets.domain.entities.Ticket;
import com.tanmay.tickets.domain.entities.TicketStatusEnum;
import com.tanmay.tickets.domain.entities.TicketType;
import com.tanmay.tickets.domain.entities.User;
import com.tanmay.tickets.exceptions.TicketTypeNotFoundException;
import com.tanmay.tickets.exceptions.TicketsSoldOutException;
import com.tanmay.tickets.exceptions.UserNotFoundException;
import com.tanmay.tickets.repositories.TicketRepository;
import com.tanmay.tickets.repositories.TicketTypeRepository;
import com.tanmay.tickets.repositories.UserRepository;
import com.tanmay.tickets.services.QrCodeService;
import com.tanmay.tickets.services.TicketTypeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketTypeServiceImpl implements TicketTypeService {

  private final UserRepository userRepository;
  private final TicketTypeRepository ticketTypeRepository;
  private final TicketRepository ticketRepository;
  private final QrCodeService qrCodeService;

  @Override
  @Transactional
  public Ticket purchaseTicket(UUID userId, UUID ticketTypeId) {
    User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(
        String.format("User with ID %s was not found", userId)
    ));

    TicketType ticketType = ticketTypeRepository.findByIdWithLock(ticketTypeId)
        .orElseThrow(() -> new TicketTypeNotFoundException(
            String.format("Ticket type with ID %s was not found", ticketTypeId)
        ));

    int purchasedTickets = ticketRepository.countByTicketTypeId(ticketType.getId());
    Integer totalAvailable = ticketType.getTotalAvailable();

    if(purchasedTickets + 1 > totalAvailable) {
      throw new TicketsSoldOutException();
    }

    Ticket ticket = new Ticket();
    ticket.setStatus(TicketStatusEnum.PURCHASED);
    ticket.setTicketType(ticketType);
    ticket.setPurchaser(user);

    Ticket savedTicket = ticketRepository.save(ticket);
    qrCodeService.generateQrCode(savedTicket);

    return ticketRepository.save(savedTicket);
  }
}
