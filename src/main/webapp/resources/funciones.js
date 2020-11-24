window.onload = keyFecha;
function keyFecha() {
    var dataKey = "MICLAROA";
    var fecha = new Date(); //Fecha actual
    var mes = fecha.getMonth() + 1; //obteniendo mes
    var dia = fecha.getDate(); //obteniendo dia
    var ano = fecha.getFullYear(); //obteniendo año
    if (dia < 10)
        dia = '0' + dia; //agrega cero si el dia es menor de 10
    if (mes < 10)
        mes = '0' + mes //agrega cero si el mes es menor de 10
    // document.getElementById('fechaActual').value = dataKey + ano + mes + dia;
    document.getElementById('key').value = dataKey + ano + mes + dia;
}


function validaDatos(campo) {
    var usuario = campo.user;
    if (usuario.value == "" || usuario.value == "Digite el usuario.") {
        alert("Debe proporcionar un nombre de usuario");
        usuario.focus();
        usuario.select();
        return false;
    }

    // Se válida si el campo de contraseña esta vacio.
    var pass = campo.key;
    var link = campo.link;

    if (pass == "") {
        alert("Debe ingresar una contraseña");
        pass.focus();
        pass.select();
        return false;
    }
    if (pass.value.length != 16)
    {
        alert("La Contraseña debe tener una longitud de 16 caracteres.\nLogitud actual: " + pass.value.length);
        return false;
    }

    // Se válida si el modo de aplicacion fue selecionado o no.
    var modoApp = campo.modoApp;
    var radioModoApp = false;
    var nameModoAppSelec = "vacio";

    radioModoApp = getRadioButtonSelected(modoApp);
    if (!radioModoApp) {
        alert("Debe seleccionar un Modo de Token en la aplicación.");
        return false;
    } else {
        // Se válida que el/los campos de la opcion seleccionada no esten vacios.
        nameModoAppSelec = getRadioButtonSelectedValue(modoApp);
        switch (nameModoAppSelec) {
            case "Comandos":
                // Verifica si los campos de Serial y ActivityId a cifrar estan vacios o tienen el valor por defecto.
                var textoActivityId = campo.activityId;
                var textoSerial = campo.serial;
                if (textoSerial.value == "") {
                    alert("Debe proporcionar el Serial");
                    textoSerial.focus();
                    textoSerial.select();
                    return false;
                }
                if (textoActivityId.value == "") {
                    alert("Debe proporcionar el ActivityId");
                    textoActivityId.focus();
                    textoActivityId.select();
                    return false;
                }
                document.getElementById("url2-Fila").hidden = true; //Se oculta fila elemento URL2
                break;
            case "Agenda":
                // Verifica si el campo de AreaTexto a cifrar esta vacio o tiene el valor por defecto.
                var textoAppointment = campo.appointment;
                var textoDocUser = campo.documentUser;
                if (textoAppointment.value == "") {
                    alert("Debe proporcionar el Appointment");
                    textoAppointment.focus();
                    textoAppointment.select();
                    return false;
                }
                if (textoDocUser.value == "") {
                    alert("Debe proporcionar un DocumentUser");
                    textoDocUser.focus();
                    textoDocUser.select();
                    return false;
                }
                break;

            case "SoloToken":
                // Verifica si el campo de AreaTexto a cifrar esta vacio o tiene el valor por defecto.
                var textoCifrar = campo.txtForCrypt;
                if (textoCifrar.value == "") {
                    alert("Debe proporcionar un texto para cifrar,\nPor ejemplo: activityId=10102345");
                    textoCifrar.focus();
                    textoCifrar.select();
                    document.getElementById("link").href = "javascript:void(0)";
                    return false;
                }
                document.getElementById("url2-Fila").hidden = true; //Se oculta fila elemento URL2
                break;
            default:
                alert("Opcion seleccionada es: " + nameRadio);
        }

    }

    document.getElementById("url").hidden = false;
    document.getElementById("txtCrypt").hidden = false;
    document.getElementById("link").text = "URL CIFRADA";
    document.getElementById("link2").text = "URL CIFRADA";

    // Si todas las validaciones anteriores son exitosas, 
    // entonces se procede a enviar los datos del formulario
    // al request de tipo post.
    return true;
}


function verKey(campo) {
    var tipo = campo.key;
    var btn = campo.btnKey;
    if (tipo.type == "password") {
        tipo.type = "text";
        btn.innerText = "Ocultar...";
    } else {
        tipo.type = "password";
        btn.innerText = "Ver Clave";
    }
}


function limpia(campo) {
    var lblUrl = campo.url;
    var lblUrl2 = campo.url2;
    var sn = document.getElementById("serial");
    var activityId = campo.activityId;
    var txtForCrypt = campo.txtForCrypt;
    sn.value = "";
    activityId.value = "";
    txtForCrypt.value = "";
    document.getElementById("url").hidden = true;
    document.getElementById("url2-Fila").hidden = true; //Se oculta fila elemento URL2
    document.getElementById("link").text = "";
    document.getElementById("link2").text = "";
}


function getRadioButtonSelected(ctrl)
{
    for (i = 0; i < ctrl.length; i++)
        if (ctrl[i].checked)
            return true;
}

function getRadioButtonSelectedValue(ctrl)
{
    for (i = 0; i < ctrl.length; i++)
        if (ctrl[i].checked)
            return ctrl[i].value;
}

function opcionModoApp(campo) {
    var opc = campo.modoApp;
    var txtForCrypt = campo.txtForCrypt;
    var radioSelec = false;
    var nameRadio = "vacio";
    txtForCrypt.value = "";

    radioSelec = getRadioButtonSelected(opc);
    if (!opc) {
        alert("Debe seleccionar un Modo de Token en la aplicación.");
        return false;
    }

    nameRadio = getRadioButtonSelectedValue(opc);
    switch (nameRadio) {
        case "Comandos":
            toggler("1");
            break;

        case "Agenda":
            toggler("2");
            break;

        case "SoloToken":
            toggler("3");
            break;

        default:
            log("Debe revisar las opciones de Modo de Aplicación.");
    }


    function toggler(idClase) {
        var elemC1a = document.getElementById('filaC1a');
        var elemC1b = document.getElementById('filaC1b');
        var elemA1a = document.getElementById('filaA1a');
        var elemA1b = document.getElementById('filaA1b');
        var elemT1a = document.getElementById('filaT1a');


        switch (idClase) {
            case "1":
                event.shiftKey;
                elemC1a.style.display = 'block';
                elemC1b.style.display = 'block';
                elemA1a.style.display = 'none';
                elemA1b.style.display = 'none';
                elemT1a.style.display = 'none';
                document.getElementById("url2-Fila").hidden = true; //Se oculta fila elemento URL2
                break;
            case "2":
                event.shiftKey;
                elemC1a.style.display = 'none';
                elemC1b.style.display = 'none';
                elemA1a.style.display = 'block';
                elemA1b.style.display = 'block';
                elemT1a.style.display = 'none';
                document.getElementById("url2-Fila").hidden = false; //Se deja visible fila de elemento URL2
                break;
            case "3":
                event.shiftKey;
                elemC1a.style.display = 'none';
                elemC1b.style.display = 'none';
                elemA1a.style.display = 'none';
                elemA1b.style.display = 'none';
                elemT1a.style.display = 'block';
                document.getElementById("url2-Fila").hidden = true; //Se oculta fila elemento URL2
            default:
                log("Debe revisar las opciones.");
        }
    }
}
