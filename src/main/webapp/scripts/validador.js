/**
 * VALIDAÇÃO DE FORMULÁRIO
 */

function validar(){
	let item = frmCadastroCafe.nomeItem.value
	
	if(item == ""){
		alert('Informe o item que irá levar!')
		frmCadastroCafe.nomeItem.focus()
		return false
	}
	else{
		document.forms["frmCadastroCafe"].submit()
		alert('O item adicionado foi: ' + item)
	}
}