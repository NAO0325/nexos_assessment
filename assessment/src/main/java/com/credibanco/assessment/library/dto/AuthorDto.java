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
@XmlType(name = "authorDto")
public class AuthorDto {

    @XmlElement(required = false)
    private Long id;

    @XmlElement(required = false)
    private String name;

    @XmlElement(required = false)
    private String birth;

    @XmlElement(required = false)
    private String city;

    @XmlElement(required = false)
    private String email;
}
