function addPanierProduit(){
    var xhr = new XMLHttpRequest();
    var idp= this.getAttribute("idP");
    var email= this.getAttribute("email");
    //alert(email);
    if(email!="null"){

        var url = "ServletPanierAjouterDetail?idp="+idp+"&email="+email;
        xhr.open("GET", url,true);
        xhr.onload = function(){
            if (xhr.status === 200) {
                if(xhr.responseText=="success"){
                    alert("succe d'ajouter");
                    window.location.href="/GenTech/";
                }else {
                    alert("echec d'ajouter");
            }
        }}
        xhr.send();
    }else{
        alert("S'il vous plait,Connectez-vous d'abord");
    }
}

function addPreProduit(){
    var xhr = new XMLHttpRequest();
    var idp= this.getAttribute("idP");
    var email= this.getAttribute("email");
    //alert(email);
    if(email!="null"){

        var url = "ServletPreAjouterDetail?idp="+idp+"&email="+email;
        xhr.open("GET", url,true);
        xhr.onload = function(){
            if (xhr.status === 200) {
                if(xhr.responseText=="success"){
                    alert("succe d'ajouter");
                    window.location.href="/GenTech/";
                }else {
                    alert("echec d'ajouter");
                }
            }}
        xhr.send();
    }else{
        alert("S'il vous plait,Connectez-vous d'abord");
    }
}

document.addEventListener("DOMContentLoaded", () => {

    document.getElementById("btnaddpanier").addEventListener("click",addPanierProduit);
    document.getElementById("btnaddpre").addEventListener("click",addPreProduit);

})