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
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/responsive.css"/>"/>
	<script src="<c:url value="/resources/js/jquery-1.9.0.min.js"/>"/></script><!-- the rest of the javascript at the bottom of the document -->
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
					<li><a href="/desafiocartorios/index">Home</a></li>
					<li><a href="/desafiocartorios/cartorio/pesquisa">Pesquisar Cartório</a></li>
					
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
				<p class="titlehead">Cartórios COM VOCÊ - Editar Cartório</p>
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
			(*) Campos Obrigatórios
			<br><br>
			<form:form method="POST" modelAttribute="cartorio" action="/desafiocartorios/cartorio/cadastrar">
				<form:label path="id">ID:</form:label>
				<form:input path="id" readonly="true"/>
				<br>
				<form:label path="nome">Nome:</form:label>
				<form:input path="nome" />
				<br>
				<form:label path="endereco.rua">Endereço:</form:label>
				<form:input path="endereco.rua"/>
				<br>
				<form:label path="endereco.numero">Número</form:label>
				<form:input type="number" path="endereco.numero"/>
				<br>
				<form:label path="endereco.cidade">Cidade</form:label>
				<form:input path="endereco.cidade"/>
				<br>
				<form:label path="endereco.bairro">Bairro</form:label>
				<form:input path="endereco.bairro"/>
				<br>
				<form:label path="endereco.estado">Estado</form:label>
				<form:input path="endereco.estado"/>
				<br>
				
				
				<button type="submit" value="Salvar">Salvar</button>
				
			</form:form>
		</div>
		
		
		
</div><!-- end grid -->
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
					<dt>Avenida Paulista, 7654</dt>
					<dd><span>Telephone:</span>11 3456-7899</dd>
					<dd>E-mail: <a href="more.html">cartorios@cartorio.com</a></dd>
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


<!-- JAVASCRIPTS
================================================== -->
<!-- all -->
<script src="/resources/js/modernizr-latest.js"></script>

<!-- menu & scroll to top -->
<script src="<c:url value="/resources/js/common.js"/>"/></script>
	
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