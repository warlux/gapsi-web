package mx.com.gapsi.examen.mm.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.gapsi.examen.mm.generated.model.GapsiGenericResponseDto;
import mx.com.gapsi.examen.mm.generated.model.PageProveedor;
import mx.com.gapsi.examen.mm.generated.model.Proveedor;
import mx.com.gapsi.examen.mm.web.rest.feign.GapsiClient;

@Service
public class GapsiServiceImpl implements GapsiService{

	@Autowired
	GapsiClient gapsiClient;
	
	@Override
	public String getVersion() {
		return gapsiClient.getVersion().getBody();
	}
	
	@Override
	public String getBienvenidaCandidato() {
		return gapsiClient.getBienvenidaCandidato("01").getBody();
	}

	@Override
	public PageProveedor getProveedores(int page, int size) {
		return gapsiClient.getProveedores(page, size).getBody().getData();
	}

	@Override
	public void eliminarProveedor(long idProveedor) {
		gapsiClient.deleteProveedor(idProveedor);
		
	}

	@Override
	public GapsiGenericResponseDto agregarProveedor(Proveedor proveedor) {
		return gapsiClient.postProveedor(proveedor).getBody();
		
	}
}
