package mx.com.gapsi.examen.mm.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.com.gapsi.examen.mm.generated.model.GapsiGenericResponseDto;
import mx.com.gapsi.examen.mm.generated.model.PageProveedor;
import mx.com.gapsi.examen.mm.generated.model.Proveedor;
import mx.com.gapsi.examen.mm.web.service.GapsiService;
import mx.com.gapsi.example.mm.web.dto.TableDateProveedores;


@Controller
public class GapsiController {

	private static final Logger LOG = LoggerFactory.getLogger(GapsiController.class);
	
	@Autowired
	GapsiService gapsiService;
	
	@GetMapping("/check")
	public @ResponseBody boolean check() {
		LOG.info("Check!");
		return true;
	}
	
	@GetMapping("/")
	public String getWelcome(Model model) {
		model.addAttribute("version", gapsiService.getVersion());
		model.addAttribute("bienvenida", gapsiService.getBienvenidaCandidato());
		return "welcome";
	}
	
	@GetMapping("/proveedores")
	public String getProveedores(Model model, Proveedor proveedor) {
		return "proveedores";
	}
	
	@PostMapping("/eliminarProveedor")
	public String deleteProveedores(@RequestParam int idProveedor) {
		gapsiService.eliminarProveedor(idProveedor);
		return "redirect:proveedores";
	}
	
	@PostMapping("/agregarProveedor")
	public String agregarProveedores(Proveedor proveedor, RedirectAttributes redirectAttributes) {
		GapsiGenericResponseDto response = gapsiService.agregarProveedor(proveedor);
		if(response.getError() != null) {
			redirectAttributes.addFlashAttribute("error", response.getError());
		} else {
			redirectAttributes.addFlashAttribute("info", "Se agregó exitosamente un proveedor");
		}
		return "redirect:proveedores";
	}
	
	@GetMapping("/async/proveedoresData")
	@ResponseBody
	public TableDateProveedores getProveedoresData(@RequestParam int length, @RequestParam int draw, @RequestParam int start) {
		PageProveedor pageProveedor = gapsiService.getProveedores(start/length, length);
		TableDateProveedores response = new TableDateProveedores(pageProveedor, draw);
		return response;
	}
}
