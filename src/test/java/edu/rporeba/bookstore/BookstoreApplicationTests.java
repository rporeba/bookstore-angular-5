package edu.rporeba.bookstore;

import edu.rporeba.bookstore.model.Book;
import edu.rporeba.bookstore.model.DataBean;
import edu.rporeba.bookstore.repository.BookRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsExporterConfiguration;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class BookstoreApplicationTests {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testPDF() {

        try {

            JasperReport jasperReport = JasperCompileManager.compileReport("src/test/java/resources/books.jrxml");

            Map<String, Object> parameters = new HashMap<>();
            parameters.put(JRParameter.REPORT_LOCALE, Locale.US);

            InputStream reportStream = new FileInputStream("src/test/java/resources/books.jrxml");
            Collection<Book> data = bookRepository.findAll();
            JRDataSource dataSource = new JRBeanCollectionDataSource(data, true);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "src/test/java/resources/books.pdf");
            JasperReport report = JasperCompileManager.compileReport(reportStream);

            JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);
            JasperPrintManager.printReport(print, true);

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (JRException e) {

            e.printStackTrace();

        }

    }

    @Test
    public void testXLS() {

        try {

            JasperReport inXlsFileName = JasperCompileManager.compileReport("src/test/java/resources/books.jrxml");
            String outXlsName = "src/test/java/resources/books.xls";

            Map<String, Object> xlsParams = new HashMap<>();
            Collection<Book> data = bookRepository.findAll();
            JRDataSource dataSource = new JRBeanCollectionDataSource(data, true);

            JasperPrint xlsPrint = JasperFillManager.fillReport(inXlsFileName, xlsParams, dataSource);
            JRXlsExporter xlsExporter = new JRXlsExporter();

            xlsExporter.setExporterInput(new SimpleExporterInput(xlsPrint));
            xlsExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outXlsName));

            SimpleXlsReportConfiguration xlsReportConfiguration = new SimpleXlsReportConfiguration();
            xlsReportConfiguration.setOnePagePerSheet(false);
            xlsReportConfiguration.setRemoveEmptySpaceBetweenRows(true);
            xlsReportConfiguration.setDetectCellType(false);
            xlsReportConfiguration.setWhitePageBackground(false);
            xlsExporter.setConfiguration(xlsReportConfiguration);
            xlsExporter.exportReport();

        } catch (JRException e) {

            e.printStackTrace();

        }

    }

    @Test
    public void testXLS2() {

        try {

            JasperReport inXlsFileName = JasperCompileManager.compileReport("src/test/java/resources/books2.jrxml");
            String outXlsName = "src/test/java/resources/books2.xls";

            Map<String, Object> xlsParams = new HashMap<>();

            Collection<Book> data = bookRepository.findAll();
            JRDataSource dataSource = new JRBeanCollectionDataSource(data, true);
            JasperPrint xlsPrint = JasperFillManager.fillReport(inXlsFileName, xlsParams, dataSource);
            JRXlsExporter xlsExporter = new JRXlsExporter();

            xlsExporter.setExporterInput(new SimpleExporterInput(xlsPrint));
            xlsExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outXlsName));
            SimpleXlsReportConfiguration xlsReportConfiguration = new SimpleXlsReportConfiguration();
            SimpleXlsExporterConfiguration xlsExporterConfiguration = new SimpleXlsExporterConfiguration();
            xlsReportConfiguration.setOnePagePerSheet(false);
            xlsReportConfiguration.setRemoveEmptySpaceBetweenRows(true);
            xlsReportConfiguration.setDetectCellType(true);
            xlsReportConfiguration.setWhitePageBackground(false);
            xlsExporter.setConfiguration(xlsReportConfiguration);

            xlsExporter.exportReport();

        } catch (JRException e) {

            e.printStackTrace();
        }
    }

    @Test
    public void testCrossTabs() {

        try {

            JasperReport jasperReport = JasperCompileManager.compileReport("src/test/java/resources/crosstabs.jrxml");
            ArrayList<DataBean> dataList = getDataBeanList();
            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put(JRParameter.REPORT_LOCALE, Locale.US);
            parameters.put("ReportTitle", "List of Contacts");
            parameters.put("Author", "Prepared by XXX");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "src/test/java/resources/crosstabs.pdf");

            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
            JasperPrintManager.printReport(print, true);

        } catch (JRException e) {

            e.printStackTrace();
        }
    }

    public ArrayList<DataBean> getDataBeanList() {

        ArrayList<DataBean> dataBeanList = new ArrayList<>();
        dataBeanList.add(produce("Kowalski", "Krakow"));
        dataBeanList.add(produce("Nowak", "Warszawa"));
        dataBeanList.add(produce("Kochanowski", "Wrocław"));
        dataBeanList.add(produce("Smoleń", "Opole"));

        return dataBeanList;

    }

    private DataBean produce(String name, String country) {

        DataBean dataBean = new DataBean();
        dataBean.setName(name);
        dataBean.setCountry(country);

        return dataBean;
    }

    @Test
    public void testCharts() {

        try {

            JasperReport jasperReport = JasperCompileManager.compileReport("src/test/java/resources/charts.jrxml");
            ArrayList<DataBean> dataList = getDataBeanList2();

            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
            Map<String, Object> parameters = new HashMap<>();

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "src/test/java/resources/charts.pdf");
            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
            JasperPrintManager.printReport(print, true);

        } catch (JRException e) {

            e.printStackTrace();
        }
    }

    public ArrayList<DataBean> getDataBeanList2() {

        ArrayList<DataBean> dataBeanList = new ArrayList<>();

        dataBeanList.add(produce("English", 58));
        dataBeanList.add(produce("SocialStudies", 68));
        dataBeanList.add(produce("Maths", 38));
        dataBeanList.add(produce("IT", 88));
        dataBeanList.add(produce("Scince", 78));

        return dataBeanList;

    }

    private DataBean produce(String subjectName, Integer marks) {

        DataBean dataBean = new DataBean();
        dataBean.setSubjectName(subjectName);
        dataBean.setMarks(marks);

        return dataBean;
    }

}




