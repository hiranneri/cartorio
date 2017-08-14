# Cartorios Com VC
Sistema online feito para estudo, que tem a principal função de gerenciar os dados de cartórios. O front-end está sendo desenvolvido em HTML, CSS e JSP, e no backend com as tecnologias Java: Spring MVC, JPA, e a principio está sendo usado o banco de dados MySQL, o sistema também contém serviço REST.

# O que faz?
 - Cadastro de Cartório
 - Pesquisa de Cartório
 - Alteração de Cartório
 - Exclusão de Cartório
 - Listagem dos Cartórios
 - Serviço REST que produz todos os dados dos cartórios em JSON para serem consumidos.

# Requisitos obrigatórios
 - Java 1.8
 - Uma IDE de sua preferência
 - Apache Tomcat 7.0 ou superior
 - MySQL
 - Após instalar o banco é necessário que o script do [banco](https://github.com/hiranneri/cartorio/tree/master/docs) seja executado, ou então, digite o comando:

  <code>CREATE DATABASE db_cartorio;</code>

Se você tem um usuário e senha diferente de "root", "0206", não esqueça de mudar no arquivo persistence.xml

# Serviço REST

<code>Todos os content-type tanto para requests, quanto para responses são em formato JSON. </code>
</br>
<code> 
GET (Produz todos os cartórios) - http://localhost:8080/desafiocartorios/cartorios
</code></br>
<code>
GET (Produz o cartório informado pelo ID) - http://localhost:8080/desafiocartorios/cartorios/{cartorioId}
</code></br>
<code>
POST (Consome um ou mais cartórios, sendo obrigatório a passagem de json's em array) - http://localhost:8080/desafiocartorios/cartorios/
</code></br>

# Link Oficial

Em breve.
