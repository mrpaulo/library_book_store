/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paulo.rodrigues.librarybookstore.repository;

import com.paulo.rodrigues.librarybookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author paulo.rodrigues
 */
public interface AuthorRepository extends JpaRepository<Author, Long>{
    
}
