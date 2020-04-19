function login(){
const formData = new FormData();
let loginInput = document.getElementById("username");
let passInput = document.getElementById("password");

formData.append('username', loginInput.value);
formData.append('password', passInput.value);

fetch('./login', {
  method: 'POST',
  body: formData
})
.then((response) => response.json())
.then((result) => {
  console.log(result);
  if(result != null){
   localStorage.setItem("userData", JSON.stringify(result));
  if(result.userRole == 1){
  
  window.location.href="manager";
  } else if(result.userRole == 2){
  window.location.href="employee";
  }
 
  
  }
  else{
  console.error('your login sucked');
  }
})
.catch((error) => {
  console.error('Error:', error);
});
}