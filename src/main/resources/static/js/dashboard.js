document.addEventListener('DOMContentLoaded', function() {
	var elems1 = document.querySelectorAll('.sidenav');
	var instances1 = M.Sidenav.init(elems1);
	
	
	var elems2 = document.querySelectorAll('select');
    var instances2 = M.FormSelect.init(elems2);
    
    
    var elems3 = document.querySelectorAll('.modal');
    var instances3 = M.Modal.init(elems, options3);
    
});




$(document).ready(function(){
	// SIDENAV
	$('.sidenav').sidenav();
	$('.sidenav').sidenav('open');
});




  $(document).ready(function(){
    $('.modal').modal();
  });
  
  
function executeSwal()   {
  
  Swal.fire(
  'Mantenimiento!',
  'Estamos realizando tareas de mantenimiento, disculpe las molestias!',
  'info'
)
}



			function func() {
				if (document.getElementById('exampleRadios1').checked)
				{
					
					console.log("radio1");
					document.getElementById("inputGroupSelect01").disabled = false;
					document.getElementById("demo1").style = "display: ''';";
					
					document.getElementById("inputGroupSelect02").disabled = true;
					document.getElementById("demo2").style = "display: none;";
					
				}
				if (document.getElementById('exampleRadios2').checked) {
					console.log("radio2");
					document.getElementById("inputGroupSelect01").disabled = true;
					document.getElementById("demo1").style = "display: none;";
					
					document.getElementById("inputGroupSelect02").disabled = false;
					document.getElementById("demo2").style = "display: '';";
				}

			}
			
			
			
			
			
			

			
//Tabla
$(document).ready(function() {
		$('#productList').DataTable({
			 "serverSide": false,
			     "bPaginate": false,
    "bLengthChange": false,
  			 
			"ajax" : {
				url : '/admin/dashboard/producto.txt',
				dataSrc : ''
			},
			
			columns : [ {
				title : '#',
				data : 'id'
			}, {
				title : 'CCODIGOPRODUCTO',
				data : 'cCODIGOPRODUCTO'
			}, {
				title : 'CNOMBREPRODUCTO',
				data : 'cNOMBREPRODUCTO'
			} ]
		});
	});