/*
 * Nexos Software
 */
package com.credibanco.assessment.library.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Napoleon Avila Ochoa
 */
@Entity
@Table(name = "LIB_BOOK_TB")

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Book implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_SEQ")
    @SequenceGenerator(sequenceName = "LIB_BOOK_SQ", allocationSize = 1, name = "BOOK_SEQ")
    @Column(name = "BOOK_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "EDITORIAL_ID", nullable = false)
    private Editorial editorial;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID", nullable = false)
    private Author author;

    @NotNull
    @Size(max = 200)
    @Column(name = "TITLE")
    private String title;

    @NotNull
    @Size(max = 50)
    @Column(name = "GENDER")
    private String gender;

    @Column(name = "YEAR")
    private Integer year;

    @NotNull
    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @NotNull
    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Override
    public String toString() {
        return "com.credibanco.assessment.library.model.Author[ id=" + id + " ]";
    }

}
