/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.tokencrypt.web.constants;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author julian.ortiz
 */
public class Constantes {
    public static final String FORMATO_FECHA_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String FORMATO_FECHA_DD_MM_YYYY = "dd/MM/yyyy";
    public static final String FORMATO_FECHA_HORA_DD_MM_YYYY_HH_MM_SS = "dd-MM-yyyy HH:mm:ss";
    public static final LocalDate FECHA_DEFECTO = LocalDate.of(0001, 01, 01);
    public static final LocalDateTime FECHA_HORA_DEFECTO = LocalDateTime.parse(LocalDate.parse("01/01/0001", DateTimeFormatter.ofPattern(FORMATO_FECHA_DD_MM_YYYY)) + " 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    public static final String HEADER_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

}
