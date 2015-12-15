/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaqpack_app;

import java.io.File;
import java.io.IOException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 *
 * @author MQ0162246
 */
public class PdfCombine {

    // Using the pdftk utilitiy
    public static void combinePDFFiles(File currentNode) throws IOException {
        //combine all pdfs for this directory & append to file in output directory
        System.out.println("IN Combine PDF Processing: " + currentNode.getCanonicalPath());
        //Merge PDF files
        try {

            //Runtime.getRuntime().exec("pdftk.exe *.pdf cat output allinone.pdf");
            //Runtime.getRuntime().exec("C:/Program Files (x86)/PDFtk Server/bin/pdftk.exe *.pdf cat output allinone.pdf");
            String program = "C:\\Program Files (x86)\\PDFtk Server\\bin\\pdftk.exe";

            String filestocombine = currentNode.getParent() + "\\" + currentNode.getName() + File.separatorChar + "*.pdf";
            String finalfile = currentNode.getParent() + "\\" + currentNode.getName() + File.separatorChar + "allinone.pdf";
            String cmd1 = " " + filestocombine + " cat output " + finalfile;
            System.out.println("Command to be run is:  " + program + cmd1);

            Runtime.getRuntime().exec(program + cmd1);

            // pick up the all in one file and send it to the output directrory!!!
            //Runtime.getRuntime().exec(cmd1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Using the pdftk utilitiy

    public static void combinePDFFiles(List<String> list, String outName) throws DocumentException, IOException 
    {
        OutputStream out=null;
        Document document=null;
        PdfWriter writer =null;
        FileInputStream in=null;
        try {
            // Resulting pdf
             out = new FileOutputStream(new File(outName));
             document = new Document();
             writer = PdfWriter.getInstance(document, out);
            document.open();
            PdfContentByte cb = writer.getDirectContent();
            for (String inFile : list) {
                in = new FileInputStream(new File(inFile));
                PdfReader reader = new PdfReader(in);
                for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                    document.newPage();
                    //import the page from source pdf
                    PdfImportedPage page = writer.getImportedPage(reader, i);
                    //add the page to the destination pdf
                    cb.addTemplate(page, 0, 0);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            out.flush();
            document.close();
            out.close();
            in.close();
        }

    }
}
