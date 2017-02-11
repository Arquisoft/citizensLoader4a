package es.uniovi.asw.parser;


import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.reportWritter.GenerateLogText;
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

            StringBuilder logger = new StringBuilder();

            try {
                wb = new XSSFWorkbook(new File(path));
                sheet = wb.getSheetAt(0);
                rowIterator = sheet.iterator();

                rowIterator.next();

                int actualrow = 0;
                while (rowIterator.hasNext()) {
                    actualrow++;
                    row = rowIterator.next();
                    name = row.getCell(0) != null ? row.getCell(0).getStringCellValue() : null;
                    nameResult = Comprobador.esTodoTexto(name);
                    surname = row.getCell(1) != null ? row.getCell(1).getStringCellValue() : null;
                    surnameResult = Comprobador.esTodoTexto(surname);
                    email = row.getCell(2) != null ? row.getCell(2).getStringCellValue() : null;
                    emailResult = Comprobador.esEmailCorrecto(email);
                    // birthResult =
                    // Comprobador.fechaCorrecta(row.getCell(3).getStringCellValue());
                    // // Orden
                    // importante
                    birthResult = true;
                    birth = row.getCell(3) != null && birthResult ? row.getCell(3).getDateCellValue() : null;
                    address = row.getCell(4) != null ? row.getCell(4).getStringCellValue() : null;
                    // addressResult = Comprobador.esTodoTexto(address);
                    addressResult = true;
                    nationality = row.getCell(5) != null ? row.getCell(5).getStringCellValue() : null;
                    nationalityResult = Comprobador.esTodoTexto(nationality);
                    nif = row.getCell(6) != null ? row.getCell(6).getStringCellValue() : null;
                    nifResult = nif != null ? true : false;

                    // Se carga mas info al logger.
                    boolean todoOK = GenerateLogText.completeTextForLog(logger, nameResult, surnameResult, emailResult,
                            birthResult, addressResult, nationalityResult, nifResult, actualrow);

                    if (todoOK) {
                        ciudadanos.add(anadirCitizen(name, surname, email, birth, address, nationality, nif));
                    }
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

