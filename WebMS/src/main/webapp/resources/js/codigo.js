window.onload = function carga() {
	var error = '#{request.getParameter("error")}';
	if(error == 'credenciales') {
		error = 'Usuario o Contraseña Inválidos.';
		alert(error);
		document.getElementById("errorSpan").innerHTML = error;
	}
}

function datosValidos() {
	var usuario = document.getElementById("formLogin:usuario");
	var password = document.getElementById("formLogin:password");
	if (password.value == "") {
		if (usuario.value == "") {
			alert("Ingresa tu usuario y tu password");
			usuario.focus();
			return false;
		}
	} else if (usuario.value == "") {
		alert("Ingresa tu usuario");
		usuario.focus();
		return false;
	}
	if (password.value == "") {
		alert("Ingresa tu contraseña");
		password.focus();
		return false;
	}
	return true;
}

function sendData() {
	if(datosValidos()) {
		var forma = document.getElementById("formLogin");
		forma.action = "j_spring_security_check";
		forma.method = "POST";
		forma.submit();
	}
}
