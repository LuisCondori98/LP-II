package com.proyecto.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyecto.interfaces.LibroInterface;
import com.proyecto.models.Inventario;
import com.proyecto.services.PdfService;

import jakarta.servlet.http.HttpSession;

@Controller
public class InventarioController {
	@Autowired
	private LibroInterface libroService;
	@Autowired
	private PdfService pdfService;
	
	@GetMapping("/inventario")
	public String mostrarInventario(Model model) {
		List<Inventario> lstInventario = libroService.listaInventario();
		model.addAttribute("libros", lstInventario);
		return "inventario";
	}
	
	@GetMapping("/pdf_inventario")
	public ResponseEntity<InputStreamResource>generarPDF(HttpSession sesion)throws IOException{
		List<Inventario> lstInventario = libroService.listaInventario();
		
		Map<String, Object> datosPdf = new HashMap<>();
	    datosPdf.put("libros", lstInventario);
	    
	    ByteArrayInputStream pdfBytes = pdfService.generarPdf("inventario_pdf", datosPdf);
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Disposition", "inline; filename=inventario.pdf");
	    
	    return ResponseEntity.ok()
	            .headers(headers)
	            .contentType(MediaType.APPLICATION_PDF)
	            .body(new InputStreamResource(pdfBytes));
	
	}
}
