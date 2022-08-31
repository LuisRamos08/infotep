function listCursos(){
    var xhr = new XMLHttpRequest();
    var url = 'http://localhost:8080/cursos';
    xhr.open("GET", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.setRequestHeader('X-PINGOTHER', 'pingpong');
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var json = JSON.parse(xhr.responseText);
            if(json != null){
                data = json;
                var div = document.getElementById("tblcursos");
                var tabla = '<table id="example" class="table table-striped table-bordered" style="background-color:white;">'
                    + '<thead class="bg-primary" style="color:white;">'
                    + '<tr><th>Codigo</th><th>Nombre</th><th>Fecha Inicio</th><th>Fecha Termino</th><th>Horas</th><th>Empresa</th><th>Asesor</th><th>Facilitador</th>'
                    + '</tr></thead><tbody>';
                data.forEach(e => tabla+="<tr><td><a href='#' onclick='showCurso("+e.idCurso+")'>"+e.codigo +"</a></td>"
                    +"<td>"+ e.nombre+"</td>"
                    +"<td>"+ e.fechaInicio+"</td>"
                    +"<td>"+ e.fechaTermino+"</td>"
                    +"<td>"+ e.horas+"</td>"
                    +"<td>"+ e.empresa.nombre+"</td>"
                    +"<td>"+ e.asesor.nombre+"</td>"
                    +"<td>"+ e.facilitador.nombre+"</td>"+ "</tr>"
                );
                tabla += "</tbody></table>";
                div.innerHTML = tabla;

                $(document).ready(function(){
                    var table = $('#example').DataTable({
                        responsive: true,
                        buttons:[
                            {
                                text: '<i class="fas fa-plus"></i>',
                                action: function ( e, dt, node, config ) {
                                    document.getElementById('frmCurso').reset();
                                    $("#cursoModal").modal('show');
                                },
                                className: 'btn btn-info data-new'
                            },
                            {
                                extend:    'excelHtml5',
                                text:      '<i class="fas fa-file-excel"></i> ',
                                titleAttr: 'Exportar a Excel',
                                className: 'btn btn-success'
                            },
                            {
                                extend:    'pdfHtml5',
                                text:      '<i class="fas fa-file-pdf"></i> ',
                                titleAttr: 'Exportar a PDF',
                                className: 'btn btn-danger'
                            },
                            {
                                extend:    'print',
                                text:      '<i class="fa fa-print"></i> ',
                                titleAttr: 'Imprimir',
                                className: 'btn btn-warning'
                            }
                        ]
                    });

                    table.buttons().container()
                    .appendTo('#example_wrapper .col-md-6:eq(0)');
                });
            }
        }
    };
    xhr.send();
}