/*
 * Copyright (C) 2021 paulo.rodrigues
 * Profile: <https://github.com/mrpaulo>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.paulo.rodrigues.librarybookstore.repository;

import com.paulo.rodrigues.librarybookstore.model.Company;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author paulo.rodrigues
 */
public interface CompanyRepository extends JpaRepository<Company, Long>{
    
    public Company findByCnpj (String cnpj);
    
    @Query("SELECT c "
            + " FROM Company c "
            + " WHERE (:name IS NULL OR :name = '' OR c.name LIKE CONCAT('%',:name,'%')) "
            + "")
    public List<Company> findByName (@Param("name") String name);

    @Query("SELECT c "
            + " FROM Company c "
            + " WHERE (:id IS NULL OR c.id = :id) "
            + " AND (:name IS NULL OR :name = '' OR c.name LIKE CONCAT('%',:name,'%')) "
            + " AND (:cnpj IS NULL OR :cnpj = '' OR c.cnpj LIKE CONCAT('%',:cnpj,'%')) "
//            + " AND ((:startDate IS NULL AND :finalDate IS NULL) OR (c.createDate BETWEEN :startDate AND :finalDate)) "
            + " AND ((coalesce(:startDate, null) is null AND coalesce(:finalDate, null) is null) OR (c.createDate BETWEEN :startDate AND :finalDate)) "
            + "")
    public Page<Company> findPageble(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("cnpj") String cnpj,                        
            @Param("startDate") Date startDate,
            @Param("finalDate") Date finalDate,
            Pageable page);
    
}
