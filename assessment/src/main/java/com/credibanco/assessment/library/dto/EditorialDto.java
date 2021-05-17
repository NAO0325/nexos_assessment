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
@XmlType(name = "editorialDto")
public class EditorialDto {

    @XmlElement(required = false)
    private Long id;

    @XmlElement(required = false)
    private String name;

    @XmlElement(required = false)
    private String adress;

    @XmlElement(required = false)
    private String phone;

    @XmlElement(required = false)
    private Long maximumBooks;

    @XmlElement(required = false)
    private String email;
}
