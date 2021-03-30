/*
 *@param null
 *@return
 *@author Tu
 *@description js pour connecter
 *@exception
 *@date 25/03/2021 09:04
*/
function chercherEmail(){
    var xhr = new XMLHttpRequest();
    var email = document.getElementById("idemail").value;
    var url = "../ServletLoginRechercher?email="+email;

    xhr.open("GET", url,true);
    xhr.onload = function(){
        if (xhr.status === 200)
        {
            var elt = document.getElementById("message");

            elt.innerHTML="";
            elt.innerHTML= xhr.responseText;

        }else{
            alert("echec")
        }

    };
    xhr.send();

}

document.addEventListener("DOMContentLoaded", () => {
    document.getElementById("idemail").addEventListener("change",chercherEmail);


});