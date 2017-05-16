<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html >
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <title>Cadastro de Cliente</title>
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>    
        <form action="${pageContext.request.contextPath}/CadastroCliente" method="post">
            <label for="txtnome">Nome:</label>  
            <input type="text" name="nome" placeholder="Insira nome" required/>
            <br>
            <label for="txtcpf">CPF:</label>
            <input type="text" name="cpf" placeholder="Insira cpf" required/>
            <br>
            <label for="txtsexo">Sexo:</label>
            <input type="text" name="sexo" placeholder="Insira sexo" required/>
            <br>
            <label for="txtnascimento">Nascimento:</label>
            <input type="text" name="nascimento" placeholder="Insira nascimento" required/>
            <br>
            <label for="txtrua">Rua:</label>
            <input type="text" name="rua" placeholder="Insira rua" required/>
            <br>
            <label for="txtnumero">Numero:</label>
            <input type="text" name="numero" placeholder="Insira numero" required/>
            <br>
            <label for="txtcomplemento">Complemento:</label>
            <input type="text" name="complemento" placeholder="Insira complemento" />
            <br>
            <label for="txtcep">CEP:</label>
            <input type="text" name="cep" placeholder="Insira cep" required/>
            <br>
            <label for="txtcidade">Cidade:</label>
            <input type="text" name="cidade" placeholder="Insira cidade" required/>
            <br>
            <label for="txtbairro">Bairro:</label>
            <input type="text" name="bairro" placeholder="Insira bairro" required/>
            <br>
            <label for="txttelefone">Telefone:</label>
            <input type="text" name="telefone" placeholder="Insira telefone" />
            <br>
            <label for="txtcelular">Celular:</label>
            <input type="text" name="celular" placeholder="Insira celular" />
            <br>
            <label for="txtemail">Email:</label>
            <input type="text" name="email" placeholder="Insira email" />
            <br>
            <input type="submit" value="Salvar"/>
            <input type="reset" value="Apagar"/>
            <br>
        </form>     
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
