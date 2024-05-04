package mx.com.gapsi.examen.mm.web.service;

import mx.com.gapsi.examen.mm.generated.model.GapsiGenericResponseDto;
import mx.com.gapsi.examen.mm.generated.model.PageProveedor;
import mx.com.gapsi.examen.mm.generated.model.Proveedor;

public interface GapsiService {

	String getVersion();
	
	String getBienvenidaCandidato();
	
	PageProveedor getProveedores(int page, int size);
	
	void eliminarProveedor(long idProveedor);
	
	GapsiGenericResponseDto agregarProveedor(Proveedor proveedor);
}
