package com.tanmay.tickets.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTicketTypeRequest {

  private UUID id;
  private String name;
  private Double price;
  private String description;
  private Integer totalAvailable;
}
