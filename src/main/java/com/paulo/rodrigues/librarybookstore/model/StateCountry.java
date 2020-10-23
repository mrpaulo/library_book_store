/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paulo.rodrigues.librarybookstore.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author paulo.rodrigues
 */
@Entity
@Getter
@Setter
@Builder
public class StateCountry implements Serializable {
    @SequenceGenerator(name = "SEQ_STATE", allocationSize = 1, sequenceName = "state_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STATE")
    @Id
    private long id;
    @Column(length = 100)
    @NotNull
    private String name;
    
    @NotNull
    private Country country;
}
