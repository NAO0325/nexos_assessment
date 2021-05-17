/*
 * Nexos Software
 */
package com.credibanco.assessment.library.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Napoleon Avila Ochoa
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bookDto")
public class BookDto {

    @XmlElement(required = false)
    private Long id;

    @XmlElement(required = false)
    private String title;

    @XmlElement(required = false)
    private String editorial;

    @XmlElement(required = false)
    private String author;

    @XmlElement(required = false)
    private String gender;

    @XmlElement(required = false)
    private Integer year;
}
