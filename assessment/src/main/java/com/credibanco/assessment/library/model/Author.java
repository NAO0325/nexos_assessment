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
@Table(name = "LIB_AUTHOR_TB")

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Author implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTHOR_SEQ")
    @SequenceGenerator(sequenceName = "LIB_AUTHOR_SQ", allocationSize = 1, name = "AUTHOR_SEQ")
    @Column(name = "AUTHOR_ID")
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "AUTHOR_NAME")
    private String authorName;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Size(max = 50)
    @Column(name = "CITY_OF_ORIGIN")
    private String cityOfOrigin;

    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;

    @NotNull
    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @NotNull
    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    @OneToMany(mappedBy = "author")
    private Collection<Book> books;

    @Override
    public String toString() {
        return "com.credibanco.assessment.library.model.Author[ id=" + id + " ]";
    }

}
