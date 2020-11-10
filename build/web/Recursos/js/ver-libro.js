$(document).ready(function() {
    $("#cant").val(1);
       $("#agregar").click(function(){
           if($("#cant").val()===""){
               Swal.fire(
                    'Bibliote Online',
                    'Debe seleccionar una cantidad de libro',
                    'error'
                 );
           }else{
                $("#modalTipoLibro").modal("show");
                var libroDigital = false;
                var libroFisico = false;
                
                   
                    $("#modalGuardar").click(function(){
                       if($("#1").prop("checked")===true || $("#2").prop("checked")===true){
                        if($("#1").prop("checked")){
                             libroDigital = true; 
                         }else{
                             libroDigital  = false;
                         } 
                         if($("#2").prop("checked")){
                             libroFisico = true;
                         }else{
                             libroFisico = false;
                         }
                     $("#modalTipoLibro").modal("hide");
                     var idLibro = $("#idLibro").val();
                     var cant = $("#cant").val();
                     var accion = "agregar";
                     window.setInterval(
                         $.post("carro",{
                             idLibro,
                             cant,
                             accion,
                             libroDigital,
                             libroFisico
                         },function(res){
                             const Toast = Swal.mixin({
                                 toast: true,
                                 position: 'top-end',
                                 showConfirmButton: false,
                                 timer: 3000
                               });
                              console.log(res);
                               Toast.fire({
                                 icon: 'success',
                                 title: res
                               });  
                               location.reload();
                         }),""    
                     );
                     $("#cant").val(1);
                   }else{
                        Swal.fire(
                             'Bibliote Online',
                             'Debe seleccionar un tipo de libro',
                             'error'
                          );
                          $("#modalTipoLibro").modal("show");
                        }  
                    });
               
           }

       });
    });


