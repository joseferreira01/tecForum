/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global google */

$(document).ready(function () {
    $("center").hide();
});
$(document).ready(function () {
    $("#login").click(function () {
        $("#logar").show();
        $("#map").hide();
    });
});
$(document).ready(function(){
    $("#fazercadastro").click(function (){
        $("#logar").hide();
        $("#cadastro").show();
        $("#logar").hide();
    });
});
