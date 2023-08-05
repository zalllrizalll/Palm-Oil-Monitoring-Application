package aplikasi.monitoring.sawit.report;

import aplikasi.monitoring.sawit.setting.Koneksi;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Acer
 */
public class LaporanController {
    
    public void cetakPendapatanAction(Date awal, Date akhir) throws JRException {
        HashMap<String, Object> hash = new HashMap<>();
        hash.put("awal", awal);
        hash.put("akhir", akhir);
        
        InputStream file1 = getClass().getResourceAsStream("report_pendapatan.jasper");
        JasperPrint jp = JasperFillManager.fillReport(file1, hash, Koneksi.getConnection());
        JasperViewer.viewReport(jp, false);
    }
    public void cetakPengeluaranAction(Date awal, Date akhir) throws JRException {
        HashMap<String, Object> hash = new HashMap<>();
        hash.put("awal", awal);
        hash.put("akhir", akhir);
        
        InputStream file2 = getClass().getResourceAsStream("report_pengeluaran.jasper");
        JasperPrint jp = JasperFillManager.fillReport(file2, hash, Koneksi.getConnection());
        JasperViewer.viewReport(jp, false);
    }
}