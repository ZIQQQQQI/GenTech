/*
 *@param null
 *@return
 *@author Tu
 *@description
 *@exception
 *@date 29/03/2021 08:37
*/
function addProduit(){
    var xhr = new XMLHttpRequest();
    var idp= this.getAttribute("idp");
    var email= this.getAttribute("email");
    var add=this
    var elt = document.getElementById("addPan");
    var count = parseInt(elt.innerHTML);

    if(email!="null"){

        var url = "ServletPanier?idp="+idp+"&email="+email;
        xhr.open("GET", url,true);
        xhr.onload = function(){
            if (xhr.status === 200) {
                count= count+1;
                elt.innerHTML=count.toString();
                add.style.display="none";

            }}
        xhr.send();
    }else {
        alert("S'il vous plait,Connectez-vous d'abord");
    }
}
function supprimerPan(){
    var xhr = new XMLHttpRequest();

    var url = "ServletSupprimerPan?idSupPan="+this.getAttribute("idSupPan");

    //alert(this.getAttribute("idSupPan"));
    var idlistpan = this.getAttribute("idSupPan")+"listpan";
    //alert(idlistpan);

    var elt = document.getElementById("addPan");
    var c = parseInt(elt.innerHTML);
    //alert(c);
    xhr.open("GET", url,true);
    xhr.onload = function(){
        if (xhr.status === 200)
        {
            c= c-1;
            //alert(c);
            var zone = document.getElementById(idlistpan);
            zone.innerHTML="";

            elt.innerHTML=c.toString();
        }

    };
    xhr.send();
}





document.addEventListener("DOMContentLoaded", () => {
/*
    var produitAdd = document.getElementsByName("produidIdAdd");
    for(j =0; produitAdd.length; j++){
        produitAdd[j].addEventListener("click",addProduit);
    }*/

    var tab1 = document.getElementsByName("minusPan");
    for(j =0; j<tab1.length; j++){
        tab1[j].addEventListener("click",supprimerPan);
    }



});