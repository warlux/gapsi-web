package mx.com.gapsi.example.mm.web.dto;

import java.util.List;

import mx.com.gapsi.examen.mm.generated.model.PageProveedor;
import mx.com.gapsi.examen.mm.generated.model.Proveedor;

public class TableDateProveedores {

	public int draw;
	public long recordsTotal;
	public long recordsFiltered;
	public List<Proveedor> data;

	public TableDateProveedores(PageProveedor pageProveedor, int draw) {
		this.recordsTotal = pageProveedor.getTotalElements();
		this.recordsFiltered = pageProveedor.getTotalElements();
		this.data = pageProveedor.getContent();
		this.draw = draw;
	}

	public long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List<Proveedor> getData() {
		return data;
	}

	public void setData(List<Proveedor> data) {
		this.data = data;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

}
