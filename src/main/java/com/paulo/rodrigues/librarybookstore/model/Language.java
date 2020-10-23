/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paulo.rodrigues.librarybookstore.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 *
 * @author paulo.rodrigues
 */
public class Language {
    @SequenceGenerator(name = "SEQ_LANGUAGE", allocationSize = 1, sequenceName = "language_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LANGUAGE")
    @Id
    private long id;
    
    @Column(length = 100)
    @NotNull
    private String name;
}
