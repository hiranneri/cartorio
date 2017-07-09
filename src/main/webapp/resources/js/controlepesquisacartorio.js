/**
 * 
 */
window.onload = function(){
	document.getElementById("valor").style.display="none";
	document.getElementById("btnPesquisar").style.display="none";
	
}

function exibeOutros(){
	if(document.getElementById("nome").value="Nome"){
		
		document.getElementById("valor").style.display="inline"
		document.getElementById("btnPesquisar").style.display="inline";
		
	}else if(document.getElementById("cartorios").value="Cartórios"){
		alert('cart');
		document.getElementById("valor").style.visibility="hidden";
		document.getElementById("btnPesquisar").style.display="inline";
		
	}else if(document.getElementById("id").value="ID"){
		
		document.getElementById("valor").style.display="inline"
		document.getElementById("btnPesquisar").style.display="inline";
	}
}

function campoCartorio(){
	
	$(document).ready(function(){
		   $("#cartorios").click(function(evento){
		      if ($("#cartorios").attr('checked','checked')){
		         $("#valor").css("display", "none");
		         $("#btnPesquisar").css("display", "block");
		      }
		   });
		});
}


