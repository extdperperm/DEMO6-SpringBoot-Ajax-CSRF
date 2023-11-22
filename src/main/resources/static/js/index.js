
$(document).ready(function(){
	
	$("#btn1").on("click",function() {
 		
 		let data_nrepeticion = $("#F1Nrep").val();
 		let data_palabra = $("#F2Palabra").val();
 		
 		$("#REjemplo1").html("");
 		
 		$.ajax({
			url: '/ejemplo1',
			method: 'GET',
			data: {numrepe:data_nrepeticion, palabra:data_palabra},
			success: function(resultText){
				$("#REjemplo1").html(resultText);
			},
			error: function(){
				$("#REjemplo1").html('<p>Ha ocurrido un error fatal.</p>');
			}
		 });
 		
 		
	 });
	 
     $("#btn2").on("click",function() {
        let data_nombre = $("#F2Nom").val();
 		let data_fecha = $("#F2Fech").val();
 		let data_hijos = $("#F2Hijos").val();
 		
 		let token = $("meta[name='_csrf']").attr("content");
 		let header = $("meta[name='_csrf_header']").attr("content");
 		
 		$("#REjemplo2").html("<div class=\"waiting\"></div>");
 		
 		$.ajax({
			url: '/ejemplo2', 
			dataType: "json",
			method: 'POST',
			data:   {nom: data_nombre, fecha: data_fecha, hijos: data_hijos},
			beforeSend: request => request.setRequestHeader(header, token),
			success: function(data){
				
				if(data.isError){
	        		$('#REjemplo2').html('<p style="color: red;text-align: center;">Error. Falta algún dato</p>');
	          }else{
	                $('#REjemplo2').html('<table><caption>Datos Personales</caption>'+
	                         			 '<tr>'+
	                         			    '<th>Nombre</th>'+
	                         				'<th>F. Nacimiento</th>'+
	                         				'<th>Hijos</th>'+
	                         			 '</tr>'+
	                         			 '<tr>'+
	                         				 '<td>'+data.nombre+'</td>'+
	                         				 '<td>'+data.fecha+'</td>'+
	                         				 '<td>'+data.numHijos+'</td>'+
	                         			 '</tr>'+
	                         			 '</table>');
	                    }
			},
			error: function(){
				$('#REjemplo2').html('<p style="color: red;text-align: center;">Error Fatal</p>');
			}
			
		 });
 		
    });

})
