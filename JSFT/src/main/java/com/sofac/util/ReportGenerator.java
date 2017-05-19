package com.sofac.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.pdf.PdfWriter;
import com.sofac.model.TiersInfo;
import com.sofac.services.TieidenService;
import com.sofac.services.TiersService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

public class ReportGenerator {

	public void rapportAntecedent(List<TiersInfo> tiersInfos, String code, String nom, String rc, String cin,
			String cinN, String user) throws JRException, ParseException, IOException {
		if (tiersInfos.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerte",
					"Veuiller effectuer une recherche d'abord "));
		} else {
			TieidenService tieidenService = new TieidenService();
			TiersService tiersService = new TiersService();
			ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
					.getContext();
			JasperReport jasperReport = JasperCompileManager
					.compileReport(servletContext.getRealPath("/WEB-INF/resources/jrxml/Antecedent.jrxml"));
			ArrayList<Antecedent> list = new ArrayList<>();
			for (int i = 0; i < tiersInfos.size(); i++) {
				String CIN = null;
				if (tieidenService.getCIN(tiersInfos.get(i).getTieidens()) != null)
					CIN = tieidenService.getCIN(tiersInfos.get(i).getTieidens()).getNoPieceIden();
				String prenom = tiersInfos.get(i).getTiers().getPrenom();
				if(prenom == null)
					prenom = "";
				list.add(new Antecedent(tiersInfos.get(i).getTiers().getTiers(),
						tiersInfos.get(i).getTiers().getNom() + " " + prenom,
						tiersInfos.get(i).getTiers().getNoRc(), CIN,
						tiersService.getDateFromJulian(tiersInfos.get(i).getTiers().getDateNaissance())));
			}
			JRBeanCollectionDataSource items = new JRBeanCollectionDataSource(list);
			HashMap<String, Object> parameters = new HashMap<String, Object>();
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("List", items);
			if (code != null)
				parameters.put("code", code);
			if (nom != null)
				parameters.put("nom", nom);
			if (rc != null)
				parameters.put("rc", rc);
			if (cin != null) {
				if (cin.length() == 1)
					cin += " ";
				if (cinN != null)
					cin = cin + "-" + cinN;
				parameters.put("cin", cin);
			}
			parameters.put("user", user);
			parameters.put("dir", servletContext.getRealPath("/"));
			ArrayList<HashMap<String, Object>> listParam = new ArrayList<HashMap<String, Object>>();
			listParam.add(parameters);
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(listParam);
			JasperPrint print = JasperFillManager.fillReport(jasperReport, param, beanColDataSource);
			publishReport(print, "Recherche" + new Date());
		}
	}

	private void publishReport(JasperPrint print, String filename) throws IOException, JRException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		JRPdfExporter exporterPDF = new JRPdfExporter();
		exporterPDF.setExporterInput(new SimpleExporterInput(print));
		exporterPDF.setExporterOutput(new SimpleOutputStreamExporterOutput(out));
		SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
		configuration.setPermissions(PdfWriter.ALLOW_COPY | PdfWriter.ALLOW_PRINTING);
		exporterPDF.setConfiguration(configuration);
		exporterPDF.exportReport();

		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

		response.reset();
		response.setContentType("application/pdf"); // Check http://www.iana.org/assignments/media-types for all types. Use if necessary ServletContext#getMimeType() for auto-detection based on filename.
		response.setHeader("Content-disposition", "inline; filename=\"" + filename + ".pdf\"");

		ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());

		BufferedInputStream input = null;
		BufferedOutputStream output = null;

		try {
			input = new BufferedInputStream(in);
			output = new BufferedOutputStream(response.getOutputStream());

			byte[] buffer = new byte[10240];
			for (int length; (length = input.read(buffer)) > 0;) {
				output.write(buffer, 0, length);
			}
		} finally {
			output.close();
			input.close();
		}

		facesContext.responseComplete();

	}
}
