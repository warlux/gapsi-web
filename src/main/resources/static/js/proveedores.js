$(document).ready(function() {
	$("#modalDelete").modal();
	$("#modalAgregar").modal();
});

new DataTable('#tblProveedores', {
	ajax: 'async/proveedoresData',
	//scrollCollapse: true,
    scroller: true,
    scrollY: 200,
    //deferRender:    true,
	columns: [
		{ data: 'id', "class": "idProveedor" },
		{ data: 'nombre' },
		{ data: 'razonSocial' },
		{ data: 'direccion' },
		{ "data": null, "defaultContent": "<button class='btn btn-sm btn-danger eliminarProveedor'>Eliminar <i class='fa-regular fa-trash-can'></i></button>", "class": "text-end" },
	],
	processing: true,
	serverSide: true,
	ordering: false,
	//responsive: true,
	searching: false,
	"oLanguage": {
		"sEmptyTable": "No se han encontrado proveedores en este momento...",
		"sInfo": "Mostrando _START_ a _END_ de _TOTAL_ registros",
		"sLengthMenu": "Mostrar _MENU_ registros",
	}
});


$("#tblProveedores tbody").on("click", ".eliminarProveedor", function() {
	var id = $(this).parent().parent().find($('.idProveedor')).text();
	$('#idProveedorEliminar').val(id);
	$('#modalDelete').modal('show')
});