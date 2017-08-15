<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Cartórios</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width"/>
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	<link type="text/css" href="<c:url value="/resources/css/icons.css"/>" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/skinblue.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/estilopesquisarcartorio.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/responsive.css"/>"/>
	<script src="<c:url value="/resources/js/jquery-1.9.0.min.js"/>"/></script><!-- the rest of the javascript at the bottom of the document -->
	<script src="<c:url value="/resources/js/controlepesquisacartorio.js"/>"/></script>
	
</head>
<body>
	<div class="grid">
		<div class="row space-bot">
		
		<!--Menu-->
		<div class="c8">
			<nav id="topNav">
			<ul id="responsivemenu">
				
				<li><a href="#">Cartório</a>
				<ul style="display: none;">					
					<li><a href="/desafiocartorios/">Home</a></li>
					<li><a href="/desafiocartorios/cartorio/cadastrar">Cadastrar Cartório</a></li>
					<li><a href="/desafiocartorios/sair">Sair</a></li>
				</ul>
				</li>
				</ul>
			</nav>
		</div>
	</div>
</div>
<!-- HEADER
================================================== -->
<div class="undermenuarea">
	<div class="boxedshadow">
	</div>
	<div class="grid">
		<div class="row"> 
			<div class="c8">
				<p class="titlehead">Cartórios COM VOCÊ - Pesquisar Cartório</p>
			</div>
			<div class="c4">
				<h1 class="titlehead rightareaheader"><i class="icon-map-marker"></i> São Paulo</h1>
			</div>
		</div>
	</div>
</div>
<!-- CONTENT
================================================== -->
<div class="grid">
	<div class="shadowundertop"></div>
		
		<div class="row">
		<section>
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
				      
		
					<form action="/desafiocartorios/cartorio/pesquisar" method="get" id="form_pesquisaCartorio" name="form_pesquisaCartorio">
						<span id="pesquisa">Pesquisar Por:</span> 
						<input type="radio" id="id" name="parametroPesquisa" value="ID" 
							onclick="exibeOutros();">
						<label for="id" onclick="exibeOutros();" id="parametroPesquisa">ID</label>
						
						<input type="radio" id="nome" name="parametroPesquisa" value="Nome" 
							onclick="exibeOutros();">
						<label for="nome" onclick="exibeOutros();" id="parametroPesquisa">Nome<br></label><br>
					 	
					 	
						<input type="search" name="valor" id="valor" placeholder="Busca..." required>
	
			      		<button type="submit" value="Pesquisar" id="btnPesquisar" >Pesquisar</button>
			      	</form>
			      	
			      </div>
			  </div>
		</div>
      </section>
		<c:if test="${cartorio!=null}">
    	<table border="1" id="tabelaCartorios">
    	<thead>
			<tr>
				<th>Nome</th>
				<th>Endereço</th>
				<th>Bairro</th>
				<th>Cidade  </th>
				<th>Estado</th>
				<th>Ação</th>
				<th>Ação</th>
			</tr>
			</thead>
			<tbody>
				<tr>
					<td>${cartorio.nome}</td>
		    		<td>${cartorio.endereco.rua},${cartorio.endereco.numero}</td>
		    		<td>${cartorio.endereco.bairro}</td>
		    		<td>${cartorio.endereco.cidade}</td>
		    		<td>${cartorio.endereco.estado}</td>
		    		<td>
		    			
			    		<a href="<c:url value="/cartorio/editar"/>?id=${cartorio.id}">
			    			<button type="button" class="btn btn-success" value="Editar">Editar</button>
			    		</a>
			    		
		    		</td>
		    		<td>
		    			<a href="<c:url value="/cartorio/excluir"/>?id=${cartorio.id}">
		    				<button type="button" class="btn btn-danger" onclick="return confirm('Deseja realmente excluir ?')" 
		    					value="Excluir" >Excluir</button>
		    			</a>
		    		</td>
			</tbody>
		</table>
		</c:if>
		
			</div>
		</div>
	<!-- FOOTER
================================================== -->
<div id="wrapfooter">
	<div class="grid">
		<div class="row" id="footer">
			<!-- to top button  -->
			<p class="back-top floatright">
				<a href="#top"><span></span></a>
			</p>
			<!-- 1st column -->
			<!-- 2nd column -->
			<!-- 3rd column -->
			<div class="c3">
				<h2 class="title"><i class="icon-envelope-alt"></i> Contact</h2>
				<hr class="footerstress">
				<dl>
					<dt>2536 Zamora Road, Missisipi, 74C</dt>
					<dd><span>Telephone:</span>+1 348 271 9483</dd>
					<dd>E-mail: <a href="more.html">mail@yourweb.com</a></dd>
				</dl>
				<ul class="social-links" style="margin-top:15px;">
					<li class="twitter-link smallrightmargin">
					<a href="#" class="twitter has-tip" target="_blank" title="Follow Us on Twitter">Twitter</a>
					</li>
					<li class="facebook-link smallrightmargin">
					<a href="#" class="facebook has-tip" target="_blank" title="Join us on Facebook">Facebook</a>
					</li>
					<li class="google-link smallrightmargin">
					<a href="#" class="google has-tip" title="Google +" target="_blank">Google</a>
					</li>
					
					
				</ul>
			</div>
			<!-- 4th column -->
			<!-- end 4th column -->
		</div>
	</div>
</div>
<!-- copyright area -->
<div class="copyright">
	<div class="grid">
		<div class="row">
			<div class="c6">
				 Your Name &copy; 2015. All Rights Reserved.
			</div>
			
		</div>
	</div>
</div>

<!-- JAVASCRIPTS
================================================== -->
<!-- all -->
<script src="/resources/js/modernizr-latest.js"></script>

<!-- menu & scroll to top -->
<script src="<c:url value="/resources/js/common.js"/>"> </script>
	
<!-- twitter -->
<script src="/resources/js/jquery.tweet.js"></script>

<!-- cycle -->
<script src="<c:url value="/resources/js/jquery.cycle.js"/>"/></script>

<!-- CALL toggle -->
<script type="text/javascript"> 
  $(document).ready(function () {
	   // ---- FAQs ---------------------------------------------------------------------------------------------------------------
		$('.faqs dd').hide(); // Hide all DDs inside .faqs
		$('.faqs dt').hover(function(){$(this).addClass('hover')},function(){$(this).removeClass('hover')}).click(function(){ // Add class "hover" on dt when hover
		$(this).next().slideToggle('normal'); // Toggle dd when the respective dt is clicked
		}); 
});
</script>
</body>
</html>