package com.banking.ms_logistics.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("collectors")
public class Collector {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String documentNumber;
    private String status;
}
