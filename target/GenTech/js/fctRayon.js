function afficherRayon(){
    var xhr = new XMLHttpRequest();
    // Requête au serveur avec les paramètres éventuels.
    xhr.open("GET","ServletRayon");


    // On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
    xhr.onload = function()
    {
        // Si la requête http s'est bien passée.
        if (xhr.status === 200)
        {
            //alert("ggggggg");
            // Elément html que l'on va mettre à jour.
            var elt = document.getElementById("listRayon");

            var cate = xhr.responseXML.getElementsByTagName("cat");
            var idcate = xhr.responseXML.getElementsByTagName("idCat");
            for (i = 0; i < cate.length; i++){
                nomC = cate[i].firstChild.nodeValue;

                elt.insertAdjacentHTML('beforeend',"<option>"+nomC+"</option>");
                //alert(idcate[i].firstChild.nodeValue);
            }
            //<a href='#'id='rayon"+idcate[i].firstChild.nodeValue+"' name='rayon'>
/*
            for(j =0; j<cate.length; j++){

                idc = idcate[j].firstChild.nodeValue
                alert("rayon"+idc);
                document.getElementById("rayon"+idc).addEventListener("click",function(){listProduitRayon(idc);});

            }*/

        }
    };

    // Envoie de la requête.
    xhr.send();


}

function listProduitRayon()
    {
        // Objet XMLHttpRequest.
        var xhr = new XMLHttpRequest();
        var myselect = document.getElementById("listRayon").value;
        //alert(myselect);
        var action = "ServletRayonProduit?nomRayon="+myselect;

        xhr.open("GET",action);

        // On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
        xhr.onload = function()
        {
            // Si la requête http s'est bien passée.
            if (xhr.status === 200)
            {
                // Elément html que l'on va mettre à jour.
                var elt = document.getElementById("lproduit");

                elt.innerHTML="";

                var nomproduit = xhr.responseXML.getElementsByTagName("prod");
                var idproduit = xhr.responseXML.getElementsByTagName("idProd");
                for (i = 0; i < nomproduit.length; i++){

                    prodchild = nomproduit[i].firstChild.nodeValue;
                    idprodchild = idproduit[i].firstChild.nodeValue;

                    elt.insertAdjacentHTML('beforeend',"<li style='color:#0066FF'><a name='eachProduit'>"+prodchild+"</a></li>");
                }

                var tab = document.getElementsByName("eachProduit");
                for(j =0; j<tab.length; j++){
                    tab[j].addEventListener("click",afficherStock);

                }
            }
        };

        // Envoie de la requête.
        xhr.send();

    }

    function afficherStock(){
        var xhr = new XMLHttpRequest();

        var url = "ServletStock?nomProduit="+this.innerText;
        //console.log(word);
        xhr.open("GET", url,true);
        xhr.onload = function(){
            if (xhr.status === 200)
            {
                var elt = document.getElementById("rayonprod");

                elt.innerHTML="";
                var produitid = xhr.responseXML.getElementsByTagName("produitid");
                var qteachat = xhr.responseXML.getElementsByTagName("qteachat");
                var date = xhr.responseXML.getElementsByTagName("date");
                var reste = xhr.responseXML.getElementsByTagName("reste");
                var restetotal = xhr.responseXML.getElementsByTagName("restetotal");

                for (i = 0; i < produitid.length; i++){

                    produitidchild = produitid[i].firstChild.nodeValue;
                    qteachatchild = qteachat[i].firstChild.nodeValue;
                    datechild = date[i].firstChild.nodeValue;
                    restechild = reste[i].firstChild.nodeValue;
                    restetotalchild = restetotal[i].firstChild.nodeValue;

                    elt.insertAdjacentHTML('beforeend',"<tr><td>"+produitidchild+"</td>" +
                        "<td>"+qteachatchild+"</td><td>"+datechild+"</td><td>"+restechild+"</td><td>"+restetotalchild+"</td></tr>");
                }

            }else{
                alert("echec")
            }

        };
        xhr.send();
    }



document.addEventListener("DOMContentLoaded", () => {

    document.getElementById("bt_Rayon").addEventListener("click",afficherRayon);
    document.getElementById("listRayon").addEventListener("change",listProduitRayon);


});