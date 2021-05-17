/*
 * Nexos Software
 */
package com.credibanco.assessment.library.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "LIB_EDITORIAL_TB")

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Editorial implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EDITORIAL_SEQ")
    @SequenceGenerator(sequenceName = "LIB_EDITORIAL_SQ", allocationSize = 1, name = "EDITORIAL_SEQ")
    @Column(name = "EDITORIAL_ID")
    private Long id;

    @NotNull
    @Size(max = 150)
    @Column(name = "EDITORIAL_NAME")
    private String editorialName;

    @NotNull
    @Size(max = 120)
    @Column(name = "CORRESPONDENCE_ADDRESS")
    private String correspondenceAddress;

    @NotNull
    @Size(max = 60)
    @Column(name = "PHONE_NUMBER")
    private String phoneNumer;

    @NotNull
    @Column(name = "MAXIMUN_BOOKS_REGISTERED")
    private Long maximiunBooksRegistered;

    @NotNull
    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @NotNull
    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;

    @OneToMany(mappedBy = "editorial")
    private Collection<Book> books;

    @Override
    public String toString() {
        return "com.credibanco.assessment.library.model.Editorial[ id=" + id + " ]";
    }
}
