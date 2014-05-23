package readexcelfile;

import java.io.*;
import jxl.*;

/**
 * @author racorrea
 */
public class ReadExcelFile {

    public static String file = "/Users/utpl/Desktop/excel-files/CPV2010_Poblacion_Provincia_Loja_Muestra30.xls";
    
    private void leerArchivoExcel(String archivoDestino) {

        try {
            Workbook archivoExcel = Workbook.getWorkbook(new File(archivoDestino));
            System.out.println("Número de Hojas = "+ archivoExcel.getNumberOfSheets());
            for (int sheetNo = 0; sheetNo < archivoExcel.getNumberOfSheets(); sheetNo++){
                Sheet hoja = archivoExcel.getSheet(sheetNo);
                int numColumnas = hoja.getColumns();
                int numFilas = hoja.getRows();
                String data;
                System.out.println("Nombre de la Hoja = " + archivoExcel.getSheet(sheetNo).getName());
                for (int fila = 0; fila < numFilas; fila++) {
                    for (int columna = 0; columna < numColumnas; columna++) {                                                                             
                        data = hoja.getCell(columna, fila).getContents();
                        System.out.print(data + " ");
                    }
                    System.out.println("\n");
                }
            }
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }

    }
    public static void main(String[] args) {
        ReadExcelFile excel = new ReadExcelFile(); 
        excel.leerArchivoExcel(file); 
    }
}
