package es.uniovi.asw.parser;


import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.reportwritter.GenerateLogText;
import es.uniovi.asw.util.Comprobador;
import es.uniovi.asw.util.Console;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RListExcel extends RList  implements ReadList{

    @Override
    public List<Citizen> readFile(String path) {

            XSSFWorkbook wb;
            XSSFSheet sheet;
            Iterator<Row> rowIterator;
            Row row = null;
            List<Citizen> ciudadanos = new ArrayList<Citizen>();

            String name, surname, email;
            Date birth;
            String address;
            String nationality;
            String nif;

            boolean nameResult, surnameResult, emailResult, birthResult, addressResult, nationalityResult, nifResult;
            int colNombre = 0, colApellido = 0,colEmail = 0, colBirth = 0, colAddress = 0, colNacionalidad = 0, colNif = 0;
            StringBuilder logger = new StringBuilder();

            try {
                wb = new XSSFWorkbook(new File(path));
                sheet = wb.getSheetAt(0);
                rowIterator = sheet.iterator();
                int columna=0;
                row=rowIterator.next();
                while (columna<7){
                	String celda=row.getCell(columna).getStringCellValue();
                	if(celda.startsWith("No"))
                		colNombre=columna;
                	else if(celda.startsWith("Ap"))
                		colApellido=columna;
                	else if(celda.startsWith("Cor")||celda.startsWith("Em"))
                		colEmail=columna;
                	else if(celda.startsWith("Fec"))
                		colBirth=columna;
                	else if(celda.startsWith("Dir"))
                		colAddress=columna;
                	else if(celda.startsWith("Nac"))
                		colNacionalidad=columna;
                	else if(celda.startsWith("DNI")||celda.startsWith("NIF"))
                		colNif=columna;
                	columna++;
                }

                int actualrow = 0;
                while (rowIterator.hasNext()) {
                    actualrow++;
                    row = rowIterator.next();
                    name = row.getCell(colNombre) != null ? row.getCell(colNombre).getStringCellValue() : null;
                    nameResult = Comprobador.esTodoTexto(name);
                    surname = row.getCell(colApellido) != null ? row.getCell(colApellido).getStringCellValue() : null;
                    surnameResult = Comprobador.esTodoTexto(surname);
                    email = row.getCell(colEmail) != null ? row.getCell(colEmail).getStringCellValue() : null;
                    emailResult = Comprobador.esEmailCorrecto(email);
                    // birthResult =
                    // Comprobador.fechaCorrecta(row.getCell(3).getStringCellValue());
                    // // Orden
                    // importante
                    birthResult = true;
                    birth = row.getCell(colBirth) != null && birthResult ? row.getCell(colBirth).getDateCellValue() : null;
                    address = row.getCell(colAddress) != null ? row.getCell(colAddress).getStringCellValue() : null;
                    addressResult = Comprobador.esAddressCorrecto(address);
                    addressResult = true;
                    nationality = row.getCell(colNacionalidad) != null ? row.getCell(colNacionalidad).getStringCellValue() : null;
                    nationalityResult = Comprobador.esTodoTexto(nationality);
                    nif = row.getCell(colNif) != null ? row.getCell(colNif).getStringCellValue() : null;
                    nifResult = nif != null ? true : false;

                  ciudadanos.add(anadirCitizen(name, surname, email, birth, address, nationality, nif));

                }

            } catch (InvalidFormatException e) {
                Console.print("El fichero no es un .xlsx");
            } catch (Exception e) {
                String[] fileName = path.split("/");
                Console.print("El fichero " + fileName[fileName.length - 1] + " no existe");
            }
/*
            // Crear el fichero log
            String[] cachos = path.split("/");
            String nombreFich1 = cachos[cachos.length - 1];
            String nombreFich = nombreFich1.replace(".xlsx", "");

            WreportP reporter = new WreportP(nombreFich, logger.toString());
            reporter.createErrorLogFile();
            //*/
            return ciudadanos;
        }


}

