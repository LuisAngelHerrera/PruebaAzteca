$(document).ready(function(){
	cargaDataTable();
});

var dataTable;

function cargaDataTable(){
	console.log("admin");
	dataTable = $('#tablaClientes').DataTable({
		"ajax": {
			"type": "GET",
			"datatype": "json",
			"url": "/clientes/api/listadoClientes"
		},
		"columns": [{
			"data": "id",
			"width": "5%"
		},{
			"data": "nombre",
			"width": "15%"
		},{
			"data": "fechaNacimiento",
			"width": "15%"
		},{
			"data": "celular",
			"width": "15%"
		},{
			"data": "edad",
			"width": "5%"
		},{
			"data": "correo",
			"width": "15%"
		},{
			"data": "id",
			"width": "30%",
			"render": function(data){
				return `<div class="text-center"><a class="btn btn-primary" 
                href="/clientes/edit/${data}">Editar</a>&nbsp; 
                <a class="btn btn-danger text=white" style="cursor:pointer;" 
                onclick="Delete('/clientes/api/delete/${data}')">Eliminar</a>
                </div>`
			}
		}],
		"lenguage": {
			"decimal": "No hay informacion",
			"info": "Mostrando_START_a_END_de_TOTAL_Entradas",
			"infoEmpty": "Mostrando 0 to 0 of 0 Entradas",
			"infoFiltered": "(Filtrado de _MAX_ total entradas)",
			"infoPostFix":"",
			"thousands": ",",
			"lengthMenu": "Mostrar _MENU_ Entradas",
			"loadingRecods": "Cargando...",
			"processing": "Procesando...",
			"search":"Buscar:",
			"zeroRecords": "sin resultados encontrados",
			"paginate": {
				"first": "Primero",
				"last": "Ultimo",
				"next": "Siguiente",
				"previous": "Anterior"
			}
		}
	});
}

const fechaNacimiento = document.getElementById("fechaNacimiento")
const edad= document.getElementById("edad");

windows.addEventListener("load", function(){
	
	fechaNacimiento.addEventListener("change", function(){
		console.log(this.value);
	});
	
});


function Delete(url){
	swal({
		title: "Esta seguro de borrar?",
		text: "Este contenido no se puede recuperar",
		type: "warning",
		showCancelButton: true,
		confirmButtonColor: "#DD6B55",
		confirmButtonText: "Si, borrar!",
		closeOnconfirm: true
	}, function(){
		$.ajax({
			type: 'DELETE',
			url: url, //'categorias/api/delete/'
			success: function(response){
				if(response.success == "true"){
					toastr.success(response.message);
					dataTable.ajax.reload();
				}else{
					toastr.error(data.message);
				}
			}
		});
	});
}