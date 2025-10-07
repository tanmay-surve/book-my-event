package com.tanmay.tickets.domain.dtos;

import com.devtiro.tickets.domain.entities.TicketValidationStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketValidationResponseDto {
  private UUID ticketId;
  private TicketValidationStatusEnum status;
}
