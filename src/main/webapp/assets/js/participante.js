function listParticipantes(){
    var xhr = new XMLHttpRequest();
    var url = 'http://localhost:8080/participantes';
    xhr.open("GET", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.setRequestHeader('X-PINGOTHER', 'pingpong');
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var json = JSON.parse(xhr.responseText);
            if(json != null){
                data = json;
                var div = document.getElementById("tblparticipantes");
                var tabla = '<table id="example" class="table table-striped table-bordered" style="background-color:white;">'
                    + '<thead class="bg-primary" style="color:white;">'
                    + '<tr><th>Cedula</th><th>Nombre</th><th>Apellido</th><th>Telefono</th><th>Sexo</th>'
                    + '</tr></thead><tbody>';
                data.forEach(e => tabla+="<tr><td><a href='#' onclick='editParticipante("+e.idParticipante+")'>"+e.cedula +"</a></td>"
                    +"<td>"+ e.nombre+"</td>"
                    +"<td>"+ e.apellido+"</td>"
                    +"<td>"+ e.telefono+"</td>"
                    +"<td>"+ e.sexo+"</td>"+ "</tr>"
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
                                    document.getElementById('frmParticipante').reset();
                                    $("#participanteModal").modal('show');
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