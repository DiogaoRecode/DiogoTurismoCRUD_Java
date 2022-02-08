<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DIOGO TURISMO CRUD |Lista de Clientes</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#" style="color:yellow">Diogo Turismo</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.html">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="CadastroCreateAndFind">Lista de Clientes</a>
        </li>
      
      </ul>
      <form action="CadastroCreateAndFind" method="GET" class="d-flex">
        <input  name="pesquisa" class="form-control me-2" type="search" placeholder="Digite o Nome ou CPF" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Buscar</button>
      </form>
    </div>
  </div>
</nav>
<br>

<div class="container" style="background:yellow">
  <div class="row">
      <div class ="cold-md-7">
       <hr>
       <h3>Clientes Registrados</h3>
       <hr>
       <table class="table table-striped table-dark">
          <thead>
               <tr>
                   <th>#</th>
                   <th>Nome</th>
                   <th>CPF</th>
                   <th>Email</th>
                   <th>Telefone</th>
                </tr>
           </thead>
             <tbody>
                <c:forEach items="${cadastros}"  var="cadastro">
                <tr>
                    <td>${cadastro.id_cliente}</td>
                    <td>${cadastro.nome}</td>
                    <td>${cadastro.cpf}</td>
                    <td>${cadastro.email}</td>
                    <td>${cadastro.telefone}</td>
                    <td>
                     <a href="CadastroDelete?cadastroId=${cadastro.id_cliente}">Deletar</a> |
                     <a href="CadastroFindAndUpdate?cadastroId=${cadastro.id_cliente}">Atualizar</a>
                     </td>
                </tr>
                </c:forEach>
                </tbody>
        </table>
        <h5><a href="index.html">Voltar para o menu cadastro</a></h5>
     </div>
</div>
 </div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>