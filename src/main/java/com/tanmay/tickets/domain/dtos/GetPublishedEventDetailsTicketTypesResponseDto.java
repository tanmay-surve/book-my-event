package com.tanmay.tickets.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPublishedEventDetailsTicketTypesResponseDto {

  private UUID id;
  private String name;
  private Double price;
  private String description;
}
