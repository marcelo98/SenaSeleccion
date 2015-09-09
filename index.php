<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>inicio</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href = "SenaSeleccion/css/style1.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->


  </head>
  <body>

  <div class="container">
    <div class="row">
      <div class="col-xs-12">
        <h1>Bienvenidos<small>  </small></h1>   
      </div>
    </div>
  </div>   
    
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
<?php

session_start(); 

$primerav = "hola" ;
$_SESSION['segundav'] = "adios"; 

echo "<a href = registrar.html> <h4>registrar nuevo cliente </h4> </a > ";

echo "<a href = tablaclientes.html> <h4> ver tabla de clientes </h4> </a>"; 

echo "<a href = tablaproductos.html> <h4> ver tabla de productos </h4> </a>"; 

?>

  </body>
</html>