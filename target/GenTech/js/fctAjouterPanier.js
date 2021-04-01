
function addProduit(){

    var idp= this.getAttribute("idp");
    var email= this.getAttribute("email");
    var add=this
    if(email!="null"){

        var xhr = new XMLHttpRequest();
        var url = "ServletPanier?idp="+idp+"&email="+email;
        xhr.open("GET", url,true);
        xhr.onload = function(){
            if (xhr.status === 200) {
              add.style.display="none";

            }}
        xhr.send();
    }else {
        alert("S'il vous plait,Connectez-vous d'abord");
    }
}






document.addEventListener("DOMContentLoaded", () => {

    var produitAdd = document.getElementsByName("produidIdAdd");
    for(j =0; produitAdd.length; j++){
        produitAdd[j].addEventListener("click",addProduit);
    }



});