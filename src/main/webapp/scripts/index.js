const urlParams = new URLSearchParams(window.location.search);
const deletedParam = urlParams.get('deleted'); 

window.addEventListener('load', () => { 
	if(deletedParam){
		alert("Game was deleted successfully!"); 
	}
});