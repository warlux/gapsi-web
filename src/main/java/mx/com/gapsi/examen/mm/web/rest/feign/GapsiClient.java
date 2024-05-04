package mx.com.gapsi.examen.mm.web.rest.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import mx.com.gapsi.examen.mm.generated.model.GapsiGenericResponseDto;
import mx.com.gapsi.examen.mm.generated.model.GapsiProveedoresResponseDto;
import mx.com.gapsi.examen.mm.generated.model.Proveedor;


@FeignClient(name ="gapsi", url = "${gapsi.ws.url}")
public interface GapsiClient {

	@GetMapping("/gapsi/version")
	ResponseEntity<String> getVersion();
	
	@GetMapping("/candidato/{idCandidato}/bienvenida")
	ResponseEntity<String> getBienvenidaCandidato(@PathVariable String idCandidato);
	
    @GetMapping("/proveedores")
    ResponseEntity<GapsiProveedoresResponseDto> getProveedores(@RequestParam int page, @RequestParam int size);
    
    @PostMapping("/proveedores")
    ResponseEntity<GapsiGenericResponseDto> postProveedor(@RequestBody Proveedor proveedor);
    
	@DeleteMapping("/proveedores/{id}")
    public ResponseEntity<GapsiGenericResponseDto> deleteProveedor(@PathVariable Long id);
}
