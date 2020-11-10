$(document).ready(function(){
    $(".eliminar").click(function(){
        var idLibro = $(this).attr("id");
        var accion = "eliminar";
        
        window.setInterval(
           $.post("carro",{
                idLibro,
                accion
            },function (res) {
                const Toast = Swal.mixin({
                    toast: true,
                    position: 'top-end',
                    showConfirmButton: false,
                    timer: 2000
                });
                Toast.fire({
                    icon: 'success',
                    title: res
                });

            }),
            "2000"
        );
        $(this).closest('tr').remove(); 
        location.reload();
    });
    
    $(".cant").change(function(){
       var idLibro = $(this).attr("data-id");
       var cant = $(this).val();
       var accion = "update";
       
       if(cant<=0){
          $(this).val(1);
       }else{
           $.post("carro",{
               idLibro,
               cant,
               accion
            },function(res){
                if(res!==""){
                   const Toast = Swal.mixin({
                        toast: true,
                        position: 'top-end',
                        showConfirmButton: false,
                        timer: 2000
                    });
                    Toast.fire({
                        icon: 'error',
                        title: res
                    }); 
                }
                location.reload();
            });
       }
       
    });
    
    $(".cant").keydown(function(){
        return false;
    })
});


